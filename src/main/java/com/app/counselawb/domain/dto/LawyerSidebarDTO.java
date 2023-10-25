package com.app.counselawb.domain.dto;


import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class LawyerSidebarDTO {
    private Long lawyerId;
    private String lawyerName;
    // 변호사 소개
    private String lawyerIntroduction;
//    변호사 프사
    private String lawyerImage;

}
