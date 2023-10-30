package com.app.counselawb.repository;

import com.app.counselawb.domain.pagination.Pagination;
import com.app.counselawb.domain.vo.LawyerLikeVO;
import com.app.counselawb.mapper.MemberMypageMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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

    // 멤버 id와 변호사 id로 즐찾 정보 가져오기
    public Optional<LawyerLikeVO> readCheckMyFavoriteLawyer(Long memberId, Long lawyerId){
        return memberMypageMapper.checkMyFavoriteLawyer(memberId, lawyerId);
    }

    // 즐찾 해제하기
    public void removeMyFavoriteLawyer(Long memberId, Long lawyerId){
        memberMypageMapper.deleteMyFavoriteLawyer(memberId, lawyerId);
    }

    //    내가 하트 누른 글 개수
    public int getCountMyPosts(Long memberId){
        return memberMypageMapper.getCountMyFavoritePosts(memberId);
    }
}
