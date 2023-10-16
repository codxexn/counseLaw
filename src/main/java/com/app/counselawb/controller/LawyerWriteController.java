package com.app.counselawb.controller;


import com.app.counselawb.domain.vo.FieldVO;
import com.app.counselawb.domain.vo.LawyerVO;
import com.app.counselawb.domain.vo.LegalGuideVO;
import com.app.counselawb.domain.vo.MemberVO;
import com.app.counselawb.service.LawyerService;
import com.app.counselawb.service.LawyerWriteService;
import com.app.counselawb.service.LawyerWriteServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/lawyer-write/*")
public class LawyerWriteController {
    private final LawyerService lawyerService;
    private final LawyerWriteService lawyerWriteService;

    @GetMapping("lawyer-write-lg")
    public String GoToLegalGuideWrite(Model model, HttpSession session, LegalGuideVO legalGuideVO, MemberVO memberVO,
                                      LawyerVO lawyerVO){
        if (session.getAttribute("lawyer") == null){
            return "/client-login/client-login";
        }
        LawyerVO currentLawyer = (LawyerVO) session.getAttribute("lawyer");
        Long lawyerId = currentLawyer.getLawyerId();
        model.addAttribute("lawyerId", lawyerId);
        List<FieldVO> fieldList = lawyerService.findAllFields();
        model.addAttribute("fieldList", fieldList);
        return "/lawyer-write/lawyer-write-lg";
    }

    @PostMapping("lawyer-write-lg")
    public RedirectView postLegalGuide(@RequestParam("lawyerId") Long lawyerId, @RequestParam("title") String legalGuideTitle,
                                       @RequestParam("body") String legalGuideContent, @RequestParam("eachField") Long fieldId){
        LegalGuideVO legalGuideVO = new LegalGuideVO();
        legalGuideVO.setLawyerId(lawyerId);
        legalGuideVO.setLegalGuideTitle(legalGuideTitle);
        legalGuideVO.setLegalGuideContent(legalGuideContent);
        legalGuideVO.setFieldId(fieldId);
        lawyerWriteService.saveLegalGuide(legalGuideVO);
        // 마이페이지 완성 전까지는 메인페이지로 이동하도록 하겠습니다.
        return new RedirectView("/");
    }
}
