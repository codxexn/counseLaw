package com.app.counselawb.domain.vo;


import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class CouponAdminVO {
    // 쿠폰 번호 (코드)
    private String couponNumber;
    // 기본 세팅
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    ///////////////
    // 쿠폰 id (fk이자 pk, 식별자)
    private Long couponId;
    // 멤버 id (fk)
    private Long memberId;
}
