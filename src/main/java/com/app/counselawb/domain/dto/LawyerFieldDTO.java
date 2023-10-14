package com.app.counselawb.domain.dto;


import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class LawyerFieldDTO {
    // 변호사분야 id
    private Long lawyerFieldId;
    // 분야 id
    private Long fieldId;
    // 변호사 id
    private Long lawyerId;
    // 분야명
    private String fieldTitle;
    // 분야 설명
    private String fieldDescription;
}
