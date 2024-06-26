package com.app.counselawb.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class SolutionCaseDTO {
    // 해결 사례 id
    private Long solutionCaseId;
    // 해결 사례 제목
    private String solutionCaseTitle;
    // 해결 사례 내용
    private String solutionCaseContent;
    // 판결 내역
    private String sentenceResult;
    // 기본 세팅
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    //////////////
    // 변호사 id (fk)
    private Long lawyerId;
    // 분야 id (fk)
    private Long fieldId;


//    변호사 이름
    private String lawyerName;

//    이미지 경로
    private String imgPath;

//    분야명
    private String fieldTitle;

    // 변호사 소속 회사
    private String lawyerCompany;

//    변호사 프사
    private String lawyerImage;

    // (프로젝트에 랜덤으로) 저장된(될) 파일명
    private String storedFileName;
}
