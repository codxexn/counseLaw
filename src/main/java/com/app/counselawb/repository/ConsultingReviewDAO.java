package com.app.counselawb.repository;


import com.app.counselawb.domain.dto.MemberReviewDTO;
import com.app.counselawb.domain.vo.ConsultingReviewVO;
import com.app.counselawb.mapper.ConsultingReviewMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
@RequiredArgsConstructor
public class ConsultingReviewDAO {
    private final ConsultingReviewMapper consultingReviewMapper;

    // 변호사 id로 의뢰인후기 개수 가져오기
    public int readReviewCountsByLawyerId(Long lawyerId){
        return consultingReviewMapper.selectReviewCountsByLawyerId(lawyerId);
    }

    // 상담 리뷰 추가
    public void saveConsultingReview(ConsultingReviewVO consultingReviewVO) { consultingReviewMapper.insertConsultingReview(consultingReviewVO); }

    // 내 리뷰 불러오기
    public List<MemberReviewDTO> readMyReviews(Long memberId) { return consultingReviewMapper.selectMyReviews(memberId); }

    // 예약 id에 대한 후기 여부
    public int checkReviewOrNot(Long reservationId) { return consultingReviewMapper.checkReviewOrNot(reservationId); }

}
