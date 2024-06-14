package com.app.counselawb.repository;

import com.app.counselawb.mapper.MemberWithdrawMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class MemberWithdrawDAO {

    private final MemberWithdrawMapper memberWithdrawMapper;

    // 멤버 state 탈퇴로 update
    public void memberWithdraw(Long memberId) { memberWithdrawMapper.memberWithdraw(memberId); }
    // 멤버 쿠폰 삭제
    public void deleteMemberCoupon(Long memberId) { memberWithdrawMapper.deleteMemberCoupon(memberId); }
    // 멤버 변호사 즐겨찾기 삭제
    public void deleteLawyerLike(Long memberId) { memberWithdrawMapper.deleteLawyerLike(memberId); }
    // 내 관심글 삭제
    public void deleteFavoritePosts(Long memberId) { memberWithdrawMapper.deleteFavoritePosts(memberId); }
    // 예정된 예약 취소상태로 변경
    public void reservationCancel(Long memberId) { memberWithdrawMapper.reservationCancel(memberId); }

}
