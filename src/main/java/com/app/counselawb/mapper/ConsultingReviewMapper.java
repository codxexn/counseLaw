package com.app.counselawb.mapper;


import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ConsultingReviewMapper {
    // 변호사 id로 의뢰인후기 개수 가져오기
    public int selectReviewCountsByLawyerId(Long lawyerId);
}
