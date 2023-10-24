package com.app.counselawb.service;

import com.app.counselawb.domain.dto.AveragePriceDTO;
import com.app.counselawb.domain.dto.LawyerReplyDTO;
import com.app.counselawb.domain.dto.LawyerReviewDTO;
import com.app.counselawb.domain.pagination.Pagination;
import com.app.counselawb.domain.vo.LegalGuideVO;
import com.app.counselawb.domain.vo.SolutionCaseVO;

import java.util.List;

public interface LawyerHomeService {

    // 변호사 id로 상담사례 및 답변 가져오기 (3개만)
    public List<LawyerReplyDTO> findCasesAndRepliesByLawyerId(Long lawyerId);

    // 변호사 id로 의뢰인 후기들 가져오기
    public List<LawyerReviewDTO> findReviewsByLawyerId(Long lawyerId);

    // 위 기능 + 페이징 처리 (각각 따로 써야해서)
    public List<LawyerReviewDTO> findReviewsWithPageByLawyerId(Pagination pagination, Long lawyerId);

    // 전화, 영상, 방문 상담 가격 평균, 개수, 최대, 최소 가져오기 (0 제외)
    public AveragePriceDTO findPriceAverages();

    // 변호사 id로 해결 사례 가져오기 (3개만)
    public List<SolutionCaseVO> findSCByLawyerId(Long lawyerId);

    // 변호사 id로 법률 가이드 가져오기 (3개만)
    public List<LegalGuideVO> findLGByLawyerId(Long lawyerId);
}
