package com.app.counselawb.mapper;

import com.app.counselawb.domain.dto.CouponAdminDTO;
import com.app.counselawb.domain.dto.CouponMemberDTO;
import com.app.counselawb.domain.pagination.Pagination;
import com.app.counselawb.domain.vo.CouponAdminVO;
import com.app.counselawb.domain.vo.CouponVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CouponAdminMapper {
    // 쿠폰 정보들 가져오기
    public List<CouponAdminDTO> selectAllCoupons(Pagination pagination);

    // 쿠폰 총 개수 가져오기
    public int selectCouponCount();

    // 쿠폰 등록하기
    public void insertCoupon(CouponVO couponVO);

    // 방금 등록한 쿠폰id 가져오기
    public Long selectLatestCoupon();

    // 보상 쿠폰 등록하기
    public void insertAdminCoupon(CouponAdminVO couponAdminVO);

    // 관리자 쿠폰부터 삭제하기
    public void deleteAdminCoupon(Long couponId);

    // 멤버 쿠폰 삭제하기
    public void deleteMemberCoupon(Long couponId);

    // 쿠폰 삭제하기
    public void deleteCoupon(Long couponId);

    // 이벤트 쿠폰 가지고 오기
    public List<CouponVO> selectEventCoupon();
}
