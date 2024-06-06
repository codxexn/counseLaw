package com.app.counselawb.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class CouponAdminDTO {
    // 쿠폰 id
    private Long couponId;
    // 쿠폰 이름
    private String couponTitle;
    // 쿠폰 생성 날짜
    private LocalDateTime couponCreateDate;
    // 쿠폰 만료 날짜
    private LocalDateTime couponExpireDate;
    // 쿠폰 할인율
    private int couponDiscountRate;
    // 사용가능 상담유형
    private String couponAvailableType;
    // 쿠폰 이벤트 여부
    private String couponEvent;
    // 쿠폰 번호
    private String couponNumber;
    // 발급 대상 멤버 id
    private Long memberId;
    // 기본 (공통)
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
