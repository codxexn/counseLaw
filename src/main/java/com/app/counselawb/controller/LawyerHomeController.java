package com.app.counselawb.controller;


import com.app.counselawb.domain.dto.AveragePriceDTO;
import com.app.counselawb.domain.dto.LawyerFieldDTO;
import com.app.counselawb.domain.dto.LawyerReplyDTO;
import com.app.counselawb.domain.dto.LawyerReviewDTO;
import com.app.counselawb.domain.vo.ExperienceVO;
import com.app.counselawb.domain.vo.LawyerFieldVO;
import com.app.counselawb.domain.vo.LawyerVO;
import com.app.counselawb.domain.vo.MemberVO;
import com.app.counselawb.service.ConsultingReviewService;
import com.app.counselawb.service.LawyerHomeService;
import com.app.counselawb.service.LawyerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/lawyer-home/*")
public class LawyerHomeController {
    private HttpSession session;
    private final LawyerService lawyerService;
    private final ConsultingReviewService consultingReviewService;
    private final LawyerHomeService lawyerHomeService;

    @GetMapping("lawyer-home")
    public void GoToLawyerHome(@RequestParam("lawyerId") Long lawyerId, Model model, LawyerVO lawyerVO, MemberVO memberVO){
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
        model.addAttribute("lawyerId", lawyerId);
        int reviewCount = consultingReviewService.findReviewCountsByLawyerId(lawyerId);
        model.addAttribute("reviewCount", reviewCount);
        String lawyerProfilePath = lawyerService.findProfileImage(lawyerId);
        model.addAttribute("profilePath", lawyerProfilePath);
        List<LawyerFieldDTO> foundFields = lawyerService.findFieldsByLawyerId(lawyerId);
        sb = new StringBuilder();
        for (int i=0; i < foundFields.size(); i++){
            sb.append(foundFields.get(i).getFieldTitle());
            if (i < foundFields.size()-1) sb.append(", ");
        }
        model.addAttribute("fields", sb.toString());
        List<ExperienceVO> foundExperiences = lawyerService.findCareersByLawyerId(lawyerId);
        model.addAttribute("careers", foundExperiences);
        List<LawyerReplyDTO> foundCaseReplies = lawyerHomeService.findCasesAndRepliesByLawyerId(lawyerId);
        foundCaseReplies = foundCaseReplies.stream().limit(3).collect(Collectors.toList());
        model.addAttribute("caseReplies", foundCaseReplies);
        List<LawyerReviewDTO> foundReviews = lawyerHomeService.findReviewsByLawyerId(lawyerId);
        foundReviews.forEach((review) -> {
           String consultingType = review.getConsultingType();
           if (consultingType.equals("PHONE")) consultingType = "전화상담";
           else if (consultingType.equals("VIDEO")) consultingType = "영상상담";
           else consultingType = "방문상담";
           review.setConsultingType(consultingType);
        });
        model.addAttribute("reviews", foundReviews);

    }

    public static double myCalc(int min, int max, double avg, int cur){
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
    public String GoToLawyerInfo(@RequestParam("lawyerId") Long lawyerId, Model model, LawyerVO lawyerVO, MemberVO memberVO){
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

        return "/lawyer-info/lawyer-info";
    }

    @GetMapping("lawyer-counsel-case")
    public String GoToLawyerCounselCase(){
        return "/lawyer-counsel-case/lawyer-counsel-case";
    }

    @GetMapping("client-reviews")
    public String GoToClientReviews(){
        return "/client-reviews/client-reviews";
    }
}
