package com.app.counselawb.domain.vo;


import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class LawyerVO {
    // 변호사 id
    private Long lawyerId;
    // 변호사 이메일
    private String lawyerEmail;
    // 변호사 비번
    private String lawyerPassword;
    // 변호사 이름
    private String lawyerName;
    // 변호사 상태 (default == 'ACTIVE')
    private String lawyerState;
    // 변호사 전화번호
    private String lawyerPhone;
    // 변호사 소속 회사
    private String lawyerCompany;
    // 변호사 (사무실) 주소
    private String lawyerAddress;
    // 변호사 자격
    private String lawyerQualification;
    // 변호사 (최종) 학력
    private String lawyerEducation;
    // 변호사 프로필 사진 (전체 경로 + 파일명 문자열로 저장)
    private String lawyerImage;
    // 전화상담 가격
    private int callPrice;
    // 영상상담 가격
    private int videoPrice;
    // 방문상담 가격
    private int visitPrice;
    // 기본 세팅
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
