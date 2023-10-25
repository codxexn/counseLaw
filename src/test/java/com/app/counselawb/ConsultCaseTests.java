package com.app.counselawb;

import com.app.counselawb.domain.dto.ConsultDetailDTO;
import com.app.counselawb.domain.dto.ConsultingCaseDTO;
import com.app.counselawb.domain.dto.LawyerSidebarDTO;
import com.app.counselawb.domain.pagination.Pagination;
import com.app.counselawb.domain.vo.ConsultingCaseVO;
import com.app.counselawb.domain.vo.LawyerVO;
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
        Pagination pagination = new Pagination();
        List<ConsultingCaseDTO> li =  consultingCaseMapper.readAllConsult(pagination);
        log.info(li.toString());
    }

    @Test
    public void getLawyers(){
        List<ConsultDetailDTO> li = consultingCaseMapper.readLawyerByConsultId(21L);

        log.info(li.toString());
    }


}
