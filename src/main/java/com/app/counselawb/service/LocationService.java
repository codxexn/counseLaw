package com.app.counselawb.service;

import com.app.counselawb.domain.dto.LawyerLocationDTO;
import com.app.counselawb.domain.vo.LawyerLocationVO;
import com.app.counselawb.domain.vo.LocationVO;

import java.util.List;

public interface LocationService {

    // 지역 리스트 가져오기
    public List<LocationVO> findAllLocations();

    // 변호사 id로 지역들 가져오기
    public List<LawyerLocationDTO> findLocationsByLawyerId(Long lawyerId);

    // 변호사 지역 전체 삭제
    public void discardLocationsByLawyerId(Long lawyerId);

    // 변호사 지역 추가
    public void saveLocationsByLawyerId(LawyerLocationVO lawyerLocationVO);
}
