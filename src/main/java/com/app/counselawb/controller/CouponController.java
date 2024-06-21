package com.app.counselawb.controller;

import com.app.counselawb.domain.dto.CouponMemberDTO;
import com.app.counselawb.domain.vo.CouponVO;
import com.app.counselawb.domain.vo.LawyerVO;
import com.app.counselawb.domain.vo.MemberVO;
import com.app.counselawb.service.CouponAdminService;
import com.app.counselawb.service.CouponMemberService;
import com.app.counselawb.service.ReservationService;
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
import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("coupon")
public class CouponController {

    private final CouponAdminService couponAdminService;
    private final CouponMemberService couponMemberService;
    private final ReservationService reservationService;

@GetMapping("coupon-event")
public String goToCouponEventPage(HttpSession session, Model model, MemberVO memberVO, LawyerVO lawyerVO) {

    if (session.getAttribute("member") == null){
        return "client-login/client-login";
    } else {

        MemberVO currentMember = (MemberVO)session.getAttribute("member");
        List<CouponVO> foundEventCoupons = couponAdminService.readEventCoupon();
        log.info(String.valueOf(foundEventCoupons.toString()));
        List<CouponVO> myCoupons = reservationService.findMyCoupons(currentMember.getMemberId());
        log.info(String.valueOf(myCoupons.toString()));
        List<CouponVO> availableCoupons = new ArrayList<>();

        for (CouponVO eventCoupon : foundEventCoupons) {
            boolean alreadyOwned = false;

            // Check if the user already has this coupon
            for (CouponVO myCoupon : myCoupons) {
                if (eventCoupon.getCouponId().equals(myCoupon.getCouponId())) {
                    alreadyOwned = true;
                    break;
                }
            }

            // If the coupon is not already owned, add it to availableCoupons
            if (!alreadyOwned) {
                availableCoupons.add(eventCoupon);
            }
        }

        int couponCounts = availableCoupons.size();
        model.addAttribute("availableCoupons", availableCoupons);
        model.addAttribute("couponCounts", couponCounts);

        return "couponbooks/coupon-event";
    }
}

@PostMapping("save-coupon")
public RedirectView saveCoupon(HttpSession session, @RequestParam("couponId") long couponId, Model model) {

        MemberVO currentMember = (MemberVO) session.getAttribute("member");
        couponMemberService.saveMemberCoupon(currentMember.getMemberId(), couponId);
        model.addAttribute("successMsg", "success");

        return new RedirectView("/member-mypage/my-coupons");

    }
}
