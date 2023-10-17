package com.app.counselawb.service;

import com.app.counselawb.domain.dto.LawyerReplyDTO;
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
}
