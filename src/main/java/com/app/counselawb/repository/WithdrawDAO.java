package com.app.counselawb.repository;

import com.app.counselawb.mapper.WithdrawMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class WithdrawDAO {

    private final WithdrawMapper withdrawMapper;

    // 멤버 state 탈퇴로 update
    public void memberWithdraw(Long memberId) { withdrawMapper.memberWithdraw(memberId); }
    // 멤버 쿠폰 삭제
    public void deleteMemberCoupon(Long memberId) { withdrawMapper.deleteMemberCoupon(memberId); }
    // 멤버 변호사 즐겨찾기 삭제
    public void deleteLawyerLike(Long memberId) { withdrawMapper.deleteLawyerLike(memberId); }
    // 내 관심글 삭제
    public void deleteFavoritePosts(Long memberId) { withdrawMapper.deleteFavoritePosts(memberId); }
    // 예정된 예약 취소상태로 변경
    public void reservationCancel(Long memberId) { withdrawMapper.reservationCancel(memberId); }


}
