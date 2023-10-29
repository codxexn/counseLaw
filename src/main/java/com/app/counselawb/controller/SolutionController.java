package com.app.counselawb.controller;

import com.app.counselawb.domain.dto.LegalGuideDTO;
import com.app.counselawb.domain.dto.SolutionCaseDTO;
import com.app.counselawb.domain.vo.SolutionCaseImgVO;
import com.app.counselawb.service.SolutionCaseImgService;
import com.app.counselawb.service.SolutionCaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/solution-case-page/*")
public class SolutionController {

    private final SolutionCaseService solutionCaseService;
//    해결사례 페이지

    @GetMapping("solution-case")
    public String GoToSolutionList(Model model) {
        List<SolutionCaseDTO> solutionCases = solutionCaseService.findAllSolution();
        model.addAttribute("solutionCases", solutionCases);
        return "solution-case-page/solution-case";
    }

    //    해결사례 상세보기 페이지
    @GetMapping("solution-case2")
    public String GoToSolutionDetail(@RequestParam("solutionCaseId") Long solutionCaseId, Model model) {
        Optional<SolutionCaseDTO> solutionCaseDetail = solutionCaseService.findSolutionDetail(solutionCaseId);
        Optional<SolutionCaseImgVO> solutionIMG = solutionCaseService.findSolutionIMG(solutionCaseId);

        if (solutionCaseDetail.isPresent()) {
            SolutionCaseDTO DetailSolution = solutionCaseDetail.get();
            model.addAttribute("solutionCaseDetail", DetailSolution);
            model.addAttribute("solutionIMG", DetailSolution);
        } else {
            model.addAttribute("solutionCaseDetail", null);
        }
        return "solution-case-page/solution-case2";
    }
}
