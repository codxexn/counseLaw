package com.app.counselawb.repository;


import com.app.counselawb.domain.dto.LawyerLocationDTO;
import com.app.counselawb.domain.vo.LawyerLocationVO;
import com.app.counselawb.domain.vo.LocationVO;
import com.app.counselawb.mapper.LocationMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
@RequiredArgsConstructor
public class LocationDAO {
    private final LocationMapper locationMapper;

    // 지역 리스트 가져오기
    public List<LocationVO> readAllLocations(){
        return locationMapper.selectAllLocations();
    }

    // 변호사 id로 지역들 가져오기
    public List<LawyerLocationDTO> readLocationsByLawyerId(Long lawyerId){
        return locationMapper.selectLocationsByLawyerId(lawyerId);
    }

    // 변호사 지역 전체 삭제
    public void removeLocationsByLawyerId(Long lawyerId){
        locationMapper.deleteLocationsByLawyerId(lawyerId);
    }

    // 변호사 지역 추가
    public void writeLocationsByLawyerId(LawyerLocationVO lawyerLocationVO){
        locationMapper.insertLocationsByLawyerId(lawyerLocationVO);
    }
}
