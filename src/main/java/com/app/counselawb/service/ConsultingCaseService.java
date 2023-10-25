package com.app.counselawb.service;

import com.app.counselawb.domain.dto.ConsultDetailDTO;
import com.app.counselawb.domain.dto.ConsultingCaseDTO;
import com.app.counselawb.domain.dto.ConsultingWriteDTO;
import com.app.counselawb.domain.dto.LawyerSidebarDTO;
import com.app.counselawb.domain.pagination.Pagination;
import com.app.counselawb.domain.vo.ConsultingCaseVO;
import com.app.counselawb.domain.vo.LawyerVO;

import java.util.List;

public interface ConsultingCaseService {

//    상담사례 전체 목록 불러오기
    public List<ConsultingCaseDTO> selectAllCase(Pagination pagination);

//    상담사례 전체 목록의 개수 불러오기
    public int selectAllCaseCounts();

    //    상담사례 사이드바에 넣을 변호사 불러오기
    public List<LawyerSidebarDTO> getLawyers();

    //    상담글 작성
    public void insert(ConsultingWriteDTO consultingWriteDTO);

    //    상담 사례 상세페이지에 쓸 내용 불러오기
    public List<ConsultingCaseVO> readDetails(Long consultId);

    //    상담 사례 상세페이지용 변호사 id, 이름, 답변id, 답변 생성날짜 불러오기
    public List<ConsultDetailDTO> readLawyer(Long consultId);

    //    상담 사례 상세페이지용 consultId에 해당하는 답변의 개수
    public int countTotalReply(Long consultId);
}
