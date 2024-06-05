package com.app.counselawb.service;

import com.app.counselawb.domain.dto.CouponMemberDTO;

public interface CouponMemberService {

    // 내 쿠폰 가져오기
    public CouponMemberDTO readMyCoupons(long memberId);

    // 멤버 쿠폰 저장
    public void saveMemberCoupon(long memberId, long couponId);

}
