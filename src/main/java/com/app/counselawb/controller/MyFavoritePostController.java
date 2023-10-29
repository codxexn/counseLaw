package com.app.counselawb.controller;

import com.app.counselawb.domain.vo.LawyerVO;
import com.app.counselawb.domain.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/my-favorite-posts/*")
public class MyFavoritePostController {

    @GetMapping("my-favorite-posts")
    public String goToMyFavoritePosts(HttpSession session, MemberVO memberVO, LawyerVO lawyerVO){
        if(session.getAttribute("member")==null){
            return "/client-login/client-login";
        }

        MemberVO currentMember = (MemberVO) session.getAttribute("member");

        return "/my-favorite-posts/my-favorite-posts";
    }

    @GetMapping("my-favorite-posts-empty")
    public void goToMyEmptyFavoritePosts(){;}
}
