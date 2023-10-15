package com.app.counselawb.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@RequiredArgsConstructor
public class MainController {
    @GetMapping("/")
    public String goToMain(HttpSession session) {
        return "mainpage/mainpage";
    }
}
