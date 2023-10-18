package com.app.counselawb.repository;


import com.app.counselawb.domain.dto.AveragePriceDTO;
import com.app.counselawb.domain.dto.LawyerReplyDTO;
import com.app.counselawb.domain.dto.LawyerReviewDTO;
import com.app.counselawb.mapper.LawyerHomeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class LawyerHomeDAO {
    private final LawyerHomeMapper lawyerHomeMapper;

    // 변호사 id로 상담사례 및 답변 가져오기
    public List<LawyerReplyDTO> readCasesAndRepliesByLawyerId(Long lawyerId){
        return lawyerHomeMapper.selectCasesAndRepliesByLawyerId(lawyerId);
    }

    // 변호사 id로 의뢰인 후기들 가져오기
    public List<LawyerReviewDTO> readReviewsByLawyerId(Long lawyerId){
        return lawyerHomeMapper.selectReviewsByLawyerId(lawyerId);
    }

    // 전화, 영상, 방문 상담 가격 평균, 개수, 최대, 최소 가져오기 (0 제외)
    public AveragePriceDTO readPriceAverages(){
        return lawyerHomeMapper.selectPriceAverages();
    }
}
