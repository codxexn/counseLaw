package com.app.counselawb.controller;


import com.app.counselawb.domain.dto.LawyerFieldDTO;
import com.app.counselawb.domain.dto.LawyerReplyDTO;
import com.app.counselawb.domain.dto.LawyerReviewDTO;
import com.app.counselawb.domain.vo.ExperienceVO;
import com.app.counselawb.domain.vo.LawyerFieldVO;
import com.app.counselawb.domain.vo.LawyerVO;
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
    public void GoToLawyerHome(@RequestParam("lawyerId") Long lawyerId, Model model){
        Optional<LawyerVO> foundLawyer = lawyerService.findByLawyerId(lawyerId);
        StringBuilder sb = new StringBuilder();
        if (foundLawyer.isPresent()){
            LawyerVO lawyerVO = foundLawyer.get();
            model.addAttribute("selectedLawyer", lawyerVO);
        } else {
            model.addAttribute("selectedLawyer", null);
        }
        model.addAttribute("lawyerId", lawyerId);
        int reviewCount = consultingReviewService.findReviewCountsByLawyerId(lawyerId);
        model.addAttribute("reviewCount", reviewCount);
        String lawyerProfilePath = lawyerService.findProfileImage(lawyerId);
        model.addAttribute("profilePath", lawyerProfilePath);
        List<LawyerFieldDTO> foundFields = lawyerService.findFieldsByLawyerId(lawyerId);
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
        List<String> consultingTypes = new ArrayList<>();
        foundReviews.forEach((review) -> {
           String consultingType = review.getConsultingType();
           if (consultingType.equals("PHONE")) consultingType = "전화상담";
           else if (consultingType.equals("VIDEO")) consultingType = "영상상담";
           else consultingType = "방문상담";
           review.setConsultingType(consultingType);
        });
        model.addAttribute("reviews", foundReviews);

    }

    @GetMapping("lawyer-info")
    public String GoToLawyerInfo(){
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
