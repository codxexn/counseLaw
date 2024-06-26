package com.app.counselawb.mapper;

import com.app.counselawb.domain.dto.CouponMemberDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CouponMemberMapper {
    // 내 쿠폰 가져오기
    public CouponMemberDTO selectMyCoupons(long memberId);

    // 멤버 쿠폰 저장
    public void insertMemberCoupon(long memberId, long couponId);
}
