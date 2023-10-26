package com.app.counselawb.repository;


import com.app.counselawb.domain.dto.LegalGuideDTO;
import com.app.counselawb.domain.dto.SolutionCaseDTO;
import com.app.counselawb.domain.pagination.Pagination;
import com.app.counselawb.domain.vo.LawyerLikeVO;
import com.app.counselawb.domain.vo.MemberVO;
import com.app.counselawb.mapper.LawyerMyPostsMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class LawyerMyPostsDAO {
    private final LawyerMyPostsMapper lawyerMyPostsMapper;

    // 내 법률가이드 가져오기
    public List<LegalGuideDTO> readMyLegalGuideWithDetail(Pagination pagination, Long lawyerId){
        return lawyerMyPostsMapper.selectMyLegalGuideWithDetail(pagination, lawyerId);
    }

    // 내 해결사례 가져오기
    public List<SolutionCaseDTO> readMySolutions(Pagination pagination, Long lawyerId){
        return lawyerMyPostsMapper.selectMySolutions(pagination, lawyerId);
    }

    // 나를 즐겨찾기한 의뢰인 id리스트
    public List<LawyerLikeVO> readMyFollowers(Pagination pagination, Long lawyerId){
        return lawyerMyPostsMapper.selectMyFollowers(pagination, lawyerId);
    }

    // 팔로워 정보 가져오기
    public Optional<MemberVO> readFollowerInfo(Long memberId){
        return lawyerMyPostsMapper.selectFollowerInfo(memberId);
    }
}
