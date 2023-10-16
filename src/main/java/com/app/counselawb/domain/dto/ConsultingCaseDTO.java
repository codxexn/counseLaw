package com.app.counselawb.domain.dto;


import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class ConsultingCaseDTO {
    // 상담 사례 id
    private Long consultingCaseId;
    // 상담 사례 제목
    private String caseTitle;
    // 상담 사례 내용
    private String caseContent;
    // 멤버 id (fk)
    private Long memberId;
    // 변호사 id
    private Long lawyerId;
    // 변호사 이름
    private String lawyerName;
    // 답변 id
    private Long replyId;
    // 답변 내용
    private String replyContent;
    // 등록 시간
    private LocalDateTime createDate;

}
