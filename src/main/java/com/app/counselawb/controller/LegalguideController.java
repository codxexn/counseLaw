package com.app.counselawb.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/legal-guide-page/*")
public class LegalguideController {

//    법률가이드 페이지
    @GetMapping("legal-guide")
    public void GoToLegalGuideList(){;}

//    법률가이드 상세보기 페이지
    @GetMapping("legal-guide2")
    public void GoToLegalDetail(){;}
}
