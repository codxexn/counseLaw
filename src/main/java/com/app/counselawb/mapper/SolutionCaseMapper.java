package com.app.counselawb.mapper;

import com.app.counselawb.domain.dto.SolutionCaseDTO;
import com.app.counselawb.domain.vo.SolutionCaseImgVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface SolutionCaseMapper {

//    목록 가져오기
    public List<SolutionCaseDTO> selectAllSolution();

//    상세 페이지
    public Optional<SolutionCaseDTO> selectDetailSolution(Long solutionCaseId);

//    이미지 가져오기
    public Optional<SolutionCaseImgVO> selectSolutionImg(Long solutionCaseId);

}
