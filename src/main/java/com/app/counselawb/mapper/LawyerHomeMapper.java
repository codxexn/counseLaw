package com.app.counselawb.mapper;


import com.app.counselawb.domain.dto.AveragePriceDTO;
import com.app.counselawb.domain.dto.LawyerReplyDTO;
import com.app.counselawb.domain.dto.LawyerReviewDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LawyerHomeMapper {
    // 변호사 id로 상담사례 및 답변 가져오기
    public List<LawyerReplyDTO> selectCasesAndRepliesByLawyerId(Long lawyerId);

    // 변호사 id로 의뢰인 후기들 가져오기
    public List<LawyerReviewDTO> selectReviewsByLawyerId(Long lawyerId);

    // 전화, 영상, 방문 상담 가격 평균, 개수, 최대, 최소 가져오기 (0 제외)
    public AveragePriceDTO selectPriceAverages();
}
