package com.app.counselawb.controller;

import com.app.counselawb.domain.dto.CouponMemberDTO;
import com.app.counselawb.domain.vo.CouponVO;
import com.app.counselawb.domain.vo.MemberVO;
import com.app.counselawb.service.CouponAdminService;
import com.app.counselawb.service.CouponMemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("coupon")
public class CouponController {

    private final CouponAdminService couponAdminService;
    private final CouponMemberService couponMemberService;

@GetMapping("coupon-event")
public String goToCouponEventPage(Model model) {

    List<CouponVO> foundEventCoupons = couponAdminService.readEventCoupon();
    int couponCounts = foundEventCoupons.size();
    model.addAttribute("eventCoupons", foundEventCoupons);
    model.addAttribute("couponCounts", couponCounts);

    return "couponbooks/coupon-event";
}

@PostMapping("save-coupon")
public RedirectView saveCoupon(HttpSession session, @RequestParam("couponId") long couponId, Model model) {

        MemberVO currentMember = (MemberVO) session.getAttribute("member");
        couponMemberService.saveMemberCoupon(currentMember.getMemberId(), couponId);
        return new RedirectView("/member-mypage/my-coupons");

        // 같은 쿠폰 있으면 쿠폰 이벤트에 안 뜨게 하는 것
        // 쿠폰 받고나서 alert 띄우기
        // 만 하면 쿠폰은 끝!

    }
}
