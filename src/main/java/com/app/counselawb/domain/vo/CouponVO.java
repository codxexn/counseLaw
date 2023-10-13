package com.app.counselawb.domain.vo;


import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class CouponVO {
    // 쿠폰 id
    private Long couponId;
    // 쿠폰 이름(제목)
    private String couponTitle;
    // 쿠폰 설명(내용)
    private String couponDescription;
    // 쿠폰 생성일
    private LocalDateTime couponCreateDate;
    // 쿠폰 만료일
    private LocalDateTime couponExpireDate;
    // 기본 세팅
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
