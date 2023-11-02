package com.app.counselawb.controller;

import com.app.counselawb.domain.dto.ConsultingCaseDTO;
import com.app.counselawb.domain.dto.LawyerSidebarDTO;
import com.app.counselawb.domain.pagination.Pagination;
import com.app.counselawb.domain.vo.ConsultingCaseVO;
import com.app.counselawb.domain.vo.LawyerVO;
import com.app.counselawb.service.ConsultingCaseService;
import com.app.counselawb.service.LawyerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/consult-example/*")
public class ConsultController {

    private final ConsultingCaseService consultingCaseService;
//    사이드바의 변호사 프로필을 갖고오기위한 lawyerService
    private final LawyerService lawyerService;

//    상담사례들 리스트로 받아와서 HTML에 나오도록 출력
    @GetMapping("consultation-example")
    public String goToConsultatiionExample(Pagination pagination, Model model){
        pagination.setTotal(consultingCaseService.selectAllCaseCounts());
        pagination.progress();
        int total = pagination.getEndPage();
//        log.info("pagination ={}",pagination.getEndRow());
//        log.info("pagination ={}",pagination.getStartRow());

//        System.out.println("페이지 개수= " + total);
        List<ConsultingCaseDTO> consultCase = consultingCaseService.selectAllCase(pagination);
//        log.info("date={}",consultCase);
        List<LawyerSidebarDTO> getLawyers = consultingCaseService.getLawyers();

//                log.info(consultCase.toString());
//        log.info(getLawyers.toString());
        //        변호사 답변의 개수


//        int totalCount = consultingCaseService.countTotalReply(consultCase.);


        model.addAttribute("getLawyers",getLawyers);
        model.addAttribute("consultCase",consultCase);
        model.addAttribute("pagination",pagination);

        return "consult-example/consultation-example";
    }
}
