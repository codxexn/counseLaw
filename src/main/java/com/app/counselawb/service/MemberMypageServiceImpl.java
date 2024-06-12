package com.app.counselawb.service;

import com.app.counselawb.domain.dto.LawyerLikeDTO;
import com.app.counselawb.domain.dto.ReservationDTO;
import com.app.counselawb.domain.pagination.Pagination;
import com.app.counselawb.domain.vo.LawyerLikeVO;
import com.app.counselawb.repository.MemberMypageDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
    public List<LawyerLikeDTO> findMyFavoriteLawyers(Long memberId, Pagination pagination){
        return memberMypageDAO.findMyFavoriteLawyers(memberId, pagination);
    }

    // 내가 즐겨찾기한 변호사 개수 카운트
    @Override
    public int getCountMyFavoriteLawyers(Long memberId){
        return memberMypageDAO.getCountMyFavoriteLawyers(memberId);
    }

    @Override
    public Optional<LawyerLikeVO> findCheckMyFavoriteLawyer(Long memberId, Long lawyerId) {
        return memberMypageDAO.readCheckMyFavoriteLawyer(memberId, lawyerId);
    }

    @Override
    public void discardMyFavoriteLawyer(Long memberId, Long lawyerId) {
        memberMypageDAO.removeMyFavoriteLawyer(memberId, lawyerId);
    }

    @Override
    public int getCountMyFavoritePosts(Long memberId) {
        return memberMypageDAO.getCountMyPosts(memberId);
    }

    @Override
    public List<ReservationDTO> getMyConsulting(Long memberId, String consultingType) { return memberMypageDAO.getMyConsulting(memberId, consultingType); }
}
