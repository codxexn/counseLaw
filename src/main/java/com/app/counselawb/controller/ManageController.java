package com.app.counselawb.controller;

import com.app.counselawb.domain.ManageCode;
import com.app.counselawb.domain.dto.PostsDTO;
import com.app.counselawb.service.PostsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/manager/*")
public class ManageController {
    private PostsService postsService;

    @GetMapping("manager-mainpage")
    public String goToManageMain(@RequestParam(name="selectedOption") String selectedOption, Model model) {
        model.addAttribute("selectedOption", selectedOption);

        if("법률 가이드".equals(selectedOption)) {
            // 법률 가이드 정보 조회
            List<PostsDTO> legalGuides = postsService.findByLegalGuidePosts();
            model.addAttribute("legalGuides", legalGuides);
        }

        return "manager-mainpage";
    }

}
