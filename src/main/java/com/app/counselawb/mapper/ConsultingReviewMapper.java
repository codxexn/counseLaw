package com.app.counselawb.mapper;


import com.app.counselawb.domain.dto.MemberReviewDTO;
import com.app.counselawb.domain.vo.ConsultingReviewVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ConsultingReviewMapper {
    // 변호사 id로 의뢰인후기 개수 가져오기
    public int selectReviewCountsByLawyerId(Long lawyerId);

    // 상담 리뷰 추가
    public void insertConsultingReview(ConsultingReviewVO consultingReviewVO);

    // 내 리뷰 불러오기
    public List<MemberReviewDTO> selectMyReviews(Long memberId);

    // 예약 id에 대한 후기 여부
    public int checkReviewOrNot(Long reservationId);
}
