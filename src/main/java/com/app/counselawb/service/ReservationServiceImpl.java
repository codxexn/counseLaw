package com.app.counselawb.service;

import com.app.counselawb.domain.dto.ReservationDTO;
import com.app.counselawb.domain.vo.CouponVO;
import com.app.counselawb.domain.vo.PaymentVO;
import com.app.counselawb.domain.vo.ReservationVO;
import com.app.counselawb.repository.ReservationDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class ReservationServiceImpl implements ReservationService {

    private final ReservationDAO reservationDAO;

    @Override
    public List<CouponVO> findMyCoupons(Long memberId) {
        return reservationDAO.readMyCoupons(memberId);
    }

    @Override
    public void saveReservation(ReservationVO reservationVO) {
        reservationDAO.writeReservation(reservationVO);
    }

    @Override
    public Long findLatestResvIdByMemberId(Long memberId) {
        return reservationDAO.readLatestResvIdByMemberId(memberId);
    }

    @Override
    public void savePaymentInfo(PaymentVO paymentVO) {
        reservationDAO.writePaymentInfo(paymentVO);
    }

    @Override
    public void reviseCouponToUsed(Long couponId) {
        reservationDAO.modifyCouponToUsed(couponId);
    }

    @Override
    public ReservationDTO readReservation(Long reservationId) { return reservationDAO.readReservation(reservationId); }
}
