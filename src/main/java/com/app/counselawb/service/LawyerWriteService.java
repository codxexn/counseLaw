package com.app.counselawb.service;

import com.app.counselawb.domain.vo.LegalGuideVO;

public interface LawyerWriteService {
    // 법률 가이드 작성
    public void saveLegalGuide(LegalGuideVO legalGuideVO);
}
