package com.app.counselawb.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ConsultToSolutionDTO {
    //    해결 사례 더 보기를 위한 fieldTitle
    private String fieldTitle;
    //    해결사례 제목
    private String solutionCaseTitle;
}
