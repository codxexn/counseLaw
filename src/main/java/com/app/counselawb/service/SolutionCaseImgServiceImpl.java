package com.app.counselawb.service;

import com.app.counselawb.domain.vo.SolutionCaseImgVO;
import com.app.counselawb.repository.SolutionCaseImgDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SolutionCaseImgServiceImpl implements SolutionCaseImgService {
    private final SolutionCaseImgDAO solutionCaseImgDAO;
    @Override
    public List<SolutionCaseImgVO> findSolutionCaseImages(Long solutionCaseId) {
        return solutionCaseImgDAO.findSolutionCaseImages(solutionCaseId);
    }
}
