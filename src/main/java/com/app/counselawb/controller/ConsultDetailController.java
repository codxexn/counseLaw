package com.app.counselawb.controller;


import com.app.counselawb.domain.dto.ConsultDetailDTO;
import com.app.counselawb.domain.pagination.Pagination;
import com.app.counselawb.domain.vo.ConsultingCaseVO;
import com.app.counselawb.service.ConsultingCaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/consult-detail/*")
public class ConsultDetailController {

    private final ConsultingCaseService consultingCaseService;

    @GetMapping("/{consultId}")
    public String goToConsultationDetail(@PathVariable Long consultId, Model model){
//        상담 상세 페이지의 consultId, 제목 ,내용, 시간등
        List<ConsultingCaseVO> consultDetail = consultingCaseService.readDetails(consultId);
//        변호사의 답변은 따로 받아온다.
        List<ConsultDetailDTO> readLawyer = consultingCaseService.readLawyer(consultId);
//        변호사 답변의 개수
        int totalCount = consultingCaseService.countTotalReply(consultId);
        log.info(readLawyer.toString());

        model.addAttribute("consultDetail",consultDetail);
        model.addAttribute("readLawyer",readLawyer);
        model.addAttribute("totalCount",totalCount);
        return "/consult-detail/consult-detail";
    }

}
