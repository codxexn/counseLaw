package com.app.counselawb.controller;


import com.app.counselawb.domain.dto.ConsultDetailDTO;
import com.app.counselawb.domain.dto.ConsultingCaseDTO;
import com.app.counselawb.domain.dto.MyFavoriteConsultDTO;
import com.app.counselawb.domain.pagination.Pagination;
import com.app.counselawb.domain.vo.ConsultingCaseVO;
import com.app.counselawb.domain.vo.LawyerVO;
import com.app.counselawb.domain.vo.MemberVO;
import com.app.counselawb.service.ConsultingCaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/consult-detail/*")
public class ConsultDetailController {

    private final ConsultingCaseService consultingCaseService;

    @GetMapping("/{consultId}")
    public String goToConsultationDetail(HttpSession session, @PathVariable Long consultId, Model model, Pagination pagination, MemberVO memberVO, LawyerVO lawyerVO){

        if (session.getAttribute("member") == null && session.getAttribute("lawyer") == null){
            return "client-login/client-login";
        }
//        상담 상세 페이지의 consultId, 제목 ,내용, 시간등
        List<ConsultingCaseVO> consultDetail = consultingCaseService.readDetails(consultId);
//        변호사의 답변은 따로 받아온다.
        List<ConsultDetailDTO> readLawyer = consultingCaseService.readLawyer(consultId);
//        caseId별로 조회수 받아온다.
        int viewCount = consultingCaseService.readCountById(consultId);
//        변호사 답변의 개수
        Integer totalCount = consultingCaseService.countTotalReply(consultId);
//        다른 상담사례 보기에 넣을 상담사례
        List<ConsultingCaseDTO> consultCase = consultingCaseService.readMoreConsult();
//        해결사례 더보기를 위한 조회
        List<ConsultDetailDTO> readSolution = consultingCaseService.selectSolutionCase();

//        log.info(readLawyer.toString());
        consultingCaseService.increaseViewCount(consultId);
        model.addAttribute("readSolution",readSolution);
        model.addAttribute("consultCase",consultCase);
        model.addAttribute("viewCount",viewCount);
        model.addAttribute("consultDetail",consultDetail);
        model.addAttribute("readLawyer",readLawyer);
        model.addAttribute("totalCount",totalCount);
        log.info("상세 페이지");
//        관심글 설정 여부
        if(session.getAttribute("member") != null){
            MemberVO currentMember = (MemberVO) session.getAttribute("member");
            log.info(currentMember.toString());
            Long memberId = currentMember.getMemberId();
            log.info("memberId={}",memberId);
            Optional<MyFavoriteConsultDTO> foundLike = consultingCaseService.readMyFavorite(memberId, consultId);
            log.info("true? {}", foundLike);
            if(foundLike.isPresent()){
                model.addAttribute("ifChecked","true");
            }else {
                model.addAttribute("ifChecked","false");
            }
        }
        else {
            model.addAttribute("ifChecked","false");
        }
        return "consult-detail/consult-detail";
    }

    @GetMapping("like")
    @ResponseBody
    public String saveMyFavorite(@RequestParam Long consultingCaseId, @RequestParam("memberId") Long memberId){
        Optional<MyFavoriteConsultDTO> foundLike = consultingCaseService.readMyFavorite(memberId, consultingCaseId);
        if(foundLike.isPresent()){
            log.info("fail");
            return "fail";
        }
        log.info("foundLike={}",foundLike);
        MyFavoriteConsultDTO myFavoriteConsultDTO = new MyFavoriteConsultDTO();

        myFavoriteConsultDTO.setMemberId(memberId);
        log.info("memberId={}",memberId);

        myFavoriteConsultDTO.setConsultingCaseId(consultingCaseId);
        log.info("consultingCaseId={}",consultingCaseId);

//      caseId에 해당하는 관심글의 정보 조회후 DTO에 삽입
        log.info("정보 조회하기");
        MyFavoriteConsultDTO findByConsultId = consultingCaseService.readFavoriteCases(consultingCaseId);
        log.info("findByConsultId={}", findByConsultId);

        myFavoriteConsultDTO.setConsultingCaseTitle(findByConsultId.getConsultingCaseTitle());
        log.info("consultingCaseTitle={}",findByConsultId.getConsultingCaseTitle());

        myFavoriteConsultDTO.setLawyerReplyCount(findByConsultId.getLawyerReplyCount());
        log.info("replyCount={}",findByConsultId.getLawyerReplyCount());

        myFavoriteConsultDTO.setViewCount(findByConsultId.getViewCount());
        log.info("viewCount={}",findByConsultId.getViewCount());

        log.info("저장될 내용 = {}", myFavoriteConsultDTO);

        consultingCaseService.storeFavoriteCases(myFavoriteConsultDTO);
        log.info("success");
        return "success";
    }

    @GetMapping("delete")
    @ResponseBody
    public String deleteMyFavorite(@RequestParam Long consultingCaseId, @RequestParam("memberId") Long memberId){
        log.info("caseId={}",consultingCaseId);
        log.info("memberId={}",memberId);
        Optional<MyFavoriteConsultDTO> foundLike = consultingCaseService.readMyFavorite(memberId, consultingCaseId);
        if(foundLike.isPresent()){
            consultingCaseService.deleteFavorite(memberId, consultingCaseId);
            return "success";
        }
        return "fail";
    }
//
//    @PostMapping("/{consultId}")
//    public void  saveDetail(@RequestParam String caseTitle,
//                                             @RequestParam Long viewCount,
//                                             @RequestParam Long lawyerReplyCount,
////                                             @RequestParam LocalDate createDate,
//                                             @RequestParam Long caseId,
//                                             @RequestParam("memberId") Long memberId,
//                            @PathVariable Long consultId
//                                             ){
//        log.info("데이터 전송");
//        MyFavoriteConsultDTO myFavoriteConsultDTO = new MyFavoriteConsultDTO();
//        myFavoriteConsultDTO.setConsultingCaseId(caseId);
//        myFavoriteConsultDTO.setConsultingCaseTitle(caseTitle);
////        myFavoriteConsultDTO.setCreateDate(createDate);
//        myFavoriteConsultDTO.setViewCount(viewCount);
//        myFavoriteConsultDTO.setLawyerReplyCount(lawyerReplyCount);
//        myFavoriteConsultDTO.setMemberId(memberId);
//        consultingCaseService.storeFavoriteCases(myFavoriteConsultDTO);
//    }
}
