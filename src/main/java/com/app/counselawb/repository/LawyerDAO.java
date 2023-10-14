package com.app.counselawb.repository;


import com.app.counselawb.domain.dto.LawyerFieldDTO;
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
}
