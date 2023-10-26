package com.app.counselawb.mapper;

import com.app.counselawb.domain.dto.SolutionCaseDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SolutionCaseMapper {
    public List<SolutionCaseDTO> selectAllSolution();

}
