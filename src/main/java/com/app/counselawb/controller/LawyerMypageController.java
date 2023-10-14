package com.app.counselawb.controller;


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
            return "/login/login";
        }
        return "";
    }

}
