package com.app.counselawb.domain.vo;


import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class LawyerFieldVO {
    // 변호사분야 id
    private Long lawyerFieldId;
    // 기본 세팅
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    /////////////
    // 분야 id (fk)
    private Long fieldId;
    // 변호사 id (fk)
    private Long lawyerId;
}
