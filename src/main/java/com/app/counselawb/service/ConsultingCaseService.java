package com.app.counselawb.service;

import com.app.counselawb.domain.dto.ConsultDetailDTO;
import com.app.counselawb.domain.dto.ConsultingWriteDTO;
import com.app.counselawb.domain.pagination.Pagination;
import com.app.counselawb.domain.vo.ConsultingCaseVO;

import java.util.List;

public interface ConsultingCaseService {

//    상담사례 전체 목록 불러오기
    public List<ConsultingCaseVO> selectAllCase(Pagination pagination);

//    상담사례 전체 목록의 개수 불러오기
    public int selectAllCaseCounts();

    //    상담글 작성
    public void insert(ConsultingWriteDTO consultingWriteDTO);

    //    상담 사례 상세페이지에 쓸 내용 불러오기
    public List<ConsultDetailDTO> readDetails(Pagination pagination);
}
