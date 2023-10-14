package com.app.counselawb.service;

import com.app.counselawb.domain.dto.LawyerFieldDTO;
import com.app.counselawb.domain.vo.LawyerFieldVO;
import com.app.counselawb.domain.vo.LawyerVO;

import java.util.List;
import java.util.Optional;

public interface LawyerService {

    // 변호사 id로 변호사 정보 조회
    public Optional<LawyerVO> findByLawyerId(Long lawyerId);

    // 변호사 id로 해결 사례 게시물 개수 조회
    public int findSCTotalByLawyerId(Long lawyerId);

    // 변호사 id로 법률 가이드 게시물 개수 조회
    public int findLGTotalByLawyerId(Long lawyerId);

    // 변호사 id로 나를 즐겨찾기한 사람 수 조회
    public int findFavTotalByLawyerId(Long lawyerId);

    // 변호사 id로 분야들 조회
    public List<LawyerFieldDTO> findFieldsByLawyerId(Long lawyerId);
}
