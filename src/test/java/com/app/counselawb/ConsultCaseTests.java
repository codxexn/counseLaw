package com.app.counselawb;

import com.app.counselawb.domain.vo.ConsultingCaseVO;
import com.app.counselawb.mapper.ConsultingCaseMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class ConsultCaseTests {

    @Autowired
    private ConsultingCaseMapper consultingCaseMapper;
    @Autowired
    private ConsultingCaseVO consultingCaseVO;

    @Test
    public void selectAllCase(){
//        List<ConsultingCaseVO> li =  consultingCaseMapper.selectAllConsultingCase();
//        System.out.println(li);
    }
}
