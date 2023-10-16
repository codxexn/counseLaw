package com.app.counselawb.domain.dto;


import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class LawyerLocationDTO {
    // 변호사-지역 id
    private Long lawyerLocationId;
    // 변호사 id
    private Long lawyerId;
    // 지역 id
    private Long locationId;
    // 지역 이름
    private String locationName;
}
