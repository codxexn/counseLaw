package com.app.counselawb.service;

import com.app.counselawb.domain.dto.LawyerFieldDTO;
import com.app.counselawb.domain.vo.LawyerVO;
import com.app.counselawb.repository.LawyerDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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

    @Override
    public int findSCTotalByLawyerId(Long lawyerId) {
        return lawyerDAO.readSCTotalByLawyerId(lawyerId);
    }

    @Override
    public int findLGTotalByLawyerId(Long lawyerId) {
        return lawyerDAO.readLGTotalByLawyerId(lawyerId);
    }

    @Override
    public int findFavTotalByLawyerId(Long lawyerId) {
        return lawyerDAO.readFavTotalByLawyerId(lawyerId);
    }

    @Override
    public List<LawyerFieldDTO> findFieldsByLawyerId(Long lawyerId) {
        return lawyerDAO.readFieldsByLawyerId(lawyerId);
    }
}
