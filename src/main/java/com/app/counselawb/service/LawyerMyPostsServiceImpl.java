package com.app.counselawb.service;

import com.app.counselawb.domain.dto.LawyerReplyDTO;
import com.app.counselawb.domain.dto.LegalGuideDTO;
import com.app.counselawb.domain.dto.SolutionCaseDTO;
import com.app.counselawb.domain.pagination.Pagination;
import com.app.counselawb.domain.vo.LawyerLikeVO;
import com.app.counselawb.domain.vo.MemberVO;
import com.app.counselawb.repository.LawyerMyPostsDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class LawyerMyPostsServiceImpl implements LawyerMyPostsService {
    private final LawyerMyPostsDAO lawyerMyPostsDAO;

    @Override
    public List<LegalGuideDTO> findMyLegalGuideWithDetail(Pagination pagination, Long lawyerId) {
        return lawyerMyPostsDAO.readMyLegalGuideWithDetail(pagination, lawyerId);
    }

    @Override
    public List<SolutionCaseDTO> findMySolutions(Pagination pagination, Long lawyerId) {
        return lawyerMyPostsDAO.readMySolutions(pagination, lawyerId);
    }

    @Override
    public List<LawyerLikeVO> findMyFollowers(Pagination pagination, Long lawyerId) {
        return lawyerMyPostsDAO.readMyFollowers(pagination, lawyerId);
    }

    @Override
    public Optional<MemberVO> findFollowerInfo(Long memberId) {
        return lawyerMyPostsDAO.readFollowerInfo(memberId);
    }

    @Override
    public List<LawyerReplyDTO> findMyCasesAndReplies(Pagination pagination, Long lawyerId) {
        return lawyerMyPostsDAO.readMyCasesAndReplies(pagination, lawyerId);
    }

}
