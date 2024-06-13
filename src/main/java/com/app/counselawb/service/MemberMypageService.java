package com.app.counselawb.service;

import com.app.counselawb.domain.dto.LawyerLikeDTO;
import com.app.counselawb.domain.dto.ReservationDTO;
import com.app.counselawb.domain.pagination.Pagination;
import com.app.counselawb.domain.vo.ConsultingReviewVO;
import com.app.counselawb.domain.vo.LawyerLikeVO;

import java.util.List;
import java.util.Optional;


public interface MemberMypageService {

    // 변호사 즐겨찾기 추가
    public void saveMyFavoriteLawyer(LawyerLikeVO lawyerLikeVO);

    // 내가 즐겨찾기한 변호사
    public List<LawyerLikeDTO> findMyFavoriteLawyers(Long memberId, Pagination pagination);

    // 내가 즐겨찾기한 변호사 개수 카운트
    public int getCountMyFavoriteLawyers(Long memberId);

    // 멤버 id와 변호사 id로 즐찾 정보 가져오기
    public Optional<LawyerLikeVO> findCheckMyFavoriteLawyer(Long memberId, Long lawyerId);

    // 즐찾 해제하기
    public void discardMyFavoriteLawyer(Long memberId, Long lawyerId);

    // 내가 하트 누른 글 개수
    public int getCountMyFavoritePosts(Long memberId);

    // 내 상담 조회
    public List<ReservationDTO> getMyConsulting(Long memberId, String consultingType);

    // 상담 리뷰 추가
    public void saveConsultingReview(ConsultingReviewVO consultingReviewVO);
}
