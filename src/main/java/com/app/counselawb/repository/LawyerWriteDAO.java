package com.app.counselawb.repository;


import com.app.counselawb.domain.vo.LegalGuideVO;
import com.app.counselawb.mapper.LawyerWriteMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
@RequiredArgsConstructor
public class LawyerWriteDAO {
    private final LawyerWriteMapper lawyerWriteMapper;

    // 법률 가이드 작성
    public void writeLegalGuide(LegalGuideVO legalGuideVO){
        lawyerWriteMapper.insertLegalGuide(legalGuideVO);
    }
}
