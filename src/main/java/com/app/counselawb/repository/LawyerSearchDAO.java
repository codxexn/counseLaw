package com.app.counselawb.repository;


import com.app.counselawb.domain.vo.FieldCategoryVO;
import com.app.counselawb.mapper.LawyerSearchMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class LawyerSearchDAO {
    private final LawyerSearchMapper lawyerSearchMapper;

    // 분야 카테고리 전부 가져오기
    public List<FieldCategoryVO> readAllFieldCategories(){
        return lawyerSearchMapper.selectAllFieldCategories();
    }
}
