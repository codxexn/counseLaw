package com.app.counselawb;


import com.app.counselawb.domain.dto.LawyerReviewDTO;
import com.app.counselawb.mapper.LawyerHomeMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class LawyerHomeTests {

    @Autowired
    private LawyerHomeMapper lawyerHomeMapper;

    @Test
    public void selectReviewsTest(){
        Long lawyerId = 1L;
        lawyerHomeMapper.selectReviewsByLawyerId(lawyerId).forEach((lawyerReviewDTO -> {
            log.info("{}", lawyerReviewDTO);
        }));
    }
}
