package com.app.counselawb.service;


import com.app.counselawb.domain.dto.MemberReviewDTO;
import com.app.counselawb.domain.vo.ConsultingReviewVO;
import com.app.counselawb.repository.ConsultingReviewDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class ConsultingReviewServiceImpl implements ConsultingReviewService {
    private final ConsultingReviewDAO consultingReviewDAO;

    @Override
    public int findReviewCountsByLawyerId(Long lawyerId) {
        return consultingReviewDAO.readReviewCountsByLawyerId(lawyerId);
    }

    @Override
    public void saveConsultingReview(ConsultingReviewVO consultingReviewVO) { consultingReviewDAO.saveConsultingReview(consultingReviewVO); }

    @Override
    public List<MemberReviewDTO> readMyReviews(Long memberId) { return consultingReviewDAO.readMyReviews(memberId); }

    @Override
    public int checkReviewOrNot(Long reservationId) { return consultingReviewDAO.checkReviewOrNot(reservationId); }
}
