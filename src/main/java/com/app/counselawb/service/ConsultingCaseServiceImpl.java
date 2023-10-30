package com.app.counselawb.service;

import com.app.counselawb.domain.dto.*;
import com.app.counselawb.domain.pagination.Pagination;
import com.app.counselawb.domain.vo.ConsultingCaseVO;
import com.app.counselawb.domain.vo.LawyerVO;
import com.app.counselawb.repository.ConsultingCaseDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    //    상담 사례 상세페이지용 consultId에 해당하는 답변의 개수
    @Override
    public int countTotalReply(Long consultId) {
        return consultingCaseDAO.readCountByConsultId(consultId);
    }

    //    조회수를 구하기 위해 caseId에 맞는 consultCase 조회
    @Override
    public int readCountById(Long consultId) {
        return consultingCaseDAO.readCount(consultId);
    }

    @Override
    public void increaseViewCount(Long consultId) {
        consultingCaseDAO.updateViewCount(consultId);
    }

    @Override
    public List<ConsultingCaseDTO> readMoreConsult() {
        return consultingCaseDAO.readMoreConsult();
    }
    //    해결사례 더보기를 위한 조회
    @Override
    public List<ConsultDetailDTO> selectSolutionCase() {
        return consultingCaseDAO.readSolutionCase();
    }

    @Override
    public void storeFavoriteCases(MyFavoriteConsultDTO myFavoriteConsultDTO) {
        consultingCaseDAO.storeFavoriteCase(myFavoriteConsultDTO);
    }

    @Override
    public Optional<MyFavoriteConsultDTO> readMyFavorite(Long memberId, Long consultingCaseId) {
        return consultingCaseDAO.readMyFavorite(memberId, consultingCaseId);
    }

    @Override
    public void deleteFavorite(Long memberId, Long consultingCaseId) {
        consultingCaseDAO.deleteFavoritePosts(memberId, consultingCaseId);
    }

    @Override
    public MyFavoriteConsultDTO readFavoriteCases(Long consultingCaseId) {
        return consultingCaseDAO.readMyFavoriteCase(consultingCaseId);
    }
}
