package com.app.counselawb.service;

import com.app.counselawb.domain.vo.LegalGuideVO;
import com.app.counselawb.repository.LawyerWriteDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class LawyerWriteServiceImpl implements LawyerWriteService {
    private final LawyerWriteDAO lawyerWriteDAO;
    @Override
    public void saveLegalGuide(LegalGuideVO legalGuideVO) {
        lawyerWriteDAO.writeLegalGuide(legalGuideVO);
    }
}
