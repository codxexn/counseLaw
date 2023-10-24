package com.app.counselawb.service;

import com.app.counselawb.domain.dto.AveragePriceDTO;
import com.app.counselawb.domain.dto.LawyerReplyDTO;
import com.app.counselawb.domain.dto.LawyerReviewDTO;
import com.app.counselawb.domain.pagination.Pagination;
import com.app.counselawb.domain.vo.LegalGuideVO;
import com.app.counselawb.domain.vo.SolutionCaseVO;
import com.app.counselawb.repository.LawyerHomeDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class LawyerHomeServiceImpl implements LawyerHomeService {
    private final LawyerHomeDAO lawyerHomeDAO;

    @Override
    public List<LawyerReplyDTO> findCasesAndRepliesByLawyerId(Long lawyerId) {
        return lawyerHomeDAO.readCasesAndRepliesByLawyerId(lawyerId);
    }

    @Override
    public List<LawyerReviewDTO> findReviewsByLawyerId(Long lawyerId) {
        return lawyerHomeDAO.readReviewsByLawyerId(lawyerId);
    }

    @Override
    public List<LawyerReviewDTO> findReviewsWithPageByLawyerId(Pagination pagination, Long lawyerId) {
        return lawyerHomeDAO.readReviewsWithPageByLawyerId(pagination, lawyerId);
    }

    @Override
    public AveragePriceDTO findPriceAverages() {
        return lawyerHomeDAO.readPriceAverages();
    }

    @Override
    public List<SolutionCaseVO> findSCByLawyerId(Long lawyerId) {
        return lawyerHomeDAO.readSCByLawyerId(lawyerId);
    }

    @Override
    public List<LegalGuideVO> findLGByLawyerId(Long lawyerId) {
        return lawyerHomeDAO.readLGByLawyerId(lawyerId);
    }
}
