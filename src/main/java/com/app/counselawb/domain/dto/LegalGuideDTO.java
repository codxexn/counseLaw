package com.app.counselawb.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class LegalGuideDTO {

    // 법률 가이드 id
    private Long legalGuideId;
    // 법률 가이드 제목
    private String legalGuideTitle;
    // 법률 가이드 내용
    private String legalGuideContent;
    // 기본 세팅
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    // 변호사 id (fk)
    private Long lawyerId;
    // 분야 id (fk)
    private Long fieldId;

    //    분야명
    private String fieldTitle;

    //    변호사명
    private String lawyerName;

}
