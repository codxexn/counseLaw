package com.app.counselawb.controller;


import com.app.counselawb.domain.vo.LawyerVO;
import com.app.counselawb.service.LawyerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/mypage/*")
public class LawyerMypageController {
    private final LawyerService lawyerService;

    @GetMapping("mypage-lawyer")
    public String GoToMypageLawyer(HttpSession session, Model model) {
        if (session.getAttribute("lawyer") == null) {
            return "/client-login/client-login";
        }
        LawyerVO currentLawyer = (LawyerVO) session.getAttribute("lawyer");
        model.addAttribute("currentLawyer", currentLawyer);
        Long lawyerId = currentLawyer.getLawyerId();
        int scCount = lawyerService.findSCTotalByLawyerId(lawyerId);
        int lgCount = lawyerService.findLGTotalByLawyerId(lawyerId);
        int favCount = lawyerService.findFavTotalByLawyerId(lawyerId);
        model.addAttribute("scCount", scCount);
        model.addAttribute("lgCount", lgCount);
        model.addAttribute("favCount", favCount);
        return "/mypage/mypage-lawyer";
    }

}
