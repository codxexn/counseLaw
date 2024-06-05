package com.app.counselawb.repository;

import com.app.counselawb.domain.dto.CouponMemberDTO;
import com.app.counselawb.mapper.CouponMemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
@RequiredArgsConstructor
public class CouponMemberDAO {

    private final CouponMemberMapper couponMemberMapper;

    // 내 쿠폰 가져오기
    public CouponMemberDTO readMyCoupons(long memberId) { return couponMemberMapper.selectMyCoupons(memberId); }

    // 멤버 쿠폰 저장
    public void saveMemberCoupon(long memberId, long couponId) { couponMemberMapper.insertMemberCoupon(memberId, couponId); }

}
