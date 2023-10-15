package com.app.counselawb.repository;

import com.app.counselawb.domain.vo.LawyerVO;
import com.app.counselawb.domain.vo.MemberVO;
import com.app.counselawb.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Slf4j
@RequiredArgsConstructor
public class MemberDAO {
    private final MemberMapper memberMapper;

    // 일반 회원 로그인
    public Optional<MemberVO> findByLogin(MemberVO memberVO) { return memberMapper.selectByLogin(memberVO);}

    // 변호사 회원 로그인
    public Optional<LawyerVO> findLawyerByLogin(LawyerVO lawyerVO) { return memberMapper.selectLawyerByLogin(lawyerVO);}
}
