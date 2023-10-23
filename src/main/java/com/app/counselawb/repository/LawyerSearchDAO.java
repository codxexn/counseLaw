package com.app.counselawb.repository;


import com.app.counselawb.domain.dto.LawyerFieldSearchDTO;
import com.app.counselawb.domain.pagination.Pagination;
import com.app.counselawb.domain.vo.FieldCategoryVO;
import com.app.counselawb.domain.vo.FieldVO;
import com.app.counselawb.mapper.LawyerSearchMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class LawyerSearchDAO {
    private final LawyerSearchMapper lawyerSearchMapper;

    // 분야 카테고리 전부 가져오기
    public List<FieldCategoryVO> readAllFieldCategories(){
        return lawyerSearchMapper.selectAllFieldCategories();
    }

    // 분야 id로 변호사 명수 가져오기
    public int readLawyersCountByFieldId(Long fieldId){
        return lawyerSearchMapper.selectLawyersCountByFieldId(fieldId);
    }

    // 분야 id로 변호사 정보 등 가져오기
    public List<LawyerFieldSearchDTO> readLawyersByFieldId(Pagination pagination, Long fieldId){
        return lawyerSearchMapper.selectLawyersByFieldId(pagination, fieldId);
    }

    // 분야 정보 가져오기
    public Optional<FieldVO> readFieldInfo(Long fieldId){
        return lawyerSearchMapper.selectFieldInfo(fieldId);
    }
}
