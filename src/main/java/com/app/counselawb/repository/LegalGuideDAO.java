package com.app.counselawb.repository;

import com.app.counselawb.domain.dto.LegalGuideDTO;
import com.app.counselawb.domain.vo.LegalGuideVO;
import com.app.counselawb.mapper.LegalGuideMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Repository
public class LegalGuideDAO {
    private final LegalGuideMapper legalGuideMapper;

//    public List<LegalGuideVO> findAllLegalGuide() {
//        return legalGuideMapper.selectAllLegalGuide();
//    }
//      게시글 목록 불러오기
    public List<LegalGuideDTO> findAllLegalGuideWithDetail() {
        return legalGuideMapper.selectAllLegalGuideWithDetail();
    }

    public List<LegalGuideDTO> findDetailLegal() {
        return legalGuideMapper.selectDetailLegal();
    }


}
