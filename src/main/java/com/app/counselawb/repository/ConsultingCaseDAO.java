package com.app.counselawb.repository;

import com.app.counselawb.domain.pagination.Pagination;
import com.app.counselawb.domain.vo.ConsultingCaseVO;
import com.app.counselawb.mapper.ConsultingCaseMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ConsultingCaseDAO {
    private final ConsultingCaseMapper consultingCaseMapper;

//    상담사례 전체 목록 불러오기
    public List<ConsultingCaseVO> selectAllCase(Pagination pagination){
        return consultingCaseMapper.readAllConsult(pagination);
    }

//    페이징처리를 위해 상담사례 목록의 개수 불러오기
    public int selectAllCounts(){
        return consultingCaseMapper.selectAllCaseCounts();
    }

//    상담글 작성
    public void insertConsult(ConsultingCaseVO consultingCaseVO){
        consultingCaseMapper.writeConsult(consultingCaseVO);
    }
}
