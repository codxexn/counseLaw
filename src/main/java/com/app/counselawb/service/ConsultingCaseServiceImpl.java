package com.app.counselawb.service;

import com.app.counselawb.domain.dto.ConsultDetailDTO;
import com.app.counselawb.domain.dto.ConsultingCaseDTO;
import com.app.counselawb.domain.dto.ConsultingWriteDTO;
import com.app.counselawb.domain.dto.LawyerSidebarDTO;
import com.app.counselawb.domain.pagination.Pagination;
import com.app.counselawb.domain.vo.ConsultingCaseVO;
import com.app.counselawb.domain.vo.LawyerVO;
import com.app.counselawb.repository.ConsultingCaseDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultingCaseServiceImpl implements ConsultingCaseService {

    private final ConsultingCaseDAO consultingCaseDAO;

    //    상담사례 전체 목록 불러오기
    @Override
    public List<ConsultingCaseDTO> selectAllCase(Pagination pagination) {
        return consultingCaseDAO.selectAllCase(pagination);
    }


    //    상담사례 전체 목록의 개수 불러오기
    @Override
    public int selectAllCaseCounts() {
        return consultingCaseDAO.selectAllCounts();
    }

    @Override
    public List<LawyerSidebarDTO> getLawyers() {
        return consultingCaseDAO.readLawyers();
    }

    //    상담사례 작성
    @Override
    public void insert(ConsultingWriteDTO consultingWriteDTO) {
        consultingCaseDAO.insertConsult(consultingWriteDTO);
    }

//    상담 상세페이지
    @Override
    public List<ConsultingCaseVO> readDetails(Long consultId) {
        return consultingCaseDAO.readDetail(consultId);
    }

    @Override
    public List<ConsultDetailDTO> readLawyer(Long consultId) {
        return consultingCaseDAO.readLawyerByConsultId(consultId);
    }

    @Override
    public int countTotalReply(Long consultId) {
        return consultingCaseDAO.readCountByConsultId(consultId);
    }
}
