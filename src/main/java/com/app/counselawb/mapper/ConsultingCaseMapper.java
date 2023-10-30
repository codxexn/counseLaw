package com.app.counselawb.mapper;

import com.app.counselawb.domain.dto.*;
import com.app.counselawb.domain.pagination.Pagination;
import com.app.counselawb.domain.vo.ConsultingCaseVO;
import com.app.counselawb.domain.vo.LawyerVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ConsultingCaseMapper {

//    상담사례 전체 목록 불러오기
    public List<ConsultingCaseDTO> readAllConsult(Pagination pagination);

//    상담사례 전체 목록의 개수 불러오기
    public int selectAllCaseCounts();

//    상담사례 사이드바 변호사 불러오기
    public List<LawyerSidebarDTO> readAllLawyers();

//    상담글 작성
    public void writeConsult(ConsultingWriteDTO consultingWriteDTO);

//    상담 사례 상세페이지용 제목, 내용, 시간 불러오기
    public List<ConsultingCaseVO> readDetailConsult(Long consultId);

//    상담 사례 상세페이지용 변호사 id, 이름, 답변id, 답변 생성날짜 불러오기
    public List<ConsultDetailDTO> readLawyerByConsultId(Long consultId);

//    상담 사례 상세페이지용 consultId에 해당하는 답변의 개수
    public int countReplyByConsultId(Long consultId);

//    조회수를 구하기 위해 caseId에 맞는 consultCase조회
    public int readById(Long consultId);

//    조회수 증가
    public void updateViewCount(Long consultId);

//    상담사례 더보기를 위한 조회
    public List<ConsultingCaseDTO> readMoreConsult();

//    해결사례를 위한 조회
    public List<ConsultDetailDTO> readSolutionCase();

//    관심글 저장
    public void storeFavoritePosts(MyFavoriteConsultDTO myFavoriteConsultDTO);

//    관심글 여부 확인
    public Optional<MyFavoriteConsultDTO> checkMyFavoritePosts(Long memberId, Long consultingCaseId);

//    관심글 해제
    public void deleteMyFavoritePosts(Long memberId, Long consultingCaseId);

//  관심글에 넣을 내용 조회
    public MyFavoriteConsultDTO readFavoritePosts(Long consultingCaseId);
}
