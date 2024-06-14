package com.app.counselawb.controller;


import com.app.counselawb.domain.vo.MemberVO;
import com.app.counselawb.service.WithdrawService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/withdraw/*")
public class WithdrawController {

    private final WithdrawService withdrawService;

    // 의뢰인 회원탈퇴 페이지로 이동
    @GetMapping("member-withdraw")
    public String goToMemberWithdrawPage() {
        return "mypage/withdraw";
    }

    // 의뢰인 회원탈퇴 진행
    @PostMapping("member-withdraw")
    public RedirectView withdrawMembership(HttpSession session) {

        MemberVO currentMember = (MemberVO) session.getAttribute("member");

        if (currentMember != null) {

            Long currentMemberId = currentMember.getMemberId();

            withdrawService.deleteMemberCoupon(currentMemberId);
            withdrawService.deleteLawyerLike(currentMemberId);
            withdrawService.deleteFavoritePosts(currentMemberId);
            withdrawService.reservationCancel(currentMemberId);
            withdrawService.memberWithdraw(currentMemberId);

            return new RedirectView("/login/logout-finally");


        } else {
            return new RedirectView("/login/client-login");
        }

    }

}
