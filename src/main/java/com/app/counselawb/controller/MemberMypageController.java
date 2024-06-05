package com.app.counselawb.controller;

import com.app.counselawb.domain.dto.CouponMemberDTO;
import com.app.counselawb.domain.dto.LawyerLikeDTO;
import com.app.counselawb.domain.pagination.Pagination;
import com.app.counselawb.domain.vo.CouponVO;
import com.app.counselawb.domain.vo.LawyerLikeVO;
import com.app.counselawb.domain.vo.LawyerVO;
import com.app.counselawb.domain.vo.MemberVO;
import com.app.counselawb.service.CouponMemberService;
import com.app.counselawb.service.LawyerService;
import com.app.counselawb.service.MemberMypageService;
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
import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("member-mypage")
public class MemberMypageController {

    private final LawyerService lawyerService;
    private final MemberMypageService memberMypageService;
    private final CouponMemberService couponMemberService;
    private final ReservationService reservationService;

    @GetMapping("no-favorite-lawyers")
    public String goToNoFavoriteLawyersPage() {
        return "my-favorite-lawyers/favorite-lawyer-empty";
    }

    @GetMapping("my-favorite-lawyers")
    public ModelAndView goToFavoriteLawyersPage(HttpSession session, Pagination pagination) {
        MemberVO currentMember = (MemberVO)session.getAttribute("member");

        ModelAndView mv = new ModelAndView();

        mv.addObject("currentMember", currentMember);

        pagination.setTotal(memberMypageService.getCountMyFavoriteLawyers(currentMember.getMemberId()));
        pagination.progress();

        List<LawyerLikeDTO> lawyerLikeDTOS = memberMypageService.findMyFavoriteLawyers(currentMember.getMemberId(), pagination);

        mv.addObject("lawyerLikeDTOS", lawyerLikeDTOS);
        mv.addObject("pagination", pagination);
        mv.setViewName("my-favorite-lawyers/favorite-lawyer");
        lawyerLikeDTOS.forEach(l -> log.info(l.toString()));
        return mv;
    }


    // 마이페이지에서 내 쿠폰함으로 (내 쿠폰함에서부터는 coupon Controller)
@GetMapping("my-coupons")
    public ModelAndView goToMyCouponPage(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        MemberVO currentMember = (MemberVO)session.getAttribute("member");
        if (currentMember != null) {

            List<CouponVO> myCoupons = reservationService.findMyCoupons(currentMember.getMemberId());

            if (myCoupons.size() == 0) {
                mv.setViewName("couponbooks/my-coupons-empty");
                return mv;
            } else {
                mv.addObject("myCoupons", myCoupons);
                mv.setViewName("couponbooks/my-coupons");
                return mv;
            }
        } else {
                mv.setViewName("mainpage/mainpage");
                return mv;
        }
    }


//    @PostMapping("my-coupons")
//    public ModelAndView beforeGoToMyCouponPage(HttpSession session) {
//
//        }
//    }


//    @GetMapping("my-online-consulting-histories")
//    public String goToMyOnlineConsultingPage(HttpSession session, Model model, Pagination pagination) {
//        MemberVO currentMember = (MemberVO)session.getAttribute("member");
//
//
//
//
//    }





}
