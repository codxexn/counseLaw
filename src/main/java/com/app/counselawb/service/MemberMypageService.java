package com.app.counselawb.service;

import com.app.counselawb.domain.pagination.Pagination;
import com.app.counselawb.domain.vo.LawyerLikeVO;

import java.util.List;


public interface MemberMypageService {

    // 변호사 즐겨찾기 추가
    public void saveMyFavoriteLawyer(LawyerLikeVO lawyerLikeVO);

    // 내가 즐겨찾기한 변호사
    public List<LawyerLikeVO> findMyFavoriteLawyers(Long memberId, Pagination pagination);

    // 내가 즐겨찾기한 변호사 개수 카운트
    public int getCountMyFavoriteLawyers(Long memberId);
}
