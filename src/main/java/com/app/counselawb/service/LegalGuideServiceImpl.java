package com.app.counselawb.service;

import com.app.counselawb.domain.dto.LegalGuideDTO;
import com.app.counselawb.domain.vo.LegalGuideVO;
import com.app.counselawb.mapper.LegalGuideMapper;
import com.app.counselawb.repository.LegalGuideDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class LegalGuideServiceImpl implements LegalGuideService {

    private final LegalGuideDAO legalGuideDAO;

//    @Override
//    public List<LegalGuideVO> findAllLegalGuide() {
//        return legalGuideDAO.findAllLegalGuide();
//    }

    @Override
    public List<LegalGuideDTO> findAllLegalGuideWithDetail() {return legalGuideDAO.findAllLegalGuideWithDetail();}
}
