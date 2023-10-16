package com.app.counselawb.controller;

import com.app.counselawb.domain.vo.ConsultingCaseVO;
import com.app.counselawb.service.ConsultingCaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/counseling/*")
public class ConsultWriteController {

    private final ConsultingCaseService consultingCaseService;

//    이 부분은 로그인 연결 후에 주석 풀기
    @GetMapping("counseling-write")
    public String  goToCounselingWrite(HttpSession session){
        if(session.getAttribute("user")==null){
            return "login/client-login";
        }
        return "/counseling/counseling-write";
    }

//    @GetMapping("counseling-write")
//    public void goToCounselingWrite(){;}

    @PostMapping("counseling-write")
    public RedirectView writeConsult(@RequestParam("memberId") Long memberId, ConsultingCaseVO consultingCaseVO){
        consultingCaseVO.setMemberId(memberId);
        consultingCaseService.insert(consultingCaseVO);

        return new RedirectView("/consult-example/consultation-example");
    }

}
