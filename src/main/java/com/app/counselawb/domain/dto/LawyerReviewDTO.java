package com.app.counselawb.domain.dto;


import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class LawyerReviewDTO {
    // 상담 후기 id
    private Long consultingReviewId;
    // 후기 제목
    private String reviewTitle;
    // 후기 내용
    private String reviewContent;
    // 변호사 id
    private Long lawyerId;
    // 분야 id
    private Long fieldId;
    // 분야 이름
    private String fieldTitle;
    // 멤버 id
    private Long memberId;
    // 멤버 이름
    private String memberName;
    // 상담 종류
    private String consultingType;
    // 상담 id
    private Long reservationId;
    // 기본 세팅
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
