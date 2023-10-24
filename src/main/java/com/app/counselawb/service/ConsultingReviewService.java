package com.app.counselawb.service;

public interface ConsultingReviewService {

    // 변호사 id로 의뢰인후기 개수 가져오기
    public int findReviewCountsByLawyerId(Long lawyerId);
}
