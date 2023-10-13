package com.app.counselawb.domain.vo;


import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class MemberCouponVO {
    // 멤버 쿠폰 id
    private Long memberCouponId;
    // 쿠폰 상태 (DEFAULT == 'AVAILABLE')
    private String couponState;
    // 기본 세팅
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    ///////////////
    // 멤버 id (fk)
    private Long memberId;
    // 쿠폰 id (fk)
    private Long couponId;
}
