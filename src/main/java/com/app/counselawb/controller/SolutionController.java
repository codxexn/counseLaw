package com.app.counselawb.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/solution-case-page/*")
public class SolutionController {
//    해결사례 페이지
    @GetMapping("solution-case")
    public void GoToSolutionList(){;}

//    해결사례 상세보기 페이지
    @GetMapping("solution-case2")
    public void GoToSolutionDetail(){;}
}
