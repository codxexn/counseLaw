package com.app.counselawb.repository;


import com.app.counselawb.domain.vo.LegalGuideVO;
import com.app.counselawb.domain.vo.SolutionCaseImgVO;
import com.app.counselawb.domain.vo.SolutionCaseVO;
import com.app.counselawb.mapper.LawyerWriteMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
@RequiredArgsConstructor
public class LawyerWriteDAO {
    private final LawyerWriteMapper lawyerWriteMapper;

    // 법률 가이드 작성
    public void writeLegalGuide(LegalGuideVO legalGuideVO){
        lawyerWriteMapper.insertLegalGuide(legalGuideVO);
    }

    // 해결 사례 작성
    public void writeSolutionCase(SolutionCaseVO solutionCaseVO){
        lawyerWriteMapper.insertSolutionCase(solutionCaseVO);
    }

    // 해결 사례 이미지 업로드
    public void writeSolutionCaseImg(SolutionCaseImgVO solutionCaseImgVO){
        lawyerWriteMapper.insertSolutionCaseImg(solutionCaseImgVO);
    }

    // 변호사 id로 방금 작성한 해결사례 id 가져오기
    public Long readLatestIdByLawyerId(Long lawyerId){
        return lawyerWriteMapper.selectLatestIdByLawyerId(lawyerId);
    }
}
