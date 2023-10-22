package com.app.counselawb.service;

import com.app.counselawb.domain.vo.FieldCategoryVO;

import java.util.List;

public interface LawyerSearchService {

    // 분야 카테고리 전부 가져오기
    public List<FieldCategoryVO> findAllFieldCategories();
}
