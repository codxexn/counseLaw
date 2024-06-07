package com.app.counselawb.service;

import com.app.counselawb.domain.dto.CouponAdminDTO;
import com.app.counselawb.domain.dto.CouponMemberDTO;
import com.app.counselawb.domain.pagination.Pagination;
import com.app.counselawb.domain.vo.CouponAdminVO;
import com.app.counselawb.domain.vo.CouponVO;
import org.apache.catalina.LifecycleState;

import java.util.List;

public interface CouponAdminService {

    // 쿠폰 정보들 가져오기
    public List<CouponAdminDTO> findAllCoupons(Pagination pagination);

    // 쿠폰 총 개수 가져오기
    public int findCouponCount();

    // 쿠폰 등록하기
    public void saveCoupon(CouponVO couponVO);

    // 방금 등록한 쿠폰id 가져오기
    public Long findLatestCoupon();

    // 보상 쿠폰 등록하기
    public void saveAdminCoupon(CouponAdminVO couponAdminVO);

    // 관리자 쿠폰부터 삭제하기
    public void discardAdminCoupon(Long couponId);

    // 멤버 쿠폰 삭제하기
    public void discardMemberCoupon(Long couponId);

    // 쿠폰 삭제하기
    public void discardCoupon(Long couponId);

    // 이벤트 쿠폰 가지고 오기
    public List<CouponVO> readEventCoupon();
}
