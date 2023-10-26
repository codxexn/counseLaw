package com.app.counselawb.service;

import com.app.counselawb.domain.pagination.Pagination;
import com.app.counselawb.domain.vo.LawyerLikeVO;
import com.app.counselawb.repository.MemberMypageDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class MemberMypageServiceImpl implements MemberMypageService {

    private final MemberMypageDAO memberMypageDAO;

    // 변호사 즐겨찾기 추가
    @Override
    public void saveMyFavoriteLawyer(LawyerLikeVO lawyerLikeVO) {
        memberMypageDAO.saveMyFavoriteLawyer(lawyerLikeVO);
    }


    // 내가 즐겨찾기한 변호사
    @Override
    public List<LawyerLikeVO> findMyFavoriteLawyers(Long memberId, Pagination pagination){
        return memberMypageDAO.findMyFavoriteLawyers(memberId, pagination);
    }

    // 내가 즐겨찾기한 변호사 개수 카운트
    @Override
    public int getCountMyFavoriteLawyers(Long memberId){
        return memberMypageDAO.getCountMyFavoriteLawyers(memberId);
    }
}
