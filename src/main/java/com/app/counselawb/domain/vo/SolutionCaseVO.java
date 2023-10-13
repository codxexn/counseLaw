package com.app.counselawb.domain.vo;


import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class SolutionCaseVO {
    // 해결 사례 id
    private Long solutionCaseId;
    // 해결 사례 제목
    private String solutionCaseTitle;
    // 해결 사례 내용
    private String solutionCaseContent;
    // 기본 세팅
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    //////////////
    // 변호사 id (fk)
    private Long lawyerId;
}
