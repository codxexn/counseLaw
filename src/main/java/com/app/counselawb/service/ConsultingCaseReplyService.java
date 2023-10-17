package com.app.counselawb.service;

import com.app.counselawb.domain.dto.ConsultingCaseReplyDTO;

import java.util.List;

public interface ConsultingCaseReplyService {
    // 상담 사례 게시물 별 댓글 가져오기
    public List<ConsultingCaseReplyDTO> findAllByConsultingCaseId(Long consultingCaseId);
}
