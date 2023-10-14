package com.app.counselawb.mapper;


import com.app.counselawb.domain.vo.LawyerVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface LawyerMapper {
    // 변호사 id로 변호사 정보 조회
    public Optional<LawyerVO> selectByLawyerId(Long lawyerId);

}
