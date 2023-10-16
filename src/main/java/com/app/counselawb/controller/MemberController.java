package com.app.counselawb.controller;

import com.app.counselawb.domain.vo.LawyerVO;
import com.app.counselawb.domain.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/member/*")
public class MemberController {

    @GetMapping("mypage-member")
    public String goToMyPage(HttpSession session, Model model, MemberVO memberVO, LawyerVO lawyerVO) {

        if (session.getAttribute("member") != null) {
            MemberVO currentMember = (MemberVO)session.getAttribute("member");
            model.addAttribute("currentMember", currentMember);
            return "/mypage/mypage";
        } else {
            return "/client-login/client-login";
        }
    }
}
