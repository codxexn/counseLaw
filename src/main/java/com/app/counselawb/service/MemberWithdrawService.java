package com.app.counselawb.service;

public interface MemberWithdrawService {


    // 멤버 state 탈퇴로 update
    public void memberWithdraw(Long memberId);
    // 멤버 쿠폰 삭제
    public void deleteMemberCoupon(Long memberId);
    // 멤버 변호사 즐겨찾기 삭제
    public void deleteLawyerLike(Long memberId);
    // 내 관심글 삭제
    public void deleteFavoritePosts(Long memberId);
    // 예정된 예약 취소상태로 변경
    public void reservationCancel(Long memberId);


}
