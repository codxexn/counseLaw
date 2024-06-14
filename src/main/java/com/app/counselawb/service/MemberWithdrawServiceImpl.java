package com.app.counselawb.service;

import com.app.counselawb.repository.MemberWithdrawDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class MemberWithdrawServiceImpl implements MemberWithdrawService {

    private final MemberWithdrawDAO memberWithdrawDAO;

    @Override
    public void memberWithdraw(Long memberId) { memberWithdrawDAO.memberWithdraw(memberId); }

    @Override
    public void deleteMemberCoupon(Long memberId) { memberWithdrawDAO.deleteMemberCoupon(memberId); }

    @Override
    public void deleteLawyerLike(Long memberId) { memberWithdrawDAO.deleteLawyerLike(memberId); }

    @Override
    public void deleteFavoritePosts(Long memberId) { memberWithdrawDAO.deleteFavoritePosts(memberId); }

    @Override
    public void reservationCancel(Long memberId) { memberWithdrawDAO.reservationCancel(memberId); }
}
