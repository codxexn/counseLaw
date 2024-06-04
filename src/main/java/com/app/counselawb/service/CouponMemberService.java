package com.app.counselawb.service;

import com.app.counselawb.domain.dto.CouponMemberDTO;

public interface CouponMemberService {

    public CouponMemberDTO readMyCoupons(long memberId);

}
