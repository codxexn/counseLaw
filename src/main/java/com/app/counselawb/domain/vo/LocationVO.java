package com.app.counselawb.domain.vo;


import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class LocationVO {
    // 지역 id
    private Long locationId;
    // 지역 이름
    private String locationName;
    // 기본 세팅
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
