package com.app.counselawb.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class ConsultingCaseReplyDTO {
    // 상담 사례 답변 id
    private Long consultingCaseReplyId;
    // 상담 사례 답변 내용
    private String consultingCaseReplyContent;
    // 기본 세팅
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    ////////////////
    // 변호사 id (fk)
    private Long lawyerId;
    // 상담 사례 id (fk)
    private Long consultingCaseId;
}
