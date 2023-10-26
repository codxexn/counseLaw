package com.app.counselawb.mapper;


import com.app.counselawb.domain.dto.LawyerFieldSearchDTO;
import com.app.counselawb.domain.dto.LawyerLocationSearchDTO;
import com.app.counselawb.domain.pagination.Pagination;
import com.app.counselawb.domain.vo.FieldCategoryVO;
import com.app.counselawb.domain.vo.FieldVO;
import com.app.counselawb.domain.vo.LocationVO;
import org.apache.ibatis.annotations.Mapper;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Mapper
public interface LawyerSearchMapper {
    // 분야 카테고리 전부 가져오기
    public List<FieldCategoryVO> selectAllFieldCategories();

    // 분야 id로 변호사 명수 가져오기
    public int selectLawyersCountByFieldId(Long fieldId);

    // 분야 id로 변호사 정보 등 가져오기
    public List<LawyerFieldSearchDTO> selectLawyersByFieldId(Pagination pagination, Long fieldId);

    // 분야 정보 가져오기
    public Optional<FieldVO> selectFieldInfo(Long fieldId);

    // 지역 정보 가져오기
    public Optional<LocationVO> selectLocationInfo(Long locationId);

    // 지역 id로 변호사 명수 가져오기
    public int selectLawyersCountByLocationId(Long locationId);

    // 지역 id로 변호사 정보 등 가져오기
    public List<LawyerLocationSearchDTO> selectLawyersByLocationId(Pagination pagination, Long locationId);
}
