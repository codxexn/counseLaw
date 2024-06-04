package com.app.counselawb.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
public class CouponMemberDTO {

    // 쿠폰명
    private String couponTitle;

    // 쿠폰 설명
    private String couponDescription;

    // 할인율
    private int couponDiscountRate;

    // 쿠폰 사용 가능 상담 유형
    private String couponAvailableType;

    // 회원 아이디
    private long memberId;

    // 쿠폰 만료 날짜
    private Date couponExpireDate;
}
