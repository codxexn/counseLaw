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

    // 비밀번호 변경
    public void changePassword(long memberId, String memberPassword);

    // 전화번호 변경
    public void changePhone(long memberId, String memberPhone);

    // 내 전화상담내역 카운트
    public int countCallType(long memberId);

    // 내 영상상담내역 카운트
    public int countVideoType(long memberId);

    // 내 방문상담내역 카운트
    public int countVisitType(long memberId);

    // 내가 작성한 온라인 상담글 카운트
    public int countMyConsulting(long memberId);

    // 회원가입시 웰컴쿠폰 인서트
    public void offerWelcomeCoupon(long memberId);

}
