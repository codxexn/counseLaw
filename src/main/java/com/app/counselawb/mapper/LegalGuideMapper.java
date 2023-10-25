package com.app.counselawb.mapper;

import com.app.counselawb.domain.dto.LegalGuideDTO;
import com.app.counselawb.domain.vo.LegalGuideVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LegalGuideMapper {
//    public List<LegalGuideVO> selectAllLegalGuide();

    public List<LegalGuideDTO> selectAllLegalGuideWithDetail();
}
