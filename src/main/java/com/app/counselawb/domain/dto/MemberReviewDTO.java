package com.app.counselawb.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
public class MemberReviewDTO {

    // 리뷰 id
    private long consultingReviewId;
    // 리뷰 제목
    private String reviewTitle;
    // 리뷰 내용
    private String reviewContent;
    // 리뷰 평점
    private int reviewStar;
    // 상담 유형
    private String consultingType;
    // 리뷰 등록 시간
    private Date createDate;
    // 상담 변호사 id
    private long lawyerId;
    // 상담 변호사 명
    private String lawyerName;


}
