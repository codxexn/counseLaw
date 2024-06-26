package com.app.counselawb.repository;

import com.app.counselawb.domain.dto.*;
import com.app.counselawb.domain.pagination.Pagination;
import com.app.counselawb.domain.vo.ConsultingCaseVO;
import com.app.counselawb.domain.vo.LawyerVO;
import com.app.counselawb.mapper.ConsultingCaseMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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

    //    조회수를 구하기 위해 caseId에 맞는 consultCase조회
    public int readCountById(Long consultId){
        return consultingCaseMapper.selectCountById(consultId);
    }

//    조회수 증가
    public void updateViewCount(Long consultId){
        consultingCaseMapper.updateViewCount(consultId);
    }
    //    상담사례 더보기를 위한 조회
    public List<ConsultingCaseDTO> readMoreConsult(){
        return consultingCaseMapper.readMoreConsult();
    }

//    해결사례 더보기를 위한 조회
    public List<ConsultDetailDTO> readSolutionCase(){
        return consultingCaseMapper.readSolutionCase();
    }

//    관심글 저장
    public void storeFavoriteCase(MyFavoriteConsultDTO myFavoriteConsultDTO){
        consultingCaseMapper.storeFavoritePosts(myFavoriteConsultDTO);
    }

//    관심글 여부 확인
    public Optional<MyFavoriteConsultDTO> readMyFavorite(Long memberId, Long consultingCaseId){
        return consultingCaseMapper.checkMyFavoritePosts(memberId, consultingCaseId);
    }

//    관심글 해제
    public void deleteFavoritePosts(Long memberId, Long ConsultingCaseId){
        consultingCaseMapper.deleteMyFavoritePosts(memberId, ConsultingCaseId);
    }

    //  관심글에 넣을 내용 조회
    public MyFavoriteConsultDTO readMyFavoriteCase(Long consultingCaseId){
        return consultingCaseMapper.readFavoritePosts(consultingCaseId);
    }

    //  내가 작성한 온라인 상담글 조회
    public List<ConsultingCaseVO> readMyConsult(Long memberId) { return consultingCaseMapper.selectMyConsult(memberId); }
}
