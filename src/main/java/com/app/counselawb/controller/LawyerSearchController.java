package com.app.counselawb.controller;


import com.app.counselawb.domain.vo.FieldCategoryVO;
import com.app.counselawb.domain.vo.FieldVO;
import com.app.counselawb.service.LawyerSearchService;
import com.app.counselawb.service.LawyerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/lawyer-search/*")
public class LawyerSearchController {
    private final LawyerService lawyerService;
    private final LawyerSearchService lawyerSearchService;


    // 분야로 찾기
    @GetMapping("search-by-categories")
    public String goToLawyerCategories(Model model){
        List<FieldVO> allFields = lawyerService.findAllFields();
        List<FieldCategoryVO> allCategories = lawyerSearchService.findAllFieldCategories();
        model.addAttribute("allCategories", allCategories);
        LinkedHashMap<FieldCategoryVO, List<FieldVO>> myMap = new LinkedHashMap<>();
        for (FieldCategoryVO fieldCategory : allCategories){
            List<FieldVO> selected = new ArrayList<>();
            allFields.forEach(field -> {
                if (field.getFieldCategoryId() == fieldCategory.getFieldCategoryId()){
                    selected.add(field);
                }
            });
            myMap.put(fieldCategory, selected);
        }
        model.addAttribute("fieldMap", myMap);
        return "/search-by-categories/search-by-categories";
    }

    // 분야로 변호사 검색한 결과
    @GetMapping("lawyer-list-by-categories")
    public String showCategorySearchList(@RequestParam("fieldId") Long fieldId, Model model){
        // 모든 분야 리스트
        List<FieldVO> allFields = lawyerService.findAllFields();
        model.addAttribute("allFields", allFields);
        // 해당 분야 id
        model.addAttribute("fieldId", fieldId);
        return "/lawyer-list-by-categories/lawyer-list-by-categories";
    }

    // 지역으로 찾기
    @GetMapping("search-by-locations")
    public String goToLawyerLocations(){
        return "/search-by-locations/search-by-locations";
    }
}
