package com.app.counselawb.service;

import com.app.counselawb.repository.WithdrawDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class WithdrawServiceImpl implements WithdrawService {

    private final WithdrawDAO withdrawDAO;

    @Override
    public void memberWithdraw(Long memberId) { withdrawDAO.memberWithdraw(memberId); }

    @Override
    public void deleteMemberCoupon(Long memberId) { withdrawDAO.deleteMemberCoupon(memberId); }

    @Override
    public void deleteLawyerLike(Long memberId) { withdrawDAO.deleteLawyerLike(memberId); }

    @Override
    public void deleteFavoritePosts(Long memberId) { withdrawDAO.deleteFavoritePosts(memberId); }

    @Override
    public void reservationCancel(Long memberId) { withdrawDAO.reservationCancel(memberId); }

}
