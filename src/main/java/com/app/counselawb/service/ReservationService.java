package com.app.counselawb.service;

import com.app.counselawb.domain.dto.ReservationDTO;
import com.app.counselawb.domain.vo.CouponVO;
import com.app.counselawb.domain.vo.PaymentVO;
import com.app.counselawb.domain.vo.ReservationVO;

import java.util.List;

public interface ReservationService {
    // 내 쿠폰들 가져오기
    public List<CouponVO> findMyCoupons(Long memberId);

    // 상담 예약하기
    public void saveReservation(ReservationVO reservationVO);

    // 방금 결제한 상담예약 id 가져오기
    public Long findLatestResvIdByMemberId(Long memberId);

    // 결제 테이블에 정보 넣기
    public void savePaymentInfo(PaymentVO paymentVO);

    // 쿠폰 사용 시 used로 변경
    public void reviseCouponToUsed(Long couponId);

    // 예약 id로 예약 정보 조회
    public ReservationDTO readReservation(Long reservationId);

    // 예약 취소시 status 수정
    public void cancelReservation(Long reservationId);
}
