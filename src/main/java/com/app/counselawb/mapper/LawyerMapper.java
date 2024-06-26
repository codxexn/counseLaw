package com.app.counselawb.mapper;


import com.app.counselawb.domain.dto.LawyerFieldDTO;
import com.app.counselawb.domain.vo.ExperienceVO;
import com.app.counselawb.domain.vo.FieldVO;
import com.app.counselawb.domain.vo.LawyerFieldVO;
import com.app.counselawb.domain.vo.LawyerVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface LawyerMapper {
    // 변호사 id로 변호사 정보 조회
    public Optional<LawyerVO> selectByLawyerId(Long lawyerId);

    // 변호사 id로 해결 사례 게시물 개수 조회
    public int selectSCTotalByLawyerId(Long lawyerId);

    // 변호사 id로 법률 가이드 게시물 개수 조회
    public int selectLGTotalByLawyerId(Long lawyerId);

    // 변호사 id로 나를 즐겨찾기한 사람 수 조회
    public int selectFavTotalByLawyerId(Long lawyerId);

    // 변호사 id로 분야들 조회
    public List<LawyerFieldDTO> selectFieldsByLawyerId(Long lawyerId);

    // 전화 상담 횟수 조회
    public int selectPhoneCountByLawyerId(Long lawyerId);

    // 영상 상담 횟수 조회
    public int selectVideoCountByLawyerId(Long lawyerId);

    // 방문 상담 횟수 조회
    public int selectVisitCountByLawyerId(Long lawyerId);

    // 상담 사례 답글 단 횟수 조회
    public int selectReplyCountByLawyerId(Long lawyerId);

    // 비밀번호 변경
    public void updatePw(LawyerVO lawyerVO);

    // 전화번호 변경
    public void updatePhone(LawyerVO lawyerVO);

    // 분야 리스트 조회
    public List<FieldVO> selectAllFields();

    // 변호사 분야 추가
    public void insertLawyerFields(Long fieldId, Long lawyerId);

    // 변호사 분야 삭제
    public void deleteLawyerFields(Long lawyerId);

    // 변호사 기타 정보 업데이트
    public void updateLawyerInfo(LawyerVO lawyerVO);

    // 변호사 경력 조회
    public List<ExperienceVO> selectCareersByLawyerId(Long lawyerId);

    // 경력 개별 삭제
    public void deleteExperienceByExperienceId(Long experienceId);

    // 경력 추가
    public void insertExperience(ExperienceVO experienceVO);

    // 변호사 프사 업데이트
    public void updateProfileImage(LawyerVO lawyerVO);

    // 변호사 프사 가져오기
    public String selectProfileImage(Long lawyerId);

    // 변호사 프사 삭제
    public void deleteProfileImage(Long lawyerId);

    // 변호사 해결사례 삭제
    public void deleteSCByLawyerId(Long lawyerId);

    // 변호사 법률가이드 삭제
    public void deleteLGByLawyerId(Long lawyerId);

    // 변호사 분야 삭제
    public void deleteFieldByLawyerId(Long lawyerId);

    // 변호사 지역 삭제
    public void deleteLocationByLawyerId(Long lawyerId);

    // 변호사 경력 삭제
    public void deleteCareerByLawyerId(Long lawyerId);

    // 변호사 답글 삭제
    public void deleteReplyByLawyerId(Long lawyerId);

    // 변호사 즐찾 삭제
    public void deleteLawyerLikeByLawyerId(Long lawyerId);

    // 변호사 탈퇴(삭제)
    public void deleteLawyer(Long lawyerId);

    // 변호사 탈퇴시 예약 상태 취소로 변경
    public void deleteLawyerReservation(Long lawyerId);

}
