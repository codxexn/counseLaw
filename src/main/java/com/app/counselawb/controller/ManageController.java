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
    private final PostsService postsService;

    @GetMapping("manager-mainpage")
//    public void goTomanagePage() {;}
    public String goToManageMain(@RequestParam(name="selectedOption", defaultValue = "selectAll") String selectedOption, Model model) {
        model.addAttribute("selectedOption", selectedOption);


        if("selectAll".equals(selectedOption)) {
            List<PostsDTO> selectAllPosts = postsService.findByAllPosts();
            model.addAttribute("selectAllPosts", selectAllPosts);
        } else if("solutionCase".equals(selectedOption)) {
            // 해결 사례 조회
            List<PostsDTO> solutionCases = postsService.findBySolutionCasePosts();
            model.addAttribute("solutionCases", solutionCases);
        } else if("consultingCase".equals(selectedOption)) {
            // 상담 사례 조회
            List<PostsDTO> consultingCases = postsService.findByConsultingCasePosts();
            model.addAttribute("consultingCases",consultingCases);
        } else if("legalGuide".equals(selectedOption)) {
            // 법률 가이드 정보 조회
            List<PostsDTO> legalGuides = postsService.findByLegalGuidePosts();
            model.addAttribute("legalGuides", legalGuides);
        }


        return "/manager/manager-mainpage";
    }

}
