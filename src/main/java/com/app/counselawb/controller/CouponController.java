package com.app.counselawb.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("coupon")
public class CouponController {

@GetMapping("coupon-event")
public String goToCouponEventPage() {
    return "couponbooks/coupon-event";
}

//@PostMapping("save-coupon")
//public ModelAndView saveCoupon(HttpSession session, )
//
//    // 쿠폰번호 가지고 올 수 있는 방법
//
    
}
