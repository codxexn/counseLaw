package com.app.counselawb.controller;

import com.app.counselawb.domain.vo.LawyerVO;
import com.app.counselawb.domain.vo.MemberVO;
import com.app.counselawb.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/login/*")
public class LoginController {
    private final MemberService memberService;
    @GetMapping("client-login")
    public String GoToLogin(MemberVO memberVO, LawyerVO lawyerVO){return "/client-login/client-login";}

    @PostMapping("client-login")
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
            mv.setViewName("/mainpage/mainpage");
            return mv;
        }
        mv.setViewName("login/login-error");
        return mv;
    }

    @PostMapping("lawyer-login")
    public RedirectView lawyerLogin(LawyerVO lawyerVO, HttpSession session) {
        Optional<LawyerVO> foundLawyer = memberService.lawyerLogin(lawyerVO);
        if (foundLawyer.isPresent()) {
            LawyerVO lawyer = foundLawyer.get();
            if (lawyer.getLawyerState().matches("WITHDRAW|SUSPENDED")) {
                return new RedirectView("/login/login-error");
            }
            session.setAttribute("lawyer", foundLawyer.get());
            log.info((session.getAttribute("lawyer")).toString());
            return new RedirectView("/");
        }
        return new RedirectView("/login/login-error");
    }
}
