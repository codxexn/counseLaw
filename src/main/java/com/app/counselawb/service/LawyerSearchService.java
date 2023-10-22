package com.app.counselawb.service;

import com.app.counselawb.domain.dto.LawyerFieldSearchDTO;
import com.app.counselawb.domain.pagination.Pagination;
import com.app.counselawb.domain.vo.FieldCategoryVO;
import com.app.counselawb.domain.vo.FieldVO;

import java.util.List;
import java.util.Optional;

public interface LawyerSearchService {

    // 분야 카테고리 전부 가져오기
    public List<FieldCategoryVO> findAllFieldCategories();

    // 분야 id로 변호사 명수 가져오기
    public int findLawyersCountByFieldId(Long fieldId);

    // 분야 id로 변호사 정보 등 가져오기
    public List<LawyerFieldSearchDTO> findLawyersByFieldId(Pagination pagination, Long fieldId);

    // 분야 정보 가져오기
    public Optional<FieldVO> findFieldInfo(Long fieldId);
}
