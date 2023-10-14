package com.app.counselawb;


import com.app.counselawb.domain.vo.LawyerVO;
import com.app.counselawb.mapper.LawyerMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class LawyerTests {
    @Autowired
    private LawyerMapper lawyerMapper;

    @Test
    public void selectByLawyerIdTest(){
        lawyerMapper.selectByLawyerId(1L).map(LawyerVO::toString).ifPresent(log::info);
    }
}
