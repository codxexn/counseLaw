package com.app.counselawb.controller;

import com.app.counselawb.domain.dto.LawyerLikeDTO;
import com.app.counselawb.domain.pagination.Pagination;
import com.app.counselawb.domain.vo.LawyerLikeVO;
import com.app.counselawb.domain.vo.LawyerVO;
import com.app.counselawb.domain.vo.MemberVO;
import com.app.counselawb.service.LawyerService;
import com.app.counselawb.service.MemberMypageService;
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

    public final LawyerService lawyerService;
    public final MemberMypageService memberMypageService;

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

//    @PostMapping("my-favorite-lawyers")
//    public RedirectView getMyfavoriteLawyers(@RequestParam("memberId") long memberId, HttpSession session) {
//
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
