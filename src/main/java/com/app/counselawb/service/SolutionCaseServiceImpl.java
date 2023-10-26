package com.app.counselawb.service;

import com.app.counselawb.domain.dto.SolutionCaseDTO;
import com.app.counselawb.repository.SolutionCaseDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)

public class SolutionCaseServiceImpl implements SolutionCaseService {

    private final SolutionCaseDAO solutionCaseDAO;
    @Override
    public List<SolutionCaseDTO> findAllSolution() {
        return solutionCaseDAO.findAllSolution();}
}