package com.app.counselawb.domain.vo;


import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class FieldCategoryVO {
    // 분야 카테고리 id
    private Long fieldCategoryId;
    // 분야 카테고리 이름
    private String fieldCategoryName;
    // 기본 세팅
    private LocalDateTime createDate;
    private LocalDateTime updateTime;

}
