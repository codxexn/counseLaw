package com.app.counselawb.mapper;

import com.app.counselawb.domain.vo.SolutionCaseImgVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SolutionCaseImgMapper {
    // 해결사례Id로 이미지들 가져오기
    public List<SolutionCaseImgVO> selectSolutionCaseImages(Long solutionCaseId);
}
