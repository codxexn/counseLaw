package com.app.counselawb.controller;

import com.app.counselawb.domain.vo.LawyerVO;
import com.app.counselawb.domain.vo.MemberVO;
import com.app.counselawb.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/member/*")
public class MemberController {

    private final MemberService memberService;

    // 변호사스퀘어 가입안내 페이지로 이동
    @GetMapping("lawyer-introduction")
    public String goTolawyerMemberIntroductionPage(){
        return "/introductions/general";
    }

    // 변호사스퀘어 솔루션 페이지로 이동
    @GetMapping("lawyer-solution")
    public String goTolawyerMemberSolutionPage(){
        return "/introductions/solution";
    }

    // 변호사 가입안내 페이지로 이동
    @GetMapping("lawyer-advertise")
    public String goTolawyerMemberAdvertisePage(){
        return "/introductions/advertise";
    }


    // 회원가입 select 화면으로 이동
    @GetMapping("client-lawyer-select")
    public String goToJoinPage(){
        return "/member/client-lawyer-select";
    }

    // 일반회원 회원가입 페이지로 이동
    @GetMapping("client-join")
    public String goToClientJoinPage() {
        return "/client/client-join-membership";
    }

    // 일반 회원가입
    @PostMapping("client-join")
    public RedirectView joinMember(MemberVO memberVO, Model model) {
       log.info(memberVO.toString());
            if (memberService.duplicationMemberCheckByEmail(memberVO).isPresent()) {
                return new RedirectView("/member/member-join-error");
            } else {
                memberService.joinMember(memberVO);
                return new RedirectView("/member/join-success");
            }
    }


    //일반 회원가입 에러
    @GetMapping("member-join-error")
    public String goToMemberJoinAgain(MemberVO memberVO, Model model){
        String emailErrorMsg = "중복된 이메일입니다.";
        model.addAttribute("emailErrorMsg", emailErrorMsg);
        return "/client/client-join-membership";
    }

    //변호사 회원가입 에러
    @GetMapping("lawyer-join-error")
    public String goToLawyerJoinAgain(LawyerVO lawyerVO, Model model){
        String emailErrorMsg = "중복된 이메일입니다.";
        model.addAttribute("emailErrorMsg", emailErrorMsg);
        return "/lawyer/lawyer-join-membership";
    }

    //회원가입 성공
    @GetMapping("join-success")
    public String joinSuccessMsg(MemberVO memberVO, LawyerVO lawyerVO, Model model){
        String joinSuccessMsg = "회원가입이 완료되었습니다. 로그인해주시기 바랍니다.";
        model.addAttribute("joinSuccessMsg", joinSuccessMsg);
        return "/client-login/client-login";
    }



    // 변호사회원 회원가입 페이지로 이동
    @GetMapping("lawyer-join")
    public String goToLawyerJoinPage() {
        return "/lawyer/lawyer-join-membership";
    }

    // 변호사회원 회원가입
    @PostMapping("lawyer-join")
    public RedirectView joinLawyer(LawyerVO lawyerVO, Model model) {
        log.info(lawyerVO.toString());
        if (memberService.duplicationLawyerCheckByEmail(lawyerVO).isPresent()) {
            return new RedirectView("/member/lawyer-join-error");
        } else {
            memberService.joinLawyer(lawyerVO);
            return new RedirectView("/member/join-success");
        }
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
