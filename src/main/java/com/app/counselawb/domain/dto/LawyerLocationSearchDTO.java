package com.app.counselawb.domain.dto;


import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class LawyerLocationSearchDTO {
    // 변호사 지역 id
    private Long lawyerLocationId;
    // 지역 id
    private Long locationId;
    // 변호사 id
    private Long lawyerId;
    // 변호사 프사
    private String lawyerImage;
    // 변호사 이름
    private String lawyerName;
    // 변호사 회사
    private String lawyerCompany;
    // 전화상담 가격
    private int callPrice;
    // 영상상담 가격
    private int videoPrice;
    // 방문상담 가격
    private int visitPrice;
    // 의뢰인 후기 개수
    private int reviewCount;
    // 변호사 소개
    private String lawyerIntroduction;
}
