package com.app.counselawb.service;

import com.app.counselawb.domain.dto.LawyerReplyDTO;
import com.app.counselawb.domain.dto.LegalGuideDTO;
import com.app.counselawb.domain.dto.SolutionCaseDTO;
import com.app.counselawb.domain.pagination.Pagination;
import com.app.counselawb.domain.vo.LawyerLikeVO;
import com.app.counselawb.domain.vo.MemberVO;

import java.util.List;
import java.util.Optional;

public interface LawyerMyPostsService {

    // 내 법률가이드 가져오기
    public List<LegalGuideDTO> findMyLegalGuideWithDetail(Pagination pagination, Long lawyerId);

    // 내 해결사례 가져오기
    public List<SolutionCaseDTO> findMySolutions(Pagination pagination, Long lawyerId);

    // 나를 즐겨찾기한 의뢰인 id 리스트
    public List<LawyerLikeVO> findMyFollowers(Pagination pagination, Long lawyerId);

    // 팔로워 정보 가져오기
    public Optional<MemberVO> findFollowerInfo(Long memberId);

    // 내 상담사례 글/답글 가져오기
    public List<LawyerReplyDTO> findMyCasesAndReplies(Pagination pagination, Long lawyerId);
}
