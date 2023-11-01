package com.app.counselawb.controller;

import com.app.counselawb.domain.pagination.Pagination;
import com.app.counselawb.domain.vo.LawyerLikeVO;
import com.app.counselawb.domain.vo.LawyerVO;
import com.app.counselawb.domain.vo.MemberVO;
import com.app.counselawb.service.LawyerService;
import com.app.counselawb.service.MemberMypageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("member-mypage")
public class MemberMypageController {

    public final LawyerService lawyerService;
    public final MemberMypageService memberMypageService;

    @GetMapping("no-favorite-lawyers")
    public String goToNoFavoriteLawyersPage() {
        return "my-favorite-lawyers/favorite-lawyer-empty";
    }

    @GetMapping("my-favorite-lawyers")
    public String goToFavoriteLawyersPage(HttpSession session, Model model, MemberVO memberVO, LawyerVO lawyerVO, Long lawyerId, LawyerLikeVO lawyerLikeVO, Pagination pagination) {
        MemberVO currentMember = (MemberVO)session.getAttribute("member");
        model.addAttribute("currentMember", currentMember);
        pagination.setTotal(memberMypageService.getCountMyFavoriteLawyers(currentMember.getMemberId()));
        pagination.progress();
        List<LawyerLikeVO> lawyerLikeVOS = memberMypageService.findMyFavoriteLawyers(currentMember.getMemberId(), pagination);
        Optional<LawyerVO> foundLawyer = lawyerService.findByLawyerId(lawyerId);
        model.addAttribute("lawyerLikeVOS", lawyerLikeVOS);
        model.addAttribute("foundLawyer", foundLawyer);
        return "my-favorite-lawyers/favorite-lawyer";
    }




}
