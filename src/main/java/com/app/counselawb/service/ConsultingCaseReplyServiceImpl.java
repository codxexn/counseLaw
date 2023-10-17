package com.app.counselawb.service;

import com.app.counselawb.domain.dto.ConsultingCaseReplyDTO;
import com.app.counselawb.repository.ConsultingCaseReplyDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultingCaseReplyServiceImpl implements ConsultingCaseReplyService {
    private final ConsultingCaseReplyDAO consultingCaseReplyDAO;
    @Override
    public List<ConsultingCaseReplyDTO> findAllByConsultingCaseId(Long consultingCaseId) {
        return consultingCaseReplyDAO.findAllByConsultingCaseId(consultingCaseId);
    }
}
