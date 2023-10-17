package com.app.counselawb.repository;

import com.app.counselawb.domain.dto.ConsultingCaseReplyDTO;
import com.app.counselawb.mapper.ConsultingCaseReplyMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ConsultingCaseReplyDAO {
    private final ConsultingCaseReplyMapper consultingCaseReplyMapper;

    public List<ConsultingCaseReplyDTO> findAllByConsultingCaseId(Long consultingCaseId) {
        return consultingCaseReplyMapper.selectAllByConsultingCaseId(consultingCaseId);
    }
}
