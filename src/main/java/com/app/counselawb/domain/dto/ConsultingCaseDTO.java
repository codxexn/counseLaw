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
    // 상담 등록 시간
    private LocalDateTime consultCreateDate;
    // 변호사 id
    private Long lawyerId;
    // 변호사 이름
    private String lawyerName;
//    변호사 이미지
    private String lawyerImage;
    // 답변 id
    private Long replyId;
    // 답변 내용
    private String replyContent;
    // caseId별 답변 개수
    private String replyCount;
    // 답변 등록 시간
    private LocalDateTime createDate;
//    상담사례 조회 수
    private Long caseCount;

    public void updateCount(Long caseCount){
        this.caseCount=caseCount;
    }

}
