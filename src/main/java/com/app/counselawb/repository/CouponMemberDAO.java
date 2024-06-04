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

    public CouponMemberDTO readMyCoupons(long memberId) { return couponMemberMapper.selectMyCoupons(memberId); }

}
