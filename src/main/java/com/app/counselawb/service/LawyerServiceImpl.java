package com.app.counselawb.service;

import com.app.counselawb.domain.vo.LawyerVO;
import com.app.counselawb.repository.LawyerDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class LawyerServiceImpl implements LawyerService {
    private final LawyerDAO lawyerDAO;

    @Override
    public Optional<LawyerVO> findByLawyerId(Long lawyerId) {
        return lawyerDAO.readByLawyerId(lawyerId);
    }
}
