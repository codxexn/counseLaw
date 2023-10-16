package com.app.counselawb.mapper;

import com.app.counselawb.domain.pagination.Pagination;
import com.app.counselawb.domain.vo.ConsultingCaseVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ConsultingCaseMapper {

//    상담사례 전체 목록 불러오기
    public List<ConsultingCaseVO> readAllConsult(Pagination pagination);

//    상담사례 전체 목록의 개수 불러오기
    public int selectAllCaseCounts();

//    상담글 작성
    public void writeConsult(ConsultingCaseVO consultingCaseVO);

}