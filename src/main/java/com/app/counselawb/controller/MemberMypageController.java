package com.app.counselawb.controller;

import com.app.counselawb.domain.dto.CouponMemberDTO;
import com.app.counselawb.domain.dto.LawyerLikeDTO;
import com.app.counselawb.domain.dto.MemberReviewDTO;
import com.app.counselawb.domain.dto.ReservationDTO;
import com.app.counselawb.domain.pagination.Pagination;
import com.app.counselawb.domain.vo.*;
import com.app.counselawb.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.*;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("member-mypage")
public class MemberMypageController {

    private final MemberMypageService memberMypageService;
    private final ReservationService reservationService;
    private final ConsultingReviewService consultingReviewService;

    // 즐겨찾는 변호사 없을 때
    @GetMapping("no-favorite-lawyers")
    public String goToNoFavoriteLawyersPage() {
        return "my-favorite-lawyers/favorite-lawyer-empty";
    }

    // 즐겨찾는 변호사 있을 때
    @GetMapping("my-favorite-lawyers")
    public ModelAndView goToFavoriteLawyersPage(HttpSession session, Pagination pagination) {
        MemberVO currentMember = (MemberVO)session.getAttribute("member");

        ModelAndView mv = new ModelAndView();

        mv.addObject("currentMember", currentMember);

        pagination.setTotal(memberMypageService.getCountMyFavoriteLawyers(currentMember.getMemberId()));
        pagination.progress();

        List<LawyerLikeDTO> lawyerLikeDTOS = memberMypageService.findMyFavoriteLawyers(currentMember.getMemberId(), pagination);
        List<String> favoritesLawyerList = new ArrayList<>();

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

    // 전화 상담 내역으로 이동
    @GetMapping("my-consulting-call")
        public ModelAndView goToMyCallHistories(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        MemberVO currentMember = (MemberVO)session.getAttribute("member");
        Calendar cal = Calendar.getInstance();
        Date today = new Date(cal.getTimeInMillis());

        String consultingType = "CALL";

        List<ReservationDTO> myReservations = memberMypageService.getMyConsulting(currentMember.getMemberId(), consultingType);

        List<ReservationDTO> passedReservations = new ArrayList<>();
        List<ReservationDTO> reservations = new ArrayList<>();


        for (ReservationDTO reservationDTO : myReservations) {
            if (today.after(reservationDTO.getReservationTime())) {
                // 만약 해당 예약 id에 대한 리뷰 개수가 0이면
                if (consultingReviewService.checkReviewOrNot(reservationDTO.getReservationId()) == 0) {
                    // 리뷰여부 매개변수에 0
                    reservationDTO.setReviewOrNot(0);
                } else {
                    // 아니면 1
                    reservationDTO.setReviewOrNot(1);
                }
                // 까지 set 해준 DTO를 passReservation에 넣어준다.
                passedReservations.add(reservationDTO);

            } else {
                // 아직 예정인 예약에는 후기 카운트가 없다.
                reservations.add(reservationDTO);
            }
        }

        mv.addObject("passedReservations", passedReservations);
        mv.addObject("reservations", reservations);


            if (reservations.size() == 0 && passedReservations.size() == 0) {
                mv.setViewName("counseling-histories/phone-empty");
            } else {
                mv.setViewName("counseling-histories/phone");
            }

            return mv;
        }

    // 영상 상담 내역으로 이동
    @GetMapping("my-consulting-video")
    public ModelAndView goToMyVideoHistories(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        MemberVO currentMember = (MemberVO)session.getAttribute("member");
        Calendar cal = Calendar.getInstance();
        Date today = new Date(cal.getTimeInMillis());

        String consultingType = "VIDEO";

        List<ReservationDTO> myReservations = memberMypageService.getMyConsulting(currentMember.getMemberId(), consultingType);

        List<ReservationDTO> passedReservations = new ArrayList<>();
        List<ReservationDTO> reservations = new ArrayList<>();


        for (ReservationDTO reservationDTO : myReservations) {
            if (today.after(reservationDTO.getReservationTime())) {
                // 만약 해당 예약 id에 대한 리뷰 개수가 0이면
                if (consultingReviewService.checkReviewOrNot(reservationDTO.getReservationId()) == 0) {
                    // 리뷰여부 매개변수에 0
                    reservationDTO.setReviewOrNot(0);
                } else {
                    // 아니면 1
                    reservationDTO.setReviewOrNot(1);
                }
                // 까지 set 해준 DTO를 passReservation에 넣어준다.
                passedReservations.add(reservationDTO);

            } else {
                // 아직 예정인 예약에는 후기 카운트가 없다.
                reservations.add(reservationDTO);
            }
        }


        mv.addObject("passedReservations", passedReservations);
        mv.addObject("reservations", reservations);


        if (reservations.size() == 0 && passedReservations.size() == 0) {
            mv.setViewName("counseling-histories/video-empty");
        } else {
            mv.setViewName("counseling-histories/video");
        }

        return mv;
    }

    // 방문 상담 내역으로 이동
    @GetMapping("my-consulting-visit")
    public ModelAndView goToMyVisitHistories(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        MemberVO currentMember = (MemberVO)session.getAttribute("member");
        Calendar cal = Calendar.getInstance();
        Date today = new Date(cal.getTimeInMillis());

            String consultingType = "VISIT";

            List<ReservationDTO> myReservations = memberMypageService.getMyConsulting(currentMember.getMemberId(), consultingType);

            List<ReservationDTO> passedReservations = new ArrayList<>();
            List<ReservationDTO> reservations = new ArrayList<>();


        for (ReservationDTO reservationDTO : myReservations) {
            if (today.after(reservationDTO.getReservationTime())) {
                // 만약 해당 예약 id에 대한 리뷰 개수가 0이면
                if (consultingReviewService.checkReviewOrNot(reservationDTO.getReservationId()) == 0) {
                    // 리뷰여부 매개변수에 0
                    reservationDTO.setReviewOrNot(0);
                } else {
                    // 아니면 1
                    reservationDTO.setReviewOrNot(1);
                }
                // 까지 set 해준 DTO를 passReservation에 넣어준다.
                passedReservations.add(reservationDTO);

            } else {
                // 아직 예정인 예약에는 후기 카운트가 없다.
                reservations.add(reservationDTO);
            }
        }


            mv.addObject("passedReservations", passedReservations);
            mv.addObject("reservations", reservations);


            if (reservations.size() == 0 && passedReservations.size() == 0) {
                mv.setViewName("counseling-histories/visit-empty");
            } else {
                mv.setViewName("counseling-histories/visit");
            }

        return mv;
    }

    // 후기 작성하기 페이지로 이동
    @GetMapping("write-review/{reservationId}")
    public String goToReviewWritePage(HttpSession session, Model model, @PathVariable Long reservationId) {
        ReservationDTO reservationDTO = reservationService.readReservation(reservationId);
        model.addAttribute("reservation", reservationDTO);
        return "reviews/review-write";
    }

    // 후기 작성 insert
    @PostMapping("write-review")
    public RedirectView saveReservationReview(HttpSession session,
                                              @RequestParam("title") String title,
                                              @RequestParam("reviewBody") String body,
                                              @RequestParam("rating") int starCount,
                                              @RequestParam("reservationId") Long bookingId, Model model) {

        ConsultingReviewVO consultingReviewVO = new ConsultingReviewVO();

        consultingReviewVO.setReservationId(bookingId);
        consultingReviewVO.setReviewTitle(title);
        consultingReviewVO.setReviewContent(body);
        consultingReviewVO.setReviewStar(starCount);

        consultingReviewService.saveConsultingReview(consultingReviewVO);

        model.addAttribute("consultingReview", consultingReviewVO);

        return new RedirectView("/member-mypage/my-reviews");
    }


    // 내 후기 페이지로 이동
    @GetMapping("my-reviews")
    public String goToMyReviewPage(HttpSession session, Model model) {

        MemberVO currentMember = (MemberVO)session.getAttribute("member");
        List<MemberReviewDTO> myReviewList = consultingReviewService.readMyReviews(currentMember.getMemberId());
        model.addAttribute("myReviews", myReviewList);

        if (myReviewList.size() == 0) {
            return "reviews/my-reviews-empty";
        } else {
            return "reviews/my-reviews";
        }

    }

}
