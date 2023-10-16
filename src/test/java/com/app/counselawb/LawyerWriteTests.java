package com.app.counselawb;


import com.app.counselawb.mapper.LawyerWriteMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class LawyerWriteTests {

    @Autowired
    private LawyerWriteMapper lawyerWriteMapper;

    @Test
    public void getLatestIdTest(){
        Long lawyerId = 1L;
        log.info("{}", lawyerWriteMapper.selectLatestIdByLawyerId(lawyerId));
    }
}
