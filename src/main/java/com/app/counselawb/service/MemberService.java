package com.app.counselawb.service;

import com.app.counselawb.domain.vo.LawyerVO;
import com.app.counselawb.domain.vo.MemberVO;

import java.util.Optional;

public interface MemberService {

    // 일반 회원 로그인
    public Optional<MemberVO> memberLogin(MemberVO memberVO);

    // 변호사 회원 로그인
    public Optional<LawyerVO> lawyerLogin(LawyerVO lawyerVO);

    // 아이디 중복검사
    public Optional<MemberVO> duplicationMemberCheckByEmail(MemberVO memberVO);

    // 일반 회원 가입
    public void joinMember(MemberVO memberVO);

    // 변호사 아이디 중복검사
    public Optional<LawyerVO> duplicationLawyerCheckByEmail(LawyerVO lawyerVO);

    // 변호사 회원가입
    public void joinLawyer(LawyerVO lawyerVO);

}
