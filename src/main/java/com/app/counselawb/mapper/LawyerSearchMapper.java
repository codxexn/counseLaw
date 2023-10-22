package com.app.counselawb.mapper;


import com.app.counselawb.domain.vo.FieldCategoryVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LawyerSearchMapper {
    // 분야 카테고리 전부 가져오기
    public List<FieldCategoryVO> selectAllFieldCategories();
}
