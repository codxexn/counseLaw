package com.app.counselawb.controller;


import com.app.counselawb.domain.dto.LawyerFieldDTO;
import com.app.counselawb.domain.vo.LawyerVO;
import com.app.counselawb.service.LawyerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/mypage-lawyer/*")
public class LawyerMypageController {
    private final LawyerService lawyerService;

    @GetMapping("mypage-lawyer")
    public String GoToMypageLawyer(HttpSession session, Model model) {
        if (session.getAttribute("lawyer") == null) {
            return "/client-login/client-login";
        }
        LawyerVO currentLawyer = (LawyerVO) session.getAttribute("lawyer");
        model.addAttribute("currentLawyer", currentLawyer);
        Long lawyerId = currentLawyer.getLawyerId();
        int scCount = lawyerService.findSCTotalByLawyerId(lawyerId);
        int lgCount = lawyerService.findLGTotalByLawyerId(lawyerId);
        int favCount = lawyerService.findFavTotalByLawyerId(lawyerId);
        model.addAttribute("scCount", scCount);
        model.addAttribute("lgCount", lgCount);
        model.addAttribute("favCount", favCount);
        List<LawyerFieldDTO> foundFields = lawyerService.findFieldsByLawyerId(lawyerId);
        StringBuilder sb = new StringBuilder();
        foundFields.forEach((field) -> {
            sb.append(field.getFieldTitle()).append(", ");
        });
        sb.deleteCharAt(sb.length()-1).deleteCharAt(sb.length()-1);
        model.addAttribute("fields", sb.toString());
        int phoneCount = lawyerService.findPhoneCountByLawyerId(lawyerId);
        int videoCount = lawyerService.findVideoCountByLawyerId(lawyerId);
        int visitCount = lawyerService.findVisitCountByLawyerId(lawyerId);
        model.addAttribute("phoneCount", phoneCount);
        model.addAttribute("videoCount", videoCount);
        model.addAttribute("visitCount", visitCount);
        int replyCount = lawyerService.findReplyCountByLawyerId(lawyerId);
        model.addAttribute("replyCount", replyCount);
        return "/mypage/mypage-lawyer";
    }

    @GetMapping("info-update")
    public String GoToInfoUpdate(LawyerVO lawyerVO){
        return "/mypage/info-update-lawyer";
    }

}
