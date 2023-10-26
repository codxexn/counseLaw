package com.app.counselawb.repository;

import com.app.counselawb.domain.dto.SolutionCaseDTO;
import com.app.counselawb.mapper.SolutionCaseMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Repository
public class SolutionCaseDAO {
    private final SolutionCaseMapper solutionCaseMapper;

    public List<SolutionCaseDTO> findAllSolution() {return solutionCaseMapper.selectAllSolution();}

}
