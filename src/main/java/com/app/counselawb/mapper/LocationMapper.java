package com.app.counselawb.mapper;


import com.app.counselawb.domain.dto.LawyerLocationDTO;
import com.app.counselawb.domain.vo.LawyerLocationVO;
import com.app.counselawb.domain.vo.LocationVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LocationMapper {
    // 지역 리스트 가져오기
    public List<LocationVO> selectAllLocations();

    // 변호사 id로 지역 가져오기
    public List<LawyerLocationDTO> selectLocationsByLawyerId(Long lawyerId);

    // 변호사 지역 전체 삭제
    public void deleteLocationsByLawyerId(Long lawyerId);

    // 변호사 지역 추가
    public void insertLocationsByLawyerId(LawyerLocationVO lawyerLocationVO);
}
