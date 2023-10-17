package com.app.counselawb.repository;

import com.app.counselawb.domain.vo.SolutionCaseImgVO;
import com.app.counselawb.mapper.SolutionCaseImgMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class SolutionCaseImgDAO {
    private final SolutionCaseImgMapper solutionCaseImgMapper;

    // solutionCaseId로 이미지 가져오기
    public List<SolutionCaseImgVO> findSolutionCaseImages(Long solutionCaseId) { return solutionCaseImgMapper.selectSolutionCaseImages(solutionCaseId); }
}
