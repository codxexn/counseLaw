package com.app.counselawb;

import com.app.counselawb.domain.pagination.Pagination;
import com.app.counselawb.domain.vo.LawyerLikeVO;
import com.app.counselawb.mapper.MemberMypageMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RequiredArgsConstructor
@Slf4j
public class MemberMypageTests {
    @Autowired
    private MemberMypageMapper memberMypageMapper;

    // 변호사 즐겨찾기 추가
    @Test
    public void insertMyFavoriteLawyerMapperTest() {
        LawyerLikeVO lawyerLikeVO = new LawyerLikeVO();
        lawyerLikeVO.setMemberId(41L);
        lawyerLikeVO.setLawyerId(50L);
        memberMypageMapper.insertMyFavoriteLawyer(lawyerLikeVO);
    }

    // 내가 즐겨찾기한 변호사
//    @Test
//    public void selectMyFavoriteLawyers() {
//        Pagination pagination = new Pagination();
//        pagination.setTotal(memberMypageMapper.getCountMyFavoriteLawyers(41L));
//        pagination.progress();
//        memberMypageMapper.selectMyFavoriteLawyers(41L, pagination).stream().map(LawyerLikeVO::toString).forEach(log::info);
//    }

}
