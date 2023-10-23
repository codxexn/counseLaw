package com.app.counselawb.controller;

import com.app.counselawb.domain.pagination.Pagination;
import com.app.counselawb.domain.vo.ConsultingCaseVO;
import com.app.counselawb.service.ConsultingCaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/consult-example/*")
public class ConsultController {

    private final ConsultingCaseService consultingCaseService;

//    상담사례들 리스트로 받아와서 HTML에 나오도록 출력
    @GetMapping("consultation-example")
    public ModelAndView goToConsultatiionExample(Pagination pagination){
        pagination.setTotal(consultingCaseService.selectAllCaseCounts());
        pagination.progress();

        ModelAndView modelAndView = new ModelAndView();
        List<ConsultingCaseVO> consultCase = consultingCaseService.selectAllCase(pagination);

        modelAndView.addObject("consultCase",consultCase);
        modelAndView.addObject("pagination",pagination);

        return modelAndView;
    }
}
