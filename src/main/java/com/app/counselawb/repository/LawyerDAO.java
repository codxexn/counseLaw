package com.app.counselawb.repository;


import com.app.counselawb.domain.dto.LawyerFieldDTO;
import com.app.counselawb.domain.vo.ExperienceVO;
import com.app.counselawb.domain.vo.FieldVO;
import com.app.counselawb.domain.vo.LawyerFieldVO;
import com.app.counselawb.domain.vo.LawyerVO;
import com.app.counselawb.mapper.LawyerMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Slf4j
@RequiredArgsConstructor
public class LawyerDAO {
    private final LawyerMapper lawyerMapper;

    // 변호사 id로 변호사 정보 조회
    public Optional<LawyerVO> readByLawyerId(Long lawyerId){
        return lawyerMapper.selectByLawyerId(lawyerId);
    }

    // 변호사 id로 해결 사례 게시물 개수 조회
    public int readSCTotalByLawyerId(Long lawyerId){
        return lawyerMapper.selectSCTotalByLawyerId(lawyerId);
    }

    // 변호사 id로 법률 가이드 게시물 개수 조회
    public int readLGTotalByLawyerId(Long lawyerId){
        return lawyerMapper.selectLGTotalByLawyerId(lawyerId);
    }

    // 변호사 id로 나를 즐겨찾기한 사람 수 조회
    public int readFavTotalByLawyerId(Long lawyerId){
        return lawyerMapper.selectFavTotalByLawyerId(lawyerId);
    }

    // 변호사 id로 분야들 조회
    public List<LawyerFieldDTO> readFieldsByLawyerId(Long lawyerId){
        return lawyerMapper.selectFieldsByLawyerId(lawyerId);
    }

    // 전화 상담 횟수 조회
    public int readPhoneCountByLawyerId(Long lawyerId){
        return lawyerMapper.selectPhoneCountByLawyerId(lawyerId);
    }

    // 영상 상담 횟수 조회
    public int readVideoCountByLawyerId(Long lawyerId){
        return lawyerMapper.selectVideoCountByLawyerId(lawyerId);
    }

    // 방문 상담 횟수 조회
    public int readVisitCountByLawyerId(Long lawyerId){
        return lawyerMapper.selectVisitCountByLawyerId(lawyerId);
    }

    // 상담 사례 답글 단 횟수 조회
    public int readReplyCountByLawyerId(Long lawyerId){
        return lawyerMapper.selectReplyCountByLawyerId(lawyerId);
    }

    // 비밀번호 변경
    public void modifyPw(LawyerVO lawyerVO){
        lawyerMapper.updatePw(lawyerVO);
    }

    // 전화번호 변경
    public void modifyPhone(LawyerVO lawyerVO){
        lawyerMapper.updatePhone(lawyerVO);
    }

    // 분야 리스트 조회
    public List<FieldVO> readAllFields(){
        return lawyerMapper.selectAllFields();
    }

    // 변호사 분야 추가
    public void writeLawyerFields(Long fieldId, Long lawyerId){
        lawyerMapper.insertLawyerFields(fieldId, lawyerId);
    }

    // 변호사 분야 삭제
    public void removeLawyerFields(Long lawyerId){
        lawyerMapper.deleteLawyerFields(lawyerId);
    }

    // 변호사 기타 정보 업데이트
    public void modifyLawyerInfo(LawyerVO lawyerVO){
        lawyerMapper.updateLawyerInfo(lawyerVO);
    }

    // 변호사 경력 조회
    public List<ExperienceVO> readCareersByLawyerId(Long lawyerId){
        return lawyerMapper.selectCareersByLawyerId(lawyerId);
    }

    // 경력 개별 삭제
    public void removeExperienceByExperienceId(Long experienceId){
        lawyerMapper.deleteExperienceByExperienceId(experienceId);
    }

    // 경력 추가
    public void writeExperience(ExperienceVO experienceVO){
        lawyerMapper.insertExperience(experienceVO);
    }
}
