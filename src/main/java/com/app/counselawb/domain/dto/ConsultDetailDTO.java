package com.app.counselawb.domain.dto;


import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class ConsultDetailDTO {
    //    답변 달은 시간
    private LocalDateTime createDate;
//    답변 ID
    private Long replyId;
//    답변 내용
    private String replyContent;
    // 변호사 id (fk)
    private Long lawyerId;
//    변호사 이름
    private String lawyerName;
//    변호사 소속회사
    private String lawyerCompany;
    // 상담 사례 id (fk)
    private Long consultingCaseId;

}
