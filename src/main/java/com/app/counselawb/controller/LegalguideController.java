package com.app.counselawb.controller;

import com.app.counselawb.domain.dto.LegalGuideDTO;
import com.app.counselawb.domain.vo.LegalGuideVO;
import com.app.counselawb.service.LegalGuideService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

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
        return "legal-guide-page/legal-guide";
    }

//    법률가이드 상세보기 페이지
    @GetMapping("legal-guide2")
    public String GoToLegalDetail(@RequestParam("legalGuideId") Long legalGuideId, Model model){
    Optional<LegalGuideDTO> legalGuide = legalGuideService.findDetailLegal(legalGuideId);
    if (legalGuide.isPresent()) {
        LegalGuideDTO legalDetail = legalGuide.get();
        model.addAttribute("legalGuide", legalDetail);
    }
    else {
        model.addAttribute("legalGuide", null);
    }
        return "legal-guide-page/legal-guide2";
    }
}
