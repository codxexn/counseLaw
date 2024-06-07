package com.app.counselawb.service;

import com.app.counselawb.domain.dto.CouponAdminDTO;
import com.app.counselawb.domain.dto.CouponMemberDTO;
import com.app.counselawb.domain.pagination.Pagination;
import com.app.counselawb.domain.vo.CouponAdminVO;
import com.app.counselawb.domain.vo.CouponVO;
import com.app.counselawb.repository.CouponAdminDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class CouponAdminServiceImpl implements CouponAdminService {

    private final CouponAdminDAO couponAdminDAO;

    @Override
    public List<CouponAdminDTO> findAllCoupons(Pagination pagination) {
        return couponAdminDAO.readAllCoupons(pagination);
    }

    @Override
    public int findCouponCount() {
        return couponAdminDAO.readCouponCount();
    }

    @Override
    public void saveCoupon(CouponVO couponVO) {
        couponAdminDAO.writeCoupon(couponVO);
    }

    @Override
    public Long findLatestCoupon() {
        return couponAdminDAO.readLatestCoupon();
    }

    @Override
    public void saveAdminCoupon(CouponAdminVO couponAdminVO) {
        couponAdminDAO.writeAdminCoupon(couponAdminVO);
    }

    @Override
    public void discardAdminCoupon(Long couponId) {
        couponAdminDAO.removeAdminCoupon(couponId);
    }

    @Override
    public void discardMemberCoupon(Long couponId) {
        couponAdminDAO.removeMemberCoupon(couponId);
    }

    @Override
    public void discardCoupon(Long couponId) {
        couponAdminDAO.removeCoupon(couponId);
    }

    @Override
    public List<CouponVO> readEventCoupon() { return couponAdminDAO.readEventCoupon(); }
}
