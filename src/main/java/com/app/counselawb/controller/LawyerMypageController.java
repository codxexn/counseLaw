package com.app.counselawb.controller;


import com.app.counselawb.domain.dto.*;
import com.app.counselawb.domain.pagination.Pagination;
import com.app.counselawb.domain.vo.*;
import com.app.counselawb.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/mypage-lawyer/*")
public class LawyerMypageController {
    private final LawyerService lawyerService;
    private final LocationService locationService;
    private final LawyerMyPostsService lawyerMyPostsService;
    private final ConsultingCaseService consultingCaseService;
    private final ReservationService reservationService;

    // 변호사 마이페이지 가기
    @GetMapping("mypage-lawyer")
    public String GoToMypageLawyer(HttpSession session, Model model, MemberVO memberVO, LawyerVO lawyerVO) {
        if (session.getAttribute("lawyer") == null) {
            return "client-login/client-login";
        }
        StringBuilder sb = new StringBuilder();
        LawyerVO currentLawyer = (LawyerVO) session.getAttribute("lawyer");
        model.addAttribute("currentLawyer", currentLawyer);
        Long lawyerId = currentLawyer.getLawyerId();
        int scCount = lawyerService.findSCTotalByLawyerId(lawyerId);
        int lgCount = lawyerService.findLGTotalByLawyerId(lawyerId);
        int favCount = lawyerService.findFavTotalByLawyerId(lawyerId);
        model.addAttribute("scCount", scCount);
        model.addAttribute("lgCount", lgCount);
        model.addAttribute("favCount", favCount);
        List<ExperienceVO> foundExperiences = lawyerService.findCareersByLawyerId(lawyerId);
        model.addAttribute("careers", foundExperiences);
        List<LawyerFieldDTO> foundFields = lawyerService.findFieldsByLawyerId(lawyerId);
        for (int i=0; i < foundFields.size(); i++){
            sb.append(foundFields.get(i).getFieldTitle());
            if (i < foundFields.size()-1) sb.append(", ");
        }
        model.addAttribute("fields", sb.toString());
        sb = new StringBuilder();
        List<LawyerLocationDTO> foundLocations = locationService.findLocationsByLawyerId(lawyerId);
        for (int i=0; i < foundLocations.size(); i++){
            sb.append(foundLocations.get(i).getLocationName());
            if (i < foundLocations.size()-1) sb.append(", ");
        }
        model.addAttribute("locations", sb.toString());
        int phoneCount = lawyerService.findPhoneCountByLawyerId(lawyerId);
        int videoCount = lawyerService.findVideoCountByLawyerId(lawyerId);
        int visitCount = lawyerService.findVisitCountByLawyerId(lawyerId);
        model.addAttribute("phoneCount", phoneCount);
        model.addAttribute("videoCount", videoCount);
        model.addAttribute("visitCount", visitCount);
        int replyCount = lawyerService.findReplyCountByLawyerId(lawyerId);
        model.addAttribute("replyCount", replyCount);
        return "mypage/mypage-lawyer";
    }

    // 변호사 정보 변경 페이지 가기
    @GetMapping("info-update")
    public String GoToInfoUpdate(HttpSession session, Model model, MemberVO memberVO, LawyerVO lawyerVO){
        if (session.getAttribute("lawyer") == null){
            return "client-login/client-login";
        }
        LawyerVO lawyer = (LawyerVO) session.getAttribute("lawyer");
        Long lawyerId = lawyer.getLawyerId();
        List<LawyerFieldDTO> foundFields = lawyerService.findFieldsByLawyerId(lawyerId);
        List<Long> foundFieldIds = new ArrayList<>();
        foundFields.forEach((field) -> {
            foundFieldIds.add(field.getFieldId());
        });
        model.addAttribute("fields", foundFieldIds);
        List<LawyerLocationDTO> foundLocations = locationService.findLocationsByLawyerId(lawyerId);
        List<Long> foundLocationIds = new ArrayList<>();
        foundLocations.forEach((location) -> {
            foundLocationIds.add(location.getLocationId());
        });
        model.addAttribute("locations", foundLocationIds);
        List<ExperienceVO> foundCareers = lawyerService.findCareersByLawyerId(lawyerId);
        model.addAttribute("careerList", foundCareers);
        List<FieldVO> fieldList = lawyerService.findAllFields();
        model.addAttribute("fieldList", fieldList);
        List<LocationVO> locationList = locationService.findAllLocations();
        model.addAttribute("locationList", locationList);
        model.addAttribute("passwordErrorMsg", null);
        String lawyerProfile = lawyerService.findProfileImage(lawyerId);
        model.addAttribute("lawyerImage", lawyerProfile);
        return "mypage/info-update-lawyer";
    }

    // 프사 변경
    @PostMapping("info-update-profile")
    public RedirectView uploadProfileImage(@RequestParam("lawyerId") Long lawyerId,
                                           MultipartHttpServletRequest mhsr, HttpSession session) throws Exception{
        MultipartFile image = mhsr.getFile("file");
        if (image != null){
            LawyerVO lawyerVO = new LawyerVO();
            lawyerVO.setLawyerId(lawyerId);
            String originFileName = image.getOriginalFilename();
            String fileNameExtension = FilenameUtils.getExtension(originFileName).toLowerCase();
            String absolutePath = "/usr/upload";
            String fileUrl = "/lawyer-profile-images/";
            File destinationFile;
            String destinationFileName;
            do {
                destinationFileName = RandomStringUtils.randomAlphanumeric(32) + "." + fileNameExtension;
                destinationFile = new File(absolutePath + fileUrl + destinationFileName);
            } while (destinationFile.exists());

            destinationFile.getParentFile().mkdirs();
            image.transferTo(destinationFile);

            lawyerVO.setLawyerImage("/image/res" + fileUrl + destinationFileName);
            lawyerService.reviseProfileImage(lawyerVO);
            Optional<LawyerVO> newLawyer = lawyerService.findByLawyerId(lawyerId);
            if (newLawyer.isPresent()){
                session.removeAttribute("lawyer");
                session.setAttribute("lawyer", newLawyer.get());
            }
        }
        return new RedirectView("/mypage-lawyer/info-update");
    }

    // 프사 삭제
    @GetMapping("delete-profile")
    public RedirectView deleteProfileImage(HttpSession session){
        LawyerVO currentLawyer = (LawyerVO) session.getAttribute("lawyer");
        Long lawyerId = currentLawyer.getLawyerId();
        lawyerService.discardProfileImage(lawyerId);
        currentLawyer.setLawyerImage(null);
        session.removeAttribute("lawyer");
        session.setAttribute("lawyer", currentLawyer);
        return new RedirectView("/mypage-lawyer/info-update");
    }


    // 비밀번호 변경
    @PostMapping("info-update-pw")
    public RedirectView changePw(HttpSession session, @RequestParam("oldPassword") String oldPassword,
                                 @RequestParam("newPassword") String newPassword){
        LawyerVO currentLawyer = (LawyerVO) session.getAttribute("lawyer");
        if (!currentLawyer.getLawyerPassword().equals(oldPassword)){
            return new RedirectView("/mypage-lawyer/info-update-pw-error");
        }
        currentLawyer.setLawyerPassword(newPassword);
        lawyerService.revisePw(currentLawyer);
        session.removeAttribute("lawyer");
        session.setAttribute("lawyer", currentLawyer);
        return new RedirectView("/mypage-lawyer/info-update");
    }

    // 비밀번호 변경 시 기존 비밀번호와 일치하지 않을 때
    @GetMapping("info-update-pw-error")
    public String oldPwError(HttpSession session, LawyerVO lawyerVO, Model model){
        String passwordErrorMsg = "기존 비밀번호와 일치하지 않습니다.";
        model.addAttribute("passwordErrorMsg", passwordErrorMsg);
        return "mypage/info-update-lawyer";
    }

    // 전화번호 변경
    @PostMapping("info-update-phone")
    public RedirectView changePhone(HttpSession session, @RequestParam("phone") String lawyerPhone){
        LawyerVO currentLawyer = (LawyerVO) session.getAttribute("lawyer");
        currentLawyer.setLawyerPhone(lawyerPhone);
        lawyerService.revisePhone(currentLawyer);
        session.removeAttribute("lawyer");
        session.setAttribute("lawyer", currentLawyer);
        return new RedirectView("/mypage-lawyer/info-update");
    }

    // 변호사 정보 업데이트
    @PostMapping("info-update-info")
    public RedirectView changeInfo(HttpSession session, @RequestParam("company") String lawyerCompany,
                                   @RequestParam("address") String lawyerAddress, @RequestParam("school") String lawyerEducation,
                                   @RequestParam("callPrice") int callPrice, @RequestParam("videoPrice") int videoPrice, @RequestParam("visitPrice") int visitPrice,
                                   @RequestParam("introduction") String lawyerIntroduction, @RequestParam("qualification") String lawyerQualification,
                                   @RequestParam("eachField") List<Long> checkedFieldIds, @RequestParam("eachLocation") List<Long> checkedLocationIds){
        LawyerVO currentLawyer = (LawyerVO) session.getAttribute("lawyer");
        LawyerLocationVO lawyerLocationVO = new LawyerLocationVO();
        currentLawyer.setLawyerIntroduction(lawyerIntroduction);
        currentLawyer.setLawyerQualification(lawyerQualification);
        currentLawyer.setLawyerCompany(lawyerCompany);
        currentLawyer.setLawyerAddress(lawyerAddress);
        currentLawyer.setLawyerEducation(lawyerEducation);
        currentLawyer.setCallPrice(callPrice);
        currentLawyer.setVideoPrice(videoPrice);
        currentLawyer.setVisitPrice(visitPrice);
        Long currentLawyerId = currentLawyer.getLawyerId();
        lawyerService.reviseLawyerInfo(currentLawyer);
        lawyerService.discardLawyerFields(currentLawyerId);
        checkedFieldIds.forEach((fieldId) -> {
            lawyerService.saveLawyerFields(fieldId, currentLawyerId);
        });
        locationService.discardLocationsByLawyerId(currentLawyerId);
        lawyerLocationVO.setLawyerId(currentLawyerId);
        checkedLocationIds.forEach((locationId) -> {
            lawyerLocationVO.setLocationId(locationId);
            locationService.saveLocationsByLawyerId(lawyerLocationVO);
        });
        session.removeAttribute("lawyer");
        session.setAttribute("lawyer", currentLawyer);
        return new RedirectView("/mypage-lawyer/info-update");
    }

    // 변호사 경력 개별 삭제
    @PostMapping("info-update-career-delete")
    public RedirectView deleteCareer(HttpSession session, @RequestParam("experienceId") Long experienceId){
        lawyerService.discardExperienceByExperienceId(experienceId);
        return new RedirectView("/mypage-lawyer/info-update");
    }

    // 변호사 경력 추가
    @PostMapping("info-update-career")
    public RedirectView insertCareer(HttpSession session, @RequestParam("startYear") int startYear, @RequestParam("lawyerId") Long lawyerId,
                                     @RequestParam("endYear") int endYear, @RequestParam("experienceContent") String experienceContent){
        ExperienceVO experienceVO = new ExperienceVO();
        experienceVO.setLawyerId(lawyerId);
        experienceVO.setStartYear(startYear);
        experienceVO.setEndYear(endYear);
        experienceVO.setExperienceContent(experienceContent);
        lawyerService.saveExperience(experienceVO);
        return new RedirectView("/mypage-lawyer/info-update");
    }

    // 내 법률가이드
    @GetMapping("my-legal-guide")
    public String myLegalGuide(@RequestParam("lawyerId") Long lawyerId, Model model, HttpSession session,
                               Pagination pagination){
        int lgCount = lawyerService.findLGTotalByLawyerId(lawyerId);
        pagination.setTotal(lgCount);
        pagination.progress();
        model.addAttribute("pagination", pagination);
        model.addAttribute("lawyerId", lawyerId);
        List<LegalGuideDTO> legalGuideWithDetail = lawyerMyPostsService.findMyLegalGuideWithDetail(pagination, lawyerId);
        String lawyerName = legalGuideWithDetail.get(0).getLawyerName();
        model.addAttribute("lawyerName", lawyerName);
        model.addAttribute("legalGuideWithDetail", legalGuideWithDetail);
        String lawyerImage = lawyerService.findProfileImage(lawyerId);
        model.addAttribute("lawyerImage", lawyerImage);
        return "lawyer-my-posts/my-legal-guide";
    }

    // 내 해결사례
    @GetMapping("my-solution-case")
    public String mySolutionCase(@RequestParam("lawyerId") Long lawyerId, Model model, HttpSession session,
                                 Pagination pagination){
        int scCount = lawyerService.findSCTotalByLawyerId(lawyerId);
        pagination.setTotal(scCount);
        pagination.progress();
        model.addAttribute("pagination", pagination);
        model.addAttribute("lawyerId", lawyerId);
        List<SolutionCaseDTO> solutionCases = lawyerMyPostsService.findMySolutions(pagination, lawyerId);
        String lawyerName = solutionCases.get(0).getLawyerName();
        model.addAttribute("lawyerName", lawyerName);
        model.addAttribute("solutionCases", solutionCases);
        String lawyerImage = lawyerService.findProfileImage(lawyerId);
        model.addAttribute("lawyerImage", lawyerImage);
        return "lawyer-my-posts/my-solution-case";
    }

    // 나를 즐겨찾기한 의뢰인
    @GetMapping("liked-clients")
    public String myFollowers(@RequestParam("lawyerId") Long lawyerId, Model model, HttpSession session,
                              Pagination pagination){
        int favCount = lawyerService.findFavTotalByLawyerId(lawyerId);
        pagination.setTotal(favCount);
        pagination.progress();
        model.addAttribute("pagination", pagination);
        model.addAttribute("lawyerId", lawyerId);
        List<LawyerLikeVO> myLikes = lawyerMyPostsService.findMyFollowers(pagination, lawyerId);
        List<MemberVO> myFollowers = new ArrayList<>();
        myLikes.forEach((like) -> {
            Optional<MemberVO> foundFollowerInfo = lawyerMyPostsService.findFollowerInfo(like.getMemberId());
            if (foundFollowerInfo.isPresent()){
                myFollowers.add(foundFollowerInfo.get());
            }
        });
        model.addAttribute("followers", myFollowers);
        return "lawyer-my-posts/my-followers";
    }

    // 내 상담사례 (내가 답글 남긴 상담사례)
    @GetMapping("my-consultation")
    public String myConsultation(@RequestParam("lawyerId") Long lawyerId, Model model, HttpSession session,
                                 Pagination pagination){
        int replyCount = lawyerService.findReplyCountByLawyerId(lawyerId);
        pagination.setTotal(replyCount);
        pagination.progress();
        model.addAttribute("pagination", pagination);
        model.addAttribute("lawyerId", lawyerId);
        List<LawyerReplyDTO> myCRs = lawyerMyPostsService.findMyCasesAndReplies(pagination, lawyerId);
        model.addAttribute("myCRs", myCRs);
        Optional<LawyerVO> foundLawyer = lawyerService.findByLawyerId(lawyerId);
        if (foundLawyer.isPresent()) {
            LawyerVO lawyer = foundLawyer.get();
            String lawyerName = lawyer.getLawyerName();
            model.addAttribute("lawyerName", lawyerName);
        } else {
            model.addAttribute("lawyerName", null);
        }
        List<LawyerSidebarDTO> getLawyers = consultingCaseService.getLawyers();
        model.addAttribute("getLawyers", getLawyers);
        return "lawyer-my-posts/my-consulting-case";
    }

    // 변호사 회원탈퇴
    @GetMapping("withdraw-lawyer")
    public String goToWithdraw(HttpSession session){
        if (session.getAttribute("lawyer") == null) {
            return "client-login/client-login";
        }
        return "mypage/withdraw-lawyer";
    }

    // 실제 회원탈퇴
    @GetMapping("withdraw")
    @ResponseBody
    public String withdraw(@RequestParam("lawyerId") Long lawyerId){
        try {
            lawyerService.discardSCByLawyerId(lawyerId);
            lawyerService.discardLGByLawyerId(lawyerId);
            lawyerService.discardCareerByLawyerId(lawyerId);
            lawyerService.discardFieldByLawyerId(lawyerId);
            lawyerService.discardLocationByLawyerId(lawyerId);
            lawyerService.discardLawyerLikeByLawyerId(lawyerId);
            lawyerService.discardReplyByLawyerId(lawyerId);
            lawyerService.deleteLawyerReservation(lawyerId);
            lawyerService.discardLawyer(lawyerId);
            return "success";
        } catch (Exception e){
            log.info("{}", e.getMessage());
            return "fail";
        }

    }

}