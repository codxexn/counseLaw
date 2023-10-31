package com.app.counselawb.repository;

import com.app.counselawb.domain.dto.SolutionCaseDTO;
import com.app.counselawb.domain.vo.SolutionCaseImgVO;
import com.app.counselawb.mapper.SolutionCaseMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Repository
public class SolutionCaseDAO {
    private final SolutionCaseMapper solutionCaseMapper;

//    목록 가져오기
    public List<SolutionCaseDTO> findAllSolution() {return solutionCaseMapper.selectAllSolution();}

//    상세 페이지
    public Optional<SolutionCaseDTO> findSolutionDetail(Long solutionCaseId) {
        return solutionCaseMapper.selectDetailSolution(solutionCaseId);
    }

//    이미지 가져오기

    public Optional<SolutionCaseDTO> findSolutionIMG(Long solutionCaseId) {
        return solutionCaseMapper.selectSolutionImg(solutionCaseId);
    }


}
