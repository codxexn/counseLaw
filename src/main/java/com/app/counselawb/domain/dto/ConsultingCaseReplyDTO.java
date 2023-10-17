package com.app.counselawb.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
@Data
public class ConsultingCaseReplyDTO {
    // 변호사 홈에 뿌리기 위한 내용입니다.
    // 상담사례 답변 id
    private Long consultingCaseReplyId;
    // 변호사 id
    private Long lawyerId;
    // 상담사례 id
    private Long consultingCaseId;
    // 상담사례 내용
    private String consultingCaseReplyContent;
    // 상담사례 제목
    private String caseTitle;
    // 멤버 id
    private Long memberId;
    // 작성일자
    private LocalDateTime createDate;
    // 수정일자
    private LocalDateTime updateDate;
}
