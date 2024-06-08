package com.app.counselawb.controller;


import com.app.counselawb.domain.dto.AveragePriceDTO;
import com.app.counselawb.domain.dto.LawyerFieldDTO;
import com.app.counselawb.domain.dto.LawyerReplyDTO;
import com.app.counselawb.domain.dto.LawyerReviewDTO;
import com.app.counselawb.domain.pagination.Pagination;
import com.app.counselawb.domain.vo.*;
import com.app.counselawb.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import javax.xml.ws.Service;
import java.lang.reflect.Member;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/lawyer-home/*")
public class LawyerHomeController {
    private final LawyerService lawyerService;
    private final ConsultingReviewService consultingReviewService;
    private final LawyerHomeService lawyerHomeService;
    private final ReservationService reservationService;
    private final MemberMypageService memberMypageService;

    @GetMapping("lawyer-home")
    public void GoToLawyerHome(@RequestParam("lawyerId") Long lawyerId, Model model,
                               LawyerVO lawyerVO, MemberVO memberVO, HttpSession session){
        // 변호사
        Optional<LawyerVO> foundLawyer = lawyerService.findByLawyerId(lawyerId);
        StringBuilder sb = new StringBuilder();
        if (foundLawyer.isPresent()){
            LawyerVO lawyer = foundLawyer.get();
            String lawyerIntroduction = lawyer.getLawyerIntroduction();
            if (lawyerIntroduction.charAt(lawyerIntroduction.length()-1) == '.'){
                sb.append(lawyerIntroduction);
                sb.deleteCharAt(sb.length()-1);
                lawyer.setLawyerIntroduction(sb.toString());
            }
            model.addAttribute("selectedLawyer", lawyer);
        } else {
            model.addAttribute("selectedLawyer", null);
        }
        // 변호사 id
        model.addAttribute("lawyerId", lawyerId);
        // 의뢰인 후기 개수
        int reviewCount = consultingReviewService.findReviewCountsByLawyerId(lawyerId);
        model.addAttribute("reviewCount", reviewCount);
        // 변호사 프사 경로
        String lawyerProfilePath = lawyerService.findProfileImage(lawyerId);
        model.addAttribute("profilePath", lawyerProfilePath);
        // 변호사 분야
        List<LawyerFieldDTO> foundFields = lawyerService.findFieldsByLawyerId(lawyerId);
        sb = new StringBuilder();
        for (int i=0; i < foundFields.size(); i++){
            sb.append(foundFields.get(i).getFieldTitle());
            if (i < foundFields.size()-1) sb.append(", ");
        }
        model.addAttribute("fields", sb.toString());
        // 변호사 경력
        List<ExperienceVO> foundExperiences = lawyerService.findCareersByLawyerId(lawyerId);
        model.addAttribute("careers", foundExperiences);
        // 변호사 상담사례 답글 (3개)
        List<LawyerReplyDTO> foundCaseReplies = lawyerHomeService.findCasesAndRepliesByLawyerId(lawyerId);
        model.addAttribute("caseReplies", foundCaseReplies);
        // 상담사례 답글 단 개수
        int replyCount = lawyerService.findReplyCountByLawyerId(lawyerId);
        model.addAttribute("replyCount", replyCount);
        // 작성한 해결사례 (3개)
        List<SolutionCaseVO> foundSC = lawyerHomeService.findSCByLawyerId(lawyerId);
        model.addAttribute("scs", foundSC);
        // 작성한 해결사례 개수
        int scCount = lawyerService.findSCTotalByLawyerId(lawyerId);
        model.addAttribute("scCount", scCount);
        // 작성한 법률가이드 (3개)
        List<LegalGuideVO> foundLG = lawyerHomeService.findLGByLawyerId(lawyerId);
        model.addAttribute("lgs", foundLG);
        // 작성한 법률가이드 개수
        int lgCount = lawyerService.findLGTotalByLawyerId(lawyerId);
        model.addAttribute("lgCount", lgCount);
        // 의뢰인 후기
        List<LawyerReviewDTO> foundReviews = lawyerHomeService.findReviewsByLawyerId(lawyerId);
        foundReviews.forEach((review) -> {
           String consultingType = review.getConsultingType();
           if (consultingType.equals("CALL")) consultingType = "전화상담";
           else if (consultingType.equals("VIDEO")) consultingType = "영상상담";
           else consultingType = "방문상담";
           review.setConsultingType(consultingType);
        });
        model.addAttribute("reviews", foundReviews);
        // 즐찾 여부
        if (session.getAttribute("member") != null){
            MemberVO currentMember = (MemberVO) session.getAttribute("member");
            Long memberId = currentMember.getMemberId();
            Optional<LawyerLikeVO> foundLike = memberMypageService.findCheckMyFavoriteLawyer(memberId, lawyerId);
            if (foundLike.isPresent()){
                model.addAttribute("checkLike", "true");
            } else {
                model.addAttribute("checkLike", "false");
            }
        } else {
            model.addAttribute("checkLike", "false");
        }

    }

    public double myCalc(int min, int max, double avg, int cur){
        double result = 0;
        if (cur == avg) result = 50;
        else if (cur < avg){
            result = (cur - min) / (avg - min) * 50;
        } else {
            result = 50 + (cur - avg) / (max - avg) * 50;
        }
        return result;
    }

    @GetMapping("lawyer-info")
    public String GoToLawyerInfo(@RequestParam("lawyerId") Long lawyerId, Model model, LawyerVO lawyerVO, MemberVO memberVO,
                                 HttpSession session){
        Optional<LawyerVO> foundLawyer = lawyerService.findByLawyerId(lawyerId);
        if (foundLawyer.isPresent()){
            LawyerVO lawyer = foundLawyer.get();
            model.addAttribute("selectedLawyer", lawyer);
        } else {
            model.addAttribute("selectedLawyer", null);
        }
        model.addAttribute("lawyerId", lawyerId);
        int reviewCount = consultingReviewService.findReviewCountsByLawyerId(lawyerId);
        model.addAttribute("reviewCount", reviewCount);
        List<LawyerFieldDTO> foundFields = lawyerService.findFieldsByLawyerId(lawyerId);
        model.addAttribute("fields", foundFields);
        List<ExperienceVO> foundExperiences = lawyerService.findCareersByLawyerId(lawyerId);
        model.addAttribute("careers", foundExperiences);
        AveragePriceDTO averagePriceDTO = lawyerHomeService.findPriceAverages();
        model.addAttribute("priceInfo", averagePriceDTO);
        if (foundLawyer.isPresent()){
            LawyerVO currentLawyer = foundLawyer.get();
            int callPrice = currentLawyer.getCallPrice();
            int videoPrice = currentLawyer.getVideoPrice();
            int visitPrice = currentLawyer.getVisitPrice();
            if (callPrice != 0 && videoPrice != 0 && visitPrice != 0){
                double callPriceAvg = averagePriceDTO.getCallPriceAverage();
                double videoPriceAvg = averagePriceDTO.getVideoPriceAverage();
                double visitPriceAvg = averagePriceDTO.getVisitPriceAverage();
                int callMax = averagePriceDTO.getCallPriceMax();
                int callMin = averagePriceDTO.getCallPriceMin();
                int videoMax = averagePriceDTO.getVideoPriceMax();
                int videoMin = averagePriceDTO.getVideoPriceMin();
                int visitMax = averagePriceDTO.getVisitPriceMax();
                int visitMin = averagePriceDTO.getVisitPriceMin();
                double callPercent = myCalc(callMin, callMax, callPriceAvg, callPrice);
                double videoPercent = myCalc(videoMin, videoMax, videoPriceAvg, videoPrice);
                double visitPercent = myCalc(visitMin, visitMax, visitPriceAvg, visitPrice);
                model.addAttribute("callPercent", callPercent);
                model.addAttribute("videoPercent", videoPercent);
                model.addAttribute("visitPercent", visitPercent);
            } else {
                model.addAttribute("callPercent", null);
                model.addAttribute("videoPercent", null);
                model.addAttribute("visitPercent", null);
            }
        } else {
            model.addAttribute("callPercent", null);
            model.addAttribute("videoPercent", null);
            model.addAttribute("visitPercent", null);
        }
        String lawyerProfilePath = lawyerService.findProfileImage(lawyerId);
        model.addAttribute("profilePath", lawyerProfilePath);
        // 즐찾 여부
        if (session.getAttribute("member") != null){
            MemberVO currentMember = (MemberVO) session.getAttribute("member");
            Long memberId = currentMember.getMemberId();
            Optional<LawyerLikeVO> foundLike = memberMypageService.findCheckMyFavoriteLawyer(memberId, lawyerId);
            if (foundLike.isPresent()){
                model.addAttribute("checkLike", "true");
            } else {
                model.addAttribute("checkLike", "false");
            }
        } else {
            model.addAttribute("checkLike", "false");
        }

        return "lawyer-info/lawyer-info";
    }

    @GetMapping("client-reviews")
    public String GoToClientReviews(@RequestParam("lawyerId") Long lawyerId, Pagination pagination, Model model, LawyerVO lawyerVO, MemberVO memberVO,
                                    HttpSession session){
        // 변호사
        Optional<LawyerVO> foundLawyer = lawyerService.findByLawyerId(lawyerId);
        if (foundLawyer.isPresent()){
            LawyerVO lawyer = foundLawyer.get();
            model.addAttribute("selectedLawyer", lawyer);
        } else {
            model.addAttribute("selectedLawyer", null);
        }
        // 변호사 id
        model.addAttribute("lawyerId", lawyerId);
        // 의뢰인 후기 개수
        int reviewCount = consultingReviewService.findReviewCountsByLawyerId(lawyerId);
        model.addAttribute("reviewCount", reviewCount);
        // 의뢰인 후기
        List<LawyerReviewDTO> foundReviews = lawyerHomeService.findReviewsByLawyerId(lawyerId);
        foundReviews.forEach((review) -> {
            String consultingType = review.getConsultingType();
            if (consultingType.equals("CALL")) consultingType = "전화상담";
            else if (consultingType.equals("VIDEO")) consultingType = "영상상담";
            else consultingType = "방문상담";
            review.setConsultingType(consultingType);
        });
        model.addAttribute("reviews", foundReviews);
        // 페이징 처리
        pagination.setTotal(reviewCount);
        pagination.progress();
        model.addAttribute("pagination", pagination);
        // 의뢰인 후기 + 페이징 처리
        List<LawyerReviewDTO> foundReviewsWithPage = lawyerHomeService.findReviewsWithPageByLawyerId(pagination, lawyerId);
        foundReviewsWithPage.forEach((review) -> {
            String consultingType = review.getConsultingType();
            if (consultingType.equals("CALL")) consultingType = "전화상담";
            else if (consultingType.equals("VIDEO")) consultingType = "영상상담";
            else consultingType = "방문상담";
            review.setConsultingType(consultingType);
        });
        model.addAttribute("reviewsWithPage", foundReviewsWithPage);
        // 변호사 프사 경로
        String lawyerProfilePath = lawyerService.findProfileImage(lawyerId);
        model.addAttribute("profilePath", lawyerProfilePath);
        // 즐찾 여부
        if (session.getAttribute("member") != null){
            MemberVO currentMember = (MemberVO) session.getAttribute("member");
            Long memberId = currentMember.getMemberId();
            Optional<LawyerLikeVO> foundLike = memberMypageService.findCheckMyFavoriteLawyer(memberId, lawyerId);
            if (foundLike.isPresent()){
                model.addAttribute("checkLike", "true");
            } else {
                model.addAttribute("checkLike", "false");
            }
        } else {
            model.addAttribute("checkLike", "false");
        }
        return "client-reviews/client-reviews";
    }

    @GetMapping("reservation")
    public String goToReservation(@RequestParam("consultingType") String consultingType,
                                  @RequestParam("reservationDate") String DATEreservationDate,
                                  @RequestParam("totalPrice") int totalPrice,
                                  @RequestParam("lawyerId") Long lawyerId, Model model,
                                  HttpSession session){
        LocalDateTime reservationDate = LocalDateTime.ofInstant(Instant.parse(DATEreservationDate), ZoneId.systemDefault());
        model.addAttribute("consultingType", consultingType);
        String consultingTypeToKorean = null;
        if (consultingType.equals("CALL")) {
            consultingTypeToKorean = "15분 전화상담";
        } else if (consultingType.equals("VIDEO")){
            consultingTypeToKorean = "20분 영상상담";
        } else {
            consultingTypeToKorean = "30분 방문상담";
        }
        model.addAttribute("consultingTypeToKorean", consultingTypeToKorean);
        model.addAttribute("reservationDate", reservationDate);
        model.addAttribute("totalPrice", totalPrice);
//        log.info("{}", consultingType);
//        log.info("{}", reservationDate);
//        log.info("{}", totalPrice);
//        log.info("{}", lawyerId);
        Optional<LawyerVO> foundLawyer = lawyerService.findByLawyerId(lawyerId);
        if (foundLawyer.isPresent()){
            LawyerVO reservedLawyer = foundLawyer.get();
            model.addAttribute("reservedLawyer", reservedLawyer);
        } else {
            model.addAttribute("reservedLawyer", new LawyerVO());
        }
        MemberVO currentMember = (MemberVO) session.getAttribute("member");

        List<CouponVO> myCoupons = reservationService.findMyCoupons(currentMember.getMemberId());
        log.info(myCoupons.toString());
        List<CouponVO> availableCoupons = new ArrayList<>();
        for (CouponVO coupon : myCoupons) {
            if (coupon.getCouponAvailableType().equals("ALL") || coupon.getCouponAvailableType().equals(consultingType)) {
                availableCoupons.add(coupon);
            }
        }

        log.info(availableCoupons.toString());
        model.addAttribute("coupons", availableCoupons);


        return "reservation/reservation";
    }

    @PostMapping("reservation")
    public RedirectView payAndGoToMyPage(HttpSession session, @RequestParam("adviceBody") String reservationContent,
                                         @RequestParam("advice-name") String memberFakeName,
                                         @RequestParam("advice-phone") String memberDesiredPhone,
                                         @RequestParam("memberId") Long memberId,
                                         @RequestParam("lawyerId") Long lawyerId,
                                         @RequestParam("consultingType") String consultingType,
                                         @RequestParam("paymentPrice") int paymentPrice,
                                         @RequestParam("paymentList") String paymentList,
                                         @RequestParam(required = false, value="couponId", defaultValue="0") Long couponId){
        ReservationVO reservationVO = new ReservationVO();
        reservationVO.setReservationContent(reservationContent);
        reservationVO.setMemberFakeName(memberFakeName);
        reservationVO.setMemberDesiredPhone(memberDesiredPhone);
        reservationVO.setMemberId(memberId);
        reservationVO.setLawyerId(lawyerId);
        reservationVO.setConsultingType(consultingType);
        reservationService.saveReservation(reservationVO);
        Long reservationId = reservationService.findLatestResvIdByMemberId(memberId);
        PaymentVO paymentVO = new PaymentVO();
        paymentVO.setPaymentPrice(paymentPrice);
        paymentVO.setPaymentList(paymentList);
        paymentVO.setReservationId(reservationId);
        reservationService.savePaymentInfo(paymentVO);
        if (couponId != 0){
            reservationService.reviseCouponToUsed(couponId);
        }
        return new RedirectView("/member/mypage-member");
    }

    @GetMapping("like")
    @ResponseBody
    public String insertLike(@RequestParam("lawyerId") Long lawyerId, @RequestParam("memberId") Long memberId){
        Optional<LawyerLikeVO> foundLike = memberMypageService.findCheckMyFavoriteLawyer(memberId, lawyerId);
        if (foundLike.isPresent()){
            return "fail";
        }
        LawyerLikeVO lawyerLikeVO = new LawyerLikeVO();
        lawyerLikeVO.setMemberId(memberId);
        lawyerLikeVO.setLawyerId(lawyerId);
        memberMypageService.saveMyFavoriteLawyer(lawyerLikeVO);
        return "success";
    }

    @GetMapping("like-delete")
    @ResponseBody
    public String deleteLike(@RequestParam("lawyerId") Long lawyerId, @RequestParam("memberId") Long memberId){
        Optional<LawyerLikeVO> foundLike = memberMypageService.findCheckMyFavoriteLawyer(memberId, lawyerId);
        if (foundLike.isPresent()){
            memberMypageService.discardMyFavoriteLawyer(memberId, lawyerId);
            return "success";
        }
        return "fail";
    }
}
