package com.app.counselawb.controller;

import com.app.counselawb.domain.vo.LawyerVO;
import com.app.counselawb.domain.vo.MemberVO;
import com.app.counselawb.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.Optional;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/login/*")
public class LoginController {

    @Autowired
    HttpSession session;

    private final MemberService memberService;

    // 로그인 화면으로 이동
    @GetMapping("client-login")
    public String GoToLogin(HttpSession session, MemberVO memberVO, LawyerVO lawyerVO, Model model){
        if (session.getAttribute("member") != null || session.getAttribute("lawyer") != null) {
            model.addAttribute("alertMsg", "로그인 상태입니다. 로그아웃 진행 후 로그인을 시도하세요.");
            model.addAttribute("errorMessage", null);
            return "mainpage/mainpage";
        }
        return "client-login/client-login";
    }

    // 일반 회원 로그인
    @PostMapping("client-login")
    public RedirectView memberLogin(MemberVO memberVO, HttpSession session) {
        Optional<MemberVO> foundMember = memberService.memberLogin(memberVO);
        if (foundMember.isPresent()) {
            MemberVO member = foundMember.get();
            if (member.getMemberState().matches("WITHDRAW|SUSPENDED")) {
                return new RedirectView("/login/login-error");
            }
            session.setAttribute("member", foundMember.get());
            session.setAttribute("memberId", foundMember.get().getMemberId());
            log.info((session.getAttribute("member")).toString());
            return new RedirectView("/");
        }
        return new RedirectView("/login/login-error");
    }

    // 변호사 로그인
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

    // 로그아웃
    @GetMapping("logout-finally")
    public RedirectView logout(HttpSession session){
        if(session != null) {
            session.invalidate();
        }
        return new RedirectView("/");
    }

    // 로그인 에러 페이지
    @GetMapping("login-error")
    public String GoToLoginAgain(MemberVO memberVO, LawyerVO lawyerVO, Model model){
        String errorMessage = "이메일 또는 비밀번호가 잘못되었습니다.";
        model.addAttribute("errorMessage", errorMessage);
        return "client-login/client-login";
    }


}
