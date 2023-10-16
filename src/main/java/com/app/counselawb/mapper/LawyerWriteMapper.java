package com.app.counselawb.mapper;


import com.app.counselawb.domain.vo.LegalGuideVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LawyerWriteMapper {
    // 법률 가이드 작성
    public void insertLegalGuide(LegalGuideVO legalGuideVO);
}
