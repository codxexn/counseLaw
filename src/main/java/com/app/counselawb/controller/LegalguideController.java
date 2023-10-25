package com.app.counselawb.controller;

import com.app.counselawb.domain.dto.LegalGuideDTO;
import com.app.counselawb.domain.vo.LegalGuideVO;
import com.app.counselawb.service.LegalGuideService;
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
@RequestMapping("/legal-guide-page/*")
public class LegalguideController {

    private final LegalGuideService legalGuideService;

//    법률가이드 페이지
    @GetMapping("legal-guide")
    public String GoToLegalGuideList(Model model){
//        List<LegalGuideVO> legalGuides =legalGuideService.findAllLegalGuide();
//        model.addAttribute("legalGuides", legalGuides);

//       변호사,분야 정보 가져오기
        List<LegalGuideDTO> legalGuideWithDetail = legalGuideService.findAllLegalGuideWithDetail();
        model.addAttribute("legalGuideWithDetail", legalGuideWithDetail);
        return "/legal-guide-page/legal-guide";
    }

//    법률가이드 상세보기 페이지
    @GetMapping("legal-guide2")
    public void GoToLegalDetail(){;}
}
