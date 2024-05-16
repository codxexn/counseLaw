package com.app.counselawb.controller;

import com.app.counselawb.domain.dto.LegalGuideDTO;
import com.app.counselawb.domain.dto.MyFavoriteConsultDTO;
import com.app.counselawb.domain.vo.LawyerVO;
import com.app.counselawb.domain.vo.MemberVO;
import com.app.counselawb.service.ConsultingCaseService;
import com.app.counselawb.service.LegalGuideService;
import com.app.counselawb.service.MyFavoritePostsService;
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
@RequestMapping("/my-favorite-posts/*")
public class MyFavoritePostController {
    private final MyFavoritePostsService myFavoritePostsService;


    @GetMapping("my-favorite-posts")
    public String goToMyFavoritePosts(HttpSession session, MemberVO memberVO, LawyerVO lawyerVO, Model model){
        if(session.getAttribute("member")==null){
            return "client-login/client-login";
        }

        MemberVO currentMember = (MemberVO) session.getAttribute("member");
        log.info("currentMember={}",currentMember);

        List<MyFavoriteConsultDTO> myFavoriteConsultDTO = myFavoritePostsService.readMyFavoritePosts(currentMember.getMemberId());
        log.info("myFavoriteConsultDTO={}",myFavoriteConsultDTO);

        if(myFavoriteConsultDTO.size() == 0) {
            return "my-favorite-posts/my-favorite-posts-empty";
        } else {
            model.addAttribute("myFavoritePosts", myFavoriteConsultDTO);

            List<LegalGuideDTO> legalGuideWithDetail = myFavoritePostsService.findAllLegalGuideWithDetail();
            model.addAttribute("legalGuideWithDetail", legalGuideWithDetail);

            return "my-favorite-posts/my-favorite-posts";
        }
    }

    @GetMapping("my-favorite-posts-empty")
    public void goToMyEmptyFavoritePosts(){;}
}
