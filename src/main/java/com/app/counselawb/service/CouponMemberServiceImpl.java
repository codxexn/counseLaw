package com.app.counselawb.service;

import com.app.counselawb.domain.dto.CouponMemberDTO;
import com.app.counselawb.repository.CouponMemberDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class CouponMemberServiceImpl implements CouponMemberService {

    private final CouponMemberDAO couponMemberDAO;
    @Override
    public CouponMemberDTO readMyCoupons(long memberId) { return couponMemberDAO.readMyCoupons(memberId); }

    @Override
    public void saveMemberCoupon(long memberId, long couponId) { couponMemberDAO.saveMemberCoupon(memberId, couponId); }
}
