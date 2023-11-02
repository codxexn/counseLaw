package com.app.counselawb.service;

import com.app.counselawb.domain.dto.SolutionCaseDTO;
import com.app.counselawb.domain.vo.SolutionCaseImgVO;
import com.app.counselawb.repository.SolutionCaseDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)

public class SolutionCaseServiceImpl implements SolutionCaseService {

    private final SolutionCaseDAO solutionCaseDAO;
    @Override
    public List<SolutionCaseDTO> findAllSolution() {
        return solutionCaseDAO.findAllSolution();}

    @Override
    public Optional<SolutionCaseDTO> findSolutionDetail(Long solutionCaseId) {
        return solutionCaseDAO.findSolutionDetail(solutionCaseId);
    }

    @Override
    public List<SolutionCaseDTO> findSolutionIMG(Long solutionCaseId){
        return solutionCaseDAO.findSolutionIMG(solutionCaseId);
    }
}
