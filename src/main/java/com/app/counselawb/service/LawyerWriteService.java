package com.app.counselawb.service;

import com.app.counselawb.domain.vo.LegalGuideVO;
import com.app.counselawb.domain.vo.SolutionCaseImgVO;
import com.app.counselawb.domain.vo.SolutionCaseVO;

public interface LawyerWriteService {
    // 법률 가이드 작성
    public void saveLegalGuide(LegalGuideVO legalGuideVO);

    // 해결 사례 작성
    public void saveSolutionCase(SolutionCaseVO solutionCaseVO);

    // 해결 사례 이미지 업로드
    public void saveSolutionCaseImg(SolutionCaseImgVO solutionCaseImgVO);

    // 변호사 id로 방금 작성한 해결사례 id 가져오기
    public Long findLatestIdByLawyerId(Long lawyerId);
}
