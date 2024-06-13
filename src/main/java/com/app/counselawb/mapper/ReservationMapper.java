package com.app.counselawb.mapper;


import com.app.counselawb.domain.dto.ReservationDTO;
import com.app.counselawb.domain.vo.CouponVO;
import com.app.counselawb.domain.vo.PaymentVO;
import com.app.counselawb.domain.vo.ReservationVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReservationMapper {
    // 내 쿠폰들 가져오기
    public List<CouponVO> selectMyCoupons(Long memberId);

    // 상담 예약하기
    public void insertReservation(ReservationVO reservationVO);

    // 방금 결제한 상담예약 ID 가져오기
    public Long selectLatestResvIdByMemberId(Long memberId);

    // 결제 테이블에 정보 넣기
    public void insertPaymentInfo(PaymentVO paymentVO);

    // 쿠폰 사용 시 used로 변경
    public void updateCouponToUsed(Long couponId);

    // 예약 id로 예약 정보 조회
    public ReservationDTO selectReservation(Long reservationId);

    // 예약 취소시 status 수정
    public void updateReservation(Long reservationId);
}
