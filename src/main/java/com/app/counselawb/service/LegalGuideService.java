package com.app.counselawb.service;

import com.app.counselawb.domain.dto.LegalGuideDTO;
import com.app.counselawb.domain.vo.LegalGuideVO;

import java.util.List;

public interface LegalGuideService {

//    법률가이드 가져오기
//    public List<LegalGuideVO> findAllLegalGuide();

//    변호사, 분야 포함해서

   public List<LegalGuideDTO> findAllLegalGuideWithDetail();

}
