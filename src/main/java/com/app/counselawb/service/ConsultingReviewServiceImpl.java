package com.app.counselawb.service;


import com.app.counselawb.repository.ConsultingReviewDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class ConsultingReviewServiceImpl implements ConsultingReviewService {
    private final ConsultingReviewDAO consultingReviewDAO;

    @Override
    public int findReviewCountsByLawyerId(Long lawyerId) {
        return consultingReviewDAO.readReviewCountsByLawyerId(lawyerId);
    }
}
