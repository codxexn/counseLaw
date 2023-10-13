package com.app.counselawb.domain.vo;


import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class LawyerLocationVO {
    // 변호사 지역 id
    private Long lawyerLocationId;
    // 기본 세팅
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    ////////////////
    // 변호사 id (fk)
    private Long lawyerId;
    // 지역 id (fk)
    private Long locationId;
}
