package com.app.counselawb.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class ConsultingWriteDTO {
    private Long caseId;
    private Long memberId;
    private String faqTitle;
    private String faqContent;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
