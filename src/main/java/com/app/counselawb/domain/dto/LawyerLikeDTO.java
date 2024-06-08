package com.app.counselawb.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class LawyerLikeDTO {
    // 변호사 즐겨찾기 테이블 id
    private long lawyerLikeId;
    // 즐겨찾기된 변호사 id
    private long lawyerId;
    // 즐겨찾기한 회원 id
    private long memberId;
    // 즐겨찾기된 변호사 이름
    private String lawyerName;
    // 즐겨찾기된 변호사 소개
    private String lawyerIntroduction;
    // 즐겨찾기된 변호사 이미지
    private String lawyerImage;
    // 즐겨찾기된 변호사 분야 id
    private long fieldId;
    // 즐겨찾기된 변호사 분야 제목
    private String fieldTitle;
    // 즐겨찾기된 변호사 지역 id
    private long locationId;
    // 즐겨찾기된 변호사 지역명
    private String locationName;

}
