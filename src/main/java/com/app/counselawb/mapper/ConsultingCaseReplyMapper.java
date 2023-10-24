package com.app.counselawb.mapper;

import com.app.counselawb.domain.dto.ConsultingCaseReplyDTO;
import com.app.counselawb.domain.vo.ConsultingCaseReplyVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ConsultingCaseReplyMapper {
    // 각 상담 사례 게시글 별  댓글 가져오기
    public List<ConsultingCaseReplyDTO> selectAllByConsultingCaseId(Long consultingCaseId);
}
