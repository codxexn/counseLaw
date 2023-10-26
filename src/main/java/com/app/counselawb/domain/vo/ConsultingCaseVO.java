package com.app.counselawb.domain.vo;


import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class ConsultingCaseVO {
    // 상담 사례 id
    private Long consultingCaseId;
    // 상담 사례 제목
    private String caseTitle;
    // 상담 사례 내용
    private String caseContent;
    // 기본 세팅
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    ///////////////
    // 멤버 id (fk)
    private Long memberId;
//    조회수
    private Long caseCount;
//    FIELD 분야
    private Long fieldId;
//    FIELD 이름
    private String fieldTitle;

}
