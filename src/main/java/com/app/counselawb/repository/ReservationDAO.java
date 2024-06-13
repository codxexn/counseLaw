package com.app.counselawb.repository;


import com.app.counselawb.domain.dto.ReservationDTO;
import com.app.counselawb.domain.vo.CouponVO;
import com.app.counselawb.domain.vo.PaymentVO;
import com.app.counselawb.domain.vo.ReservationVO;
import com.app.counselawb.mapper.ReservationMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
@RequiredArgsConstructor
public class ReservationDAO {
    private final ReservationMapper reservationMapper;

    // 내 쿠폰들 가져오기
    public List<CouponVO> readMyCoupons(Long memberId){
        return reservationMapper.selectMyCoupons(memberId);
    }

    // 상담 예약하기
    public void writeReservation(ReservationVO reservationVO){
        reservationMapper.insertReservation(reservationVO);
    }

    // 방금 결제한 상담예약 id 가져오기
    public Long readLatestResvIdByMemberId(Long memberId){
        return reservationMapper.selectLatestResvIdByMemberId(memberId);
    }

    // 결제 테이블에 정보 넣기
    public void writePaymentInfo(PaymentVO paymentVO){
        reservationMapper.insertPaymentInfo(paymentVO);
    }

    // 쿠폰 사용 시 used로 변경
    public void modifyCouponToUsed(Long couponId){
        reservationMapper.updateCouponToUsed(couponId);
    }

    // 예약 id로 예약 정보 조회
    public ReservationDTO readReservation(Long reservationId) { return reservationMapper.selectReservation(reservationId); }

    // 예약 취소시 status 수정
    public void cancelReservation(Long reservationId) { reservationMapper.updateReservation(reservationId); }
}
