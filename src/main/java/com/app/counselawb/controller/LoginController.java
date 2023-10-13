package com.app.counselawb.controller;

import com.app.counselawb.domain.vo.MemberVO;
import com.app.counselawb.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/login/*")
public class LoginController {
    private MemberService memberService;
    @GetMapping("login")
    public void GoToLogin(MemberVO memberVO){;}

    @PostMapping("login")
    public ModelAndView memberLogin(MemberVO memberVO, HttpSession session) {
        ModelAndView mv = new ModelAndView();
        Optional<MemberVO> foundMember = memberService.memberLogin(memberVO);
        if (foundMember.isPresent()) {
            MemberVO member = foundMember.get();
            if (member.getMemberState().matches("WITHDRAW|SUSPENDED")) {
                mv.setViewName("login/login-error");
                return mv;
            }
            session.setAttribute("member", foundMember.get());
            mv.addObject("member", member);
            mv.setViewName("/");
            return mv;
        }
        mv.setViewName("login/login-error");
        return mv;
    }














}
