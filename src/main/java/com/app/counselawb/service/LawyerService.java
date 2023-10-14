package com.app.counselawb.service;

import com.app.counselawb.domain.vo.LawyerVO;

import java.util.Optional;

public interface LawyerService {

    // 변호사 id로 변호사 정보 조회
    public Optional<LawyerVO> findByLawyerId(Long lawyerId);
}
