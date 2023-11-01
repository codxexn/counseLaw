package com.app.counselawb.controller;

import com.app.counselawb.domain.dto.ConsultingCaseDTO;
import com.app.counselawb.domain.dto.LegalGuideDTO;
import com.app.counselawb.domain.dto.SolutionCaseDTO;
import com.app.counselawb.domain.pagination.Pagination;
import com.app.counselawb.service.ConsultingCaseService;
import com.app.counselawb.service.LegalGuideService;
import com.app.counselawb.service.SolutionCaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class MainController {

    private final SolutionCaseService solutionCaseService;
    private final LegalGuideService legalGuideService;
    private final ConsultingCaseService consultingCaseService;

    @GetMapping("/")
    public String goToMain(HttpSession session) {
//        모델 넣어야함
//        List<SolutionCaseDTO> solutionCases = solutionCaseService.findAllSolution();
//        List<LegalGuideDTO> legalGuideWithDetail = legalGuideService.findAllLegalGuideWithDetail();
//        List<ConsultingCaseDTO> consultCase = consultingCaseService.selectAllCase(new Pagination());
//
//        model.addAttribute("solutionCases", solutionCases);
//        model.addAttribute("legalGuideWithDetail", legalGuideWithDetail);
//        model.addAttribute("consultCase",consultCase);
        return "mainpage/mainpage";
    }
}
