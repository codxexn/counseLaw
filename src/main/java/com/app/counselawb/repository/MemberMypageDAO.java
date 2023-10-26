package com.app.counselawb.repository;

import com.app.counselawb.domain.pagination.Pagination;
import com.app.counselawb.domain.vo.LawyerLikeVO;
import com.app.counselawb.mapper.MemberMypageMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
@RequiredArgsConstructor
public class MemberMypageDAO {
    private final MemberMypageMapper memberMypageMapper;

    // 변호사 즐겨찾기 추가
    public void saveMyFavoriteLawyer(LawyerLikeVO lawyerLikeVO) {
        memberMypageMapper.insertMyFavoriteLawyer(lawyerLikeVO);
    }

    // 내가 즐겨찾기한 변호사
    public List<LawyerLikeVO> findMyFavoriteLawyers(Long memberId, Pagination pagination) {
        return memberMypageMapper.selectMyFavoriteLawyers(memberId, pagination);
    }

    // 내가 즐겨찾기한 변호사 개수 카운트
    public int getCountMyFavoriteLawyers(Long memberId) {
        return memberMypageMapper.getCountMyFavoriteLawyers(memberId);
    }
}
