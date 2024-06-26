package com.app.counselawb.service;

import com.app.counselawb.domain.dto.*;
import com.app.counselawb.domain.pagination.Pagination;
import com.app.counselawb.domain.vo.ConsultingCaseVO;
import com.app.counselawb.domain.vo.LawyerVO;

import java.util.List;
import java.util.Optional;

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

    //    조회수를 구하기 위해 caseId에 맞는 consultCase조회
    public int readCountById(Long consultId);

//    조회수 증가
    public void increaseViewCount(Long consultId);

    //    상담사례 더보기를 위한 조회
    public List<ConsultingCaseDTO> readMoreConsult();

    //    해결사례 더보기를 위한 조회
    public List<ConsultDetailDTO> selectSolutionCase();

//    관심글 저장
    public void storeFavoriteCases(MyFavoriteConsultDTO myFavoriteConsultDTO);

//    관심글 여부 확인
    public Optional<MyFavoriteConsultDTO> readMyFavorite(Long memberId, Long consultingCaseId);

//    관심글 해제
    public void deleteFavorite(Long memberId, Long consultingCaseId);

    //  관심글에 넣을 내용 조회
    public MyFavoriteConsultDTO readFavoriteCases(Long consultingCaseId);

    //  내가 작성한 온라인 상담글 조회
    public List<ConsultingCaseVO> readMyConsult(Long memberId);
}
