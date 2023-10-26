package com.app.counselawb.controller;


import com.app.counselawb.domain.dto.LawyerFieldSearchDTO;
import com.app.counselawb.domain.dto.LawyerLocationSearchDTO;
import com.app.counselawb.domain.pagination.Pagination;
import com.app.counselawb.domain.vo.FieldCategoryVO;
import com.app.counselawb.domain.vo.FieldVO;
import com.app.counselawb.domain.vo.LocationVO;
import com.app.counselawb.service.LawyerSearchService;
import com.app.counselawb.service.LawyerService;
import com.app.counselawb.service.LocationService;
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
    private final LocationService locationService;


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
    public String showCategorySearchList(@RequestParam("fieldId") Long fieldId, Model model, Pagination pagination){
        // 분야 id로 분야 정보 가져오기
        Optional<FieldVO> fieldInfo = lawyerSearchService.findFieldInfo(fieldId);
        if (fieldInfo.isPresent()){
            FieldVO fieldVO = fieldInfo.get();
            model.addAttribute("fieldInfo", fieldVO);
        } else {
            model.addAttribute("fieldInfo", null);
        }
        // 모든 분야 리스트
        List<FieldVO> allFields = lawyerService.findAllFields();
        model.addAttribute("allFields", allFields);
        // 해당 분야 id
        model.addAttribute("fieldId", fieldId);
        // 해당 분야 변호사 명수
        int lawyerCount = lawyerSearchService.findLawyersCountByFieldId(fieldId);
        model.addAttribute("resultCount", lawyerCount);
        pagination.setTotal(lawyerCount);
        pagination.progress();
        model.addAttribute("pagination", pagination);
        // 페이징처리와 함께 해당 분야 변호사 정보 가져오기
        List<LawyerFieldSearchDTO> foundLawyers = lawyerSearchService.findLawyersByFieldId(pagination, fieldId);;
        model.addAttribute("foundLawyers", foundLawyers);
        return "/lawyer-list-by-categories/lawyer-list-by-categories";
    }

    // 지역으로 찾기
    @GetMapping("search-by-locations")
    public String goToLawyerLocations(){
        return "/search-by-locations/search-by-locations";
    }

    // 지역으로 변호사 검색한 결과
    @GetMapping("lawyer-list-by-locations")
    public String showLocationSearchList(@RequestParam("locationId") Long locationId, Model model, Pagination pagination){
        // 지역 id로 지역 정보 가져오기
        Optional<LocationVO> locationInfo = lawyerSearchService.findLocationInfo(locationId);
        if (locationInfo.isPresent()){
            LocationVO locationVO = locationInfo.get();
            model.addAttribute("locationInfo", locationVO);
        } else {
            model.addAttribute("locationInfo", null);
        }
        // 모든 지역 리스트
        List<LocationVO> allLocations = locationService.findAllLocations();
        model.addAttribute("allLocations", allLocations);
        // 해당 지역 id
        model.addAttribute("locationId", locationId);
        // 해당 지역 변호사 명수
        int lawyerCount = lawyerSearchService.findLawyersCountByLocationId(locationId);
        model.addAttribute("resultCount", lawyerCount);
        pagination.setTotal(lawyerCount);
        pagination.progress();
        model.addAttribute("pagination", pagination);
        // 페이징 처리와 함께 해당 지역 변호사 정보 가져오기
        List<LawyerLocationSearchDTO> foundLawyers = lawyerSearchService.findLawyersByLocationId(pagination, locationId);
        model.addAttribute("foundLawyers", foundLawyers);
        return "/lawyer-list-by-locations/lawyer-list-by-locations";
    }
}
