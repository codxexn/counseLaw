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

    // 아이디 중복검사
    public Optional<MemberVO> findMemberByEmail(MemberVO memberVO) {
        return memberMapper.selectMemberByEmail(memberVO);
    }

    // 일반 회원 가입
    public void saveMember(MemberVO memberVO) {
        memberMapper.insertMember(memberVO);
    }

    // 변호사 아이디 중복검사
    public Optional<LawyerVO> findLawyerByEmail(LawyerVO lawyerVO) {
        return memberMapper.selectLawyerByEmail(lawyerVO);
    }

    // 변호사 회원 가입
    public void saveLawyer(LawyerVO lawyerVO) {
        memberMapper.insertLawyer(lawyerVO);
    }

    // 비밀번호 변경
    public void changePassword(long memberId, String memberPassword) { memberMapper.updatePassword(memberId, memberPassword); }

    // 전화번호 변경
    public void changePhone(long memberId, String memberPhone) { memberMapper.updatePhone(memberId, memberPhone); }

    // 내 전화상담내역 카운트
    public int countCallType(long memberId) { return memberMapper.countCallType(memberId); }

    // 내 영상상담내역 카운트
    public int countVideoType(long memberId) { return memberMapper.countVideoType(memberId); }

    // 내 방문상담내역 카운트
    public int countVisitType(long memberId) { return memberMapper.countVisitType(memberId); }

    // 내가 작성한 온라인 상담글 카운트
    public int countMyConsulting(long memberId) { return memberMapper.countMyConsulting(memberId); }

    // 회원가입시 웰컴쿠폰 인서트
    public void offerWelcomeCoupon(long memberId) { memberMapper.insertWelcomeCoupon(memberId); }
}
