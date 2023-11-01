package com.app.counselawb.service;

import com.app.counselawb.domain.dto.SolutionCaseDTO;
import com.app.counselawb.domain.vo.SolutionCaseImgVO;

import java.util.List;
import java.util.Optional;

public interface SolutionCaseService {

//    해결사례 목록
    public List<SolutionCaseDTO> findAllSolution();

//    상세 페이지
    public Optional<SolutionCaseDTO> findSolutionDetail(Long solutionCaseId);

//    이미지 가져오기
    public List<SolutionCaseDTO> findSolutionIMG(Long solutionCaseId);
}
