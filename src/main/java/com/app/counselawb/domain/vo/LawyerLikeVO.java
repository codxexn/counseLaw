package com.app.counselawb.domain.vo;


import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class LawyerLikeVO {
    // 변호사 즐겨찾기 id
    private Long lawyerLikeId;
    // 기본 세팅
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    /////////////
    // 멤버 id (fk)
    private Long memberId;
    // 변호사 id (fk)
    private Long lawyerId;
}
