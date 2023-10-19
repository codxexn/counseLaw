package com.app.counselawb.service;


import com.app.counselawb.domain.vo.SolutionCaseImgVO;
import com.app.counselawb.repository.SolutionCaseImgDAO;

import java.util.List;

public interface SolutionCaseImgService {
    public List<SolutionCaseImgVO> findSolutionCaseImages(Long solutionCaseId);
}
