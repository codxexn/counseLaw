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

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/consult-detail/*")
public class ConsultDetailController {

    private final ConsultingCaseService consultingCaseService;

    @GetMapping("/{consultId}")
    public String goToConsultationDetail(HttpSession session, @PathVariable Long consultId, Model model, Pagination pagination, MemberVO memberVO, LawyerVO lawyerVO){

        if (session.getAttribute("member") == null){
            return "/client-login/client-login";
        }
        Long memberId = (Long) session.getAttribute("memberId");
//        상담 상세 페이지의 consultId, 제목 ,내용, 시간등
        List<ConsultingCaseVO> consultDetail = consultingCaseService.readDetails(consultId);
//        변호사의 답변은 따로 받아온다.
        List<ConsultDetailDTO> readLawyer = consultingCaseService.readLawyer(consultId);
//        caseId별로 조회수 받아온다.
        int viewCount = consultingCaseService.readCountById(consultId);
//        변호사 답변의 개수
        int totalCount = consultingCaseService.countTotalReply(consultId);
//        다른 상담사례 보기에 넣을 상담사례
        List<ConsultingCaseDTO> consultCase = consultingCaseService.readMoreConsult();
        //    해결사례 더보기를 위한 조회
        List<ConsultDetailDTO> readSolution = consultingCaseService.selectSolutionCase();

        log.info(readLawyer.toString());
        consultingCaseService.increaseViewCount(consultId);
        model.addAttribute("memberId", memberId);
        model.addAttribute("readSolution",readSolution);
        model.addAttribute("consultCase",consultCase);
        model.addAttribute("viewCount",viewCount);
        model.addAttribute("consultDetail",consultDetail);
        model.addAttribute("readLawyer",readLawyer);
        model.addAttribute("totalCount",totalCount);
        log.info("상세 페이지");
        return "/consult-detail/consult-detail";
    }

    @PostMapping("/{consultId}")
    public void  saveDetail(@RequestParam String caseTitle,
                                             @RequestParam Long viewCount,
                                             @RequestParam Long lawyerReplyCount,
//                                             @RequestParam LocalDate createDate,
                                             @RequestParam Long caseId,
                                             @RequestParam("memberId") Long memberId,
                            @PathVariable Long consultId
                                             ){
        log.info("데이터 전송");
        MyFavoriteConsultDTO myFavoriteConsultDTO = new MyFavoriteConsultDTO();
        myFavoriteConsultDTO.setConsultingCaseId(caseId);
        myFavoriteConsultDTO.setConsultingCaseTitle(caseTitle);
//        myFavoriteConsultDTO.setCreateDate(createDate);
        myFavoriteConsultDTO.setViewCount(viewCount);
        myFavoriteConsultDTO.setLawyerReplyCount(lawyerReplyCount);
        myFavoriteConsultDTO.setMemberId(memberId);
        consultingCaseService.storeFavoriteCases(myFavoriteConsultDTO);
    }
}
