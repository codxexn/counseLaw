package com.app.counselawb.domain.vo;


import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
@Data
public class ExperienceVO {
    // 경력 id
    private Long experienceId;
    // 시작 연도
    private LocalDate startYear;
    // 종료 연도
    private LocalDate endYear;
    // 경력 내용
    private String experienceContent;
    // 기본 세팅
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    ////////////////
    // 변호사 id (fk)
    private Long lawyerId;
}
