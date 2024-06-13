package com.app.counselawb.service;

import com.app.counselawb.domain.dto.MemberReviewDTO;
import com.app.counselawb.domain.vo.ConsultingReviewVO;

import java.util.List;

public interface ConsultingReviewService {

    // 변호사 id로 의뢰인후기 개수 가져오기
    public int findReviewCountsByLawyerId(Long lawyerId);

    // 상담 리뷰 추가
    public void saveConsultingReview(ConsultingReviewVO consultingReviewVO);

    // 내 리뷰 불러오기
    public List<MemberReviewDTO> readMyReviews(Long memberId);

    // 예약 id에 대한 후기 여부
    public int checkReviewOrNot(Long reservationId);
}
