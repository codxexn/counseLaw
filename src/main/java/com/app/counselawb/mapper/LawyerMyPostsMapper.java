package com.app.counselawb.mapper;

import com.app.counselawb.domain.dto.LawyerReplyDTO;
import com.app.counselawb.domain.dto.LegalGuideDTO;
import com.app.counselawb.domain.dto.SolutionCaseDTO;
import com.app.counselawb.domain.pagination.Pagination;
import com.app.counselawb.domain.vo.LawyerLikeVO;
import com.app.counselawb.domain.vo.MemberVO;
import org.apache.catalina.LifecycleState;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface LawyerMyPostsMapper {
    // 내 법률가이드 가져오기
    public List<LegalGuideDTO> selectMyLegalGuideWithDetail(Pagination pagination, Long lawyerId);

    // 내 해결사례 가져오기
    public List<SolutionCaseDTO> selectMySolutions(Pagination pagination, Long lawyerId);

    // 나를 즐겨찾기한 의뢰인 id리스트
    public List<LawyerLikeVO> selectMyFollowers(Pagination pagination, Long lawyerId);

    // 팔로워 정보 가져오기
    public Optional<MemberVO> selectFollowerInfo(Long memberId);

    // 내 상담사례 글/답글 가져오기
    public List<LawyerReplyDTO> selectMyCasesAndReplies(Pagination pagination, Long lawyerId);
}
