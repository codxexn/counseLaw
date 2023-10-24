package com.app.counselawb.domain.vo;


import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class FieldVO {
    // 분야 id
    private Long fieldId;
    // 분야명
    private String fieldTitle;
    // 분야 설명
    private String fieldDescription;
    // 분야 카테고리 id
    private Long fieldCategoryId;
    // 기본 세팅
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
