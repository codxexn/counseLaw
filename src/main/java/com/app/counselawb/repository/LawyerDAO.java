package com.app.counselawb.repository;


import com.app.counselawb.domain.vo.LawyerVO;
import com.app.counselawb.mapper.LawyerMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

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
}
