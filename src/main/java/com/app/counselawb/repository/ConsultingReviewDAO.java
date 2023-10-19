package com.app.counselawb.repository;


import com.app.counselawb.mapper.ConsultingReviewMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
@RequiredArgsConstructor
public class ConsultingReviewDAO {
    private final ConsultingReviewMapper consultingReviewMapper;

    // 변호사 id로 의뢰인후기 개수 가져오기
    public int readReviewCountsByLawyerId(Long lawyerId){
        return consultingReviewMapper.selectReviewCountsByLawyerId(lawyerId);
    }
}
