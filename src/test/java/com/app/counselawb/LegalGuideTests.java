package com.app.counselawb;

import com.app.counselawb.domain.vo.LegalGuideVO;
import com.app.counselawb.mapper.LegalGuideMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j

public class LegalGuideTests {
    @Autowired
    private LegalGuideMapper legalGuideMapper;

    @Test
    public void legalguideMapperTests(){
        LegalGuideVO legalGuideVO = new LegalGuideVO();
        legalGuideVO.setLegalGuideTitle("구속영장");
        legalGuideVO.setLegalGuideContent("3년징역");
    }
}
