package com.app.counselawb.repository;


import com.app.counselawb.domain.dto.CouponAdminDTO;
import com.app.counselawb.domain.dto.CouponMemberDTO;
import com.app.counselawb.domain.pagination.Pagination;
import com.app.counselawb.domain.vo.CouponAdminVO;
import com.app.counselawb.domain.vo.CouponVO;
import com.app.counselawb.mapper.CouponAdminMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
@RequiredArgsConstructor
public class CouponAdminDAO {
    private final CouponAdminMapper couponAdminMapper;

    // 쿠폰 정보들 가져오기
    public List<CouponAdminDTO> readAllCoupons(Pagination pagination){
        return couponAdminMapper.selectAllCoupons(pagination);
    }

    // 쿠폰 총 개수 가져오기
    public int readCouponCount(){
        return couponAdminMapper.selectCouponCount();
    }

    // 쿠폰 등록하기
    public void writeCoupon(CouponVO couponVO){
        couponAdminMapper.insertCoupon(couponVO);
    }

    // 방금 등록한 쿠폰id 가져오기
    public Long readLatestCoupon(){
        return couponAdminMapper.selectLatestCoupon();
    }

    // 보상 쿠폰 등록하기
    public void writeAdminCoupon(CouponAdminVO couponAdminVO){
        couponAdminMapper.insertAdminCoupon(couponAdminVO);
    }

    // 관리자 쿠폰부터 삭제하기
    public void removeAdminCoupon(Long couponId){
        couponAdminMapper.deleteAdminCoupon(couponId);
    }

    // 멤버 쿠폰 삭제하기
    public void removeMemberCoupon(Long couponId){
        couponAdminMapper.deleteMemberCoupon(couponId);
    }

    // 쿠폰 삭제하기
    public void removeCoupon(Long couponId){
        couponAdminMapper.deleteCoupon(couponId);
    }

    // 이벤트 쿠폰 가지고 오기
    public List<CouponVO> readEventCoupon() { return couponAdminMapper.selectEventCoupon(); }
}
