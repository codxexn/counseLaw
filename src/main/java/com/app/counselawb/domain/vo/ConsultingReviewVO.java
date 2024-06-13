package com.app.counselawb.domain.vo;


import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class ConsultingReviewVO {
    // 상담 후기 id
    private Long consultingReviewId;
    // 별점
    private int reviewStar;
    // 후기 제목
    private String reviewTitle;
    // 후기 내용
    private String reviewContent;
    // 기본 세팅
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    /////////////
    // 상담예약 id (fk)
    private Long reservationId;
    // 상담분야 id (fk)
    private Long fieldId;

}
