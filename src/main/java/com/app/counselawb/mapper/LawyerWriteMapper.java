package com.app.counselawb.mapper;


import com.app.counselawb.domain.vo.LegalGuideVO;
import com.app.counselawb.domain.vo.SolutionCaseImgVO;
import com.app.counselawb.domain.vo.SolutionCaseVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LawyerWriteMapper {
    // 법률 가이드 작성
    public void insertLegalGuide(LegalGuideVO legalGuideVO);

    // 해결 사례 작성
    public void insertSolutionCase(SolutionCaseVO solutionCaseVO);

    // 해결 사례 이미지 업로드
    public void insertSolutionCaseImg(SolutionCaseImgVO solutionCaseImgVO);

    // 변호사 id로 방금 작성한 해결사례 id 가져오기
    public Long selectLatestIdByLawyerId(Long lawyerId);
}
