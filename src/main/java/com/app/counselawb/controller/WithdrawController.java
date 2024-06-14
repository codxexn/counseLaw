package com.app.counselawb.controller;


import com.app.counselawb.service.MemberWithdrawService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/withdraw/*")
public class WithdrawController {

    private final MemberWithdrawService memberWithdrawService;

    @GetMapping("member-withdraw")
    public String goToMemberWithdrawPage() {
        return "mypage/withdraw";
    }
}
