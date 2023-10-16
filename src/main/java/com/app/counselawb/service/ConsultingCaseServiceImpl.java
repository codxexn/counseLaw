package com.app.counselawb.service;

import com.app.counselawb.domain.pagination.Pagination;
import com.app.counselawb.domain.vo.ConsultingCaseVO;
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
    public List<ConsultingCaseVO> selectAllCase(Pagination pagination) {
        return consultingCaseDAO.selectAllCase(pagination);
    }


    //    상담사례 전체 목록의 개수 불러오기
    @Override
    public int selectAllCaseCounts() {
        return consultingCaseDAO.selectAllCounts();
    }

    @Override
    public void insert(ConsultingCaseVO consultingCaseVO) {
        consultingCaseDAO.insertConsult(consultingCaseVO);
    }
}
