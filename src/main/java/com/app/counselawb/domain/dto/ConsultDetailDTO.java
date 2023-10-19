package com.app.counselawb.domain.dto;


import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class ConsultDetailDTO {
    private Long memberId;
    private String faqTitle;
    private String faqContent;
    private LocalDateTime createDate;
    private Long replyId;
    private String replyContent;
    // 변호사 id (fk)
    private Long lawyerId;
    // 상담 사례 id (fk)
    private Long caseId;
}
