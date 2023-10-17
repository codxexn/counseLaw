package com.app.counselawb.service;

import com.app.counselawb.domain.dto.LawyerReplyDTO;

import java.util.List;

public interface LawyerHomeService {

    // 변호사 id로 상담사례 및 답변 가져오기
    public List<LawyerReplyDTO> findCasesAndRepliesByLawyerId(Long lawyerId);
}
