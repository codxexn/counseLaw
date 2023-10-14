package com.app.counselawb.mapper;


import com.app.counselawb.domain.dto.LawyerFieldDTO;
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

}
