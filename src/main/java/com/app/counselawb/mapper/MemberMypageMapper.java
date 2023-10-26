package com.app.counselawb.mapper;

import com.app.counselawb.domain.pagination.Pagination;
import com.app.counselawb.domain.vo.LawyerLikeVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface MemberMypageMapper {

    // 변호사 즐겨찾기 추가
    public void insertMyFavoriteLawyer(LawyerLikeVO lawyerLikeVO);

    // 내가 즐겨찾기한 변호사
    public List<LawyerLikeVO> selectMyFavoriteLawyers(Long memberId, Pagination pagination);

    // 내가 즐겨찾기한 변호사 개수 카운트
    public int getCountMyFavoriteLawyers(Long memberId);

}
