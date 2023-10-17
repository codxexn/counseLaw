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

    // 변호사 가입안내 페이지로 이동



    // 회원가입 select 화면으로 이동
    @GetMapping("client-lawyer-select")
    public String goToJoinPage(MemberVO memberVO, LawyerVO lawyerVO){
        return "/member/client-lawyer-select";
    }




    // 일반회원 마이페이지로
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

    // 마이페이지에서 내 정보 수정으로
    @GetMapping("myInfo-update")
    public String goToMyInfoUpdatePage(HttpSession session, Model model, MemberVO memberVO, LawyerVO lawyerVO) {
        MemberVO currentMember = (MemberVO)session.getAttribute("member");
        model.addAttribute("currentMember", currentMember);
        return "/mypage/info-update";
    }
}
