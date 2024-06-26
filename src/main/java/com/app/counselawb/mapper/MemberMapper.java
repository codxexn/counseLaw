package com.app.counselawb.mapper;

import com.app.counselawb.domain.vo.LawyerVO;
import com.app.counselawb.domain.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MemberMapper {

    // 일반 회원 로그인
    public Optional<MemberVO> selectByLogin(MemberVO memberVO);

    // 변호사 회원 로그인
    public Optional<LawyerVO> selectLawyerByLogin(LawyerVO lawyerVO);

    // 일반 아이디 중복검사
    public Optional<MemberVO> selectMemberByEmail(MemberVO memberVO);

    // 일반 회원 가입
    public void insertMember(MemberVO memberVO);

    // 변호사 아이디 중복검사
    public Optional<LawyerVO> selectLawyerByEmail(LawyerVO lawyerVO);

    // 변호사 회원 가입
    public void insertLawyer(LawyerVO lawyerVO);

    // 비밀번호 변경
    public void updatePassword(long memberId, String memberPassword);

    // 전화번호 변경
    public void updatePhone(long memberId, String memberPhone);

    // 내 전화상담내역 카운트
    public int countCallType(long memberId);

    // 내 영상상담내역 카운트
    public int countVideoType(long memberId);

    // 내 방문상담내역 카운트
    public int countVisitType(long memberId);

    // 내가 작성한 온라인 상담글 카운트
    public int countMyConsulting(long memberId);

    // 회원가입시 웰컴쿠폰 인서트
    public void insertWelcomeCoupon(long memberId);

}
