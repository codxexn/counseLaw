package com.app.counselawb.mapper;

import com.app.counselawb.domain.vo.LawyerVO;
import com.app.counselawb.domain.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MemberMapper {

    // 일반 회원 로그인
    Optional<MemberVO> selectByLogin(MemberVO memberVO);

    // 변호사 회원 로그인
    Optional<LawyerVO> selectLawyerByLogin(LawyerVO lawyerVO);
}
