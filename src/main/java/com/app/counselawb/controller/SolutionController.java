package com.app.counselawb.controller;

import com.app.counselawb.domain.dto.LegalGuideDTO;
import com.app.counselawb.domain.dto.SolutionCaseDTO;
import com.app.counselawb.service.SolutionCaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/solution-case-page/*")
public class SolutionController {

    private final SolutionCaseService solutionCaseService;
//    해결사례 페이지

    @GetMapping("solution-case")
    public String GoToSolutionList(Model model){
        List<SolutionCaseDTO> solutionCases = solutionCaseService.findAllSolution();
        model.addAttribute("solutionCases", solutionCases);
        return "solution-case-page/solution-case";
    }

//    해결사례 상세보기 페이지
    @GetMapping("solution-case2")
    public void GoToSolutionDetail(){;}
}
