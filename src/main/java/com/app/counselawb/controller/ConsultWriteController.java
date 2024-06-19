package com.app.counselawb.controller;

import com.app.counselawb.domain.dto.ConsultingWriteDTO;
import com.app.counselawb.domain.vo.ConsultingCaseVO;
import com.app.counselawb.domain.vo.LawyerVO;
import com.app.counselawb.domain.vo.MemberVO;
import com.app.counselawb.service.ConsultingCaseService;
import com.app.counselawb.service.CouponMemberService;
import com.app.counselawb.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/counseling/*")
public class ConsultWriteController {

    private final ConsultingCaseService consultingCaseService;
    private final CouponMemberService couponMemberService;
    private final MemberService memberService;

//    이 부분은 로그인 연결 후에 주석 풀기
    @GetMapping("counseling-write")
    public String goToCounselingWrite(HttpSession session, Model model, ConsultingWriteDTO consultingWriteDTO, MemberVO memberVO, LawyerVO lawyerVO){
        if (session.getAttribute("member") == null){
            return "client-login/client-login";
        }

        return "counseling/counseling-write";
    }

    @PostMapping("counseling-write")
    public RedirectView writeConsulting(@RequestParam("memberId") Long memberId,
                                     ConsultingWriteDTO consultingWriteDTO){
        System.out.println("memberId = " + memberId);
        consultingWriteDTO.setMemberId(memberId);
        consultingCaseService.insert(consultingWriteDTO);
//        couponMemberService.saveMemberCoupon(memberId, 61);
        return new RedirectView("/consult-example/consultation-example");
    }

    @GetMapping("my-counselings")
    public String goToMyConsultsPage (HttpSession session, Model model) {

        MemberVO currentMember = (MemberVO)session.getAttribute("member");

        List<ConsultingCaseVO> myConsults = consultingCaseService.readMyConsult(currentMember.getMemberId());
        model.addAttribute("myConsults", myConsults);
        myConsults.forEach(c -> log.info(String.valueOf(c)));

        if (myConsults.size() == 0) {
            return "counseling/my-counseling-empty";
        } else {
            return "counseling/my-counseling";
        }

    }

}
