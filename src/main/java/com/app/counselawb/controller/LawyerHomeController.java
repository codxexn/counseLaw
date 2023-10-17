package com.app.counselawb.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/lawyer-home/*")
public class LawyerHomeController {
    private HttpSession session;

    @GetMapping("lawyer-home")
    public void GoToLawyerHome(){;}
}
