package com.app.counselawb.repository;

import com.app.counselawb.domain.dto.ConsultDetailDTO;
import com.app.counselawb.domain.dto.ConsultingCaseDTO;
import com.app.counselawb.domain.dto.ConsultingWriteDTO;
import com.app.counselawb.domain.dto.LawyerSidebarDTO;
import com.app.counselawb.domain.pagination.Pagination;
import com.app.counselawb.domain.vo.ConsultingCaseVO;
import com.app.counselawb.domain.vo.LawyerVO;
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
    public List<ConsultingCaseDTO> selectAllCase(Pagination pagination){
        return consultingCaseMapper.readAllConsult(pagination);
    }

//    페이징처리를 위해 상담사례 목록의 개수 불러오기
    public int selectAllCounts(){
        return consultingCaseMapper.selectAllCaseCounts();
    }

//    상담사례 사이드바에 넣을 변호사 불러오기
    public List<LawyerSidebarDTO> readLawyers(){
        return consultingCaseMapper.readAllLawyers();
    }

//    상담글 작성
    public void insertConsult(ConsultingWriteDTO consultingWriteDTO){
        consultingCaseMapper.writeConsult(consultingWriteDTO);
    }

//    상담 사례 상세페이지에 쓸 내용 불러오기
    public List<ConsultingCaseVO> readDetail(Long consultId){
        return consultingCaseMapper.readDetailConsult(consultId);
    }

    //    상담 사례 상세페이지용 변호사 id, 이름, 답변id, 답변 생성날짜 불러오기
    public List<ConsultDetailDTO> readLawyerByConsultId(Long consultId){
        return consultingCaseMapper.readLawyerByConsultId(consultId);
    }

    //    상담 사례 상세페이지용 consultId에 해당하는 답변의 개수
    public int readCountByConsultId(Long consultId){
        return consultingCaseMapper.countReplyByConsultId(consultId);
    }
}
