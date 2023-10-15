package com.app.counselawb.controller;


import com.app.counselawb.domain.dto.LawyerFieldDTO;
import com.app.counselawb.domain.vo.LawyerVO;
import com.app.counselawb.service.LawyerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/mypage-lawyer/*")
public class LawyerMypageController {
    private final LawyerService lawyerService;

    // 변호사 마이페이지 가기
    @GetMapping("mypage-lawyer")
    public String GoToMypageLawyer(HttpSession session, Model model) {
        if (session.getAttribute("lawyer") == null) {
            return "/client-login/client-login";
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
        List<LawyerFieldDTO> foundFields = lawyerService.findFieldsByLawyerId(lawyerId);
        foundFields.forEach((field) -> {
            sb.append(field.getFieldTitle()).append(", ");
        });
        sb.deleteCharAt(sb.length()-1).deleteCharAt(sb.length()-1);
        model.addAttribute("fields", sb.toString());
        int phoneCount = lawyerService.findPhoneCountByLawyerId(lawyerId);
        int videoCount = lawyerService.findVideoCountByLawyerId(lawyerId);
        int visitCount = lawyerService.findVisitCountByLawyerId(lawyerId);
        model.addAttribute("phoneCount", phoneCount);
        model.addAttribute("videoCount", videoCount);
        model.addAttribute("visitCount", visitCount);
        int replyCount = lawyerService.findReplyCountByLawyerId(lawyerId);
        model.addAttribute("replyCount", replyCount);
        return "/mypage/mypage-lawyer";
    }

    // 변호사 정보 변경 페이지 가기
    @GetMapping("info-update")
    public String GoToInfoUpdate(HttpSession session, Model model){
        if (session.getAttribute("lawyer") == null){
            return "/client-login/client-login";
        }
        model.addAttribute("passwordErrorMsg", null);
        return "/mypage/info-update-lawyer";
    }


    // 비밀번호 변경
    @PostMapping("info-update-pw")
    public RedirectView changePwAndGoToMypage(HttpSession session, @RequestParam("oldPassword") String oldPassword,
                                              @RequestParam("newPassword") String newPassword){
        LawyerVO currentLawyer = (LawyerVO) session.getAttribute("lawyer");
        if (!currentLawyer.getLawyerPassword().equals(oldPassword)){
            return new RedirectView("/mypage-lawyer/info-update-pw-error");
        }
        currentLawyer.setLawyerPassword(newPassword);
        lawyerService.revisePw(currentLawyer);
        session.removeAttribute("lawyer");
        session.setAttribute("lawyer", currentLawyer);
        return new RedirectView("/mypage-lawyer/mypage-lawyer");
    }

    // 비밀번호 변경 시 기존 비밀번호와 일치하지 않을 때
    @GetMapping("info-update-pw-error")
    public String oldPwError(HttpSession session, LawyerVO lawyerVO, Model model){
        String passwordErrorMsg = "기존 비밀번호와 일치하지 않습니다.";
        model.addAttribute("passwordErrorMsg", passwordErrorMsg);
        return "/mypage/info-update-lawyer";
    }

    // 전화번호 변경
    @PostMapping("info-update-phone")
    public RedirectView changePhoneAndGoToMyPage(HttpSession session, @RequestParam("phone") String lawyerPhone){
        LawyerVO currentLawyer = (LawyerVO) session.getAttribute("lawyer");
        currentLawyer.setLawyerPhone(lawyerPhone);
        lawyerService.revisePhone(currentLawyer);
        session.removeAttribute("lawyer");
        session.setAttribute("lawyer", currentLawyer);
        return new RedirectView("/mypage-lawyer/mypage-lawyer");
    }


}
