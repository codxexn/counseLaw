package com.app.counselawb.service;

import com.app.counselawb.domain.vo.LawyerVO;
import com.app.counselawb.domain.vo.MemberVO;
import com.app.counselawb.repository.MemberDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class MemberServiceImpl implements MemberService {
    private final MemberDAO memberDAO;

    // 일반회원 로그인
    @Override
    public Optional<MemberVO> memberLogin(MemberVO memberVO) {
        return memberDAO.findByLogin(memberVO);
    }

    // 변호사회원 로그인
    @Override
    public Optional<LawyerVO> lawyerLogin(LawyerVO lawyerVO) { return memberDAO.findLawyerByLogin(lawyerVO); }

    // 아이디 중복검사
    @Override
    public Optional<MemberVO> duplicationMemberCheckByEmail(MemberVO memberVO) {
        return memberDAO.findMemberByEmail(memberVO);
    }

    // 일반 회원 가입
    @Override
    public void joinMember(MemberVO memberVO) {
        memberDAO.saveMember(memberVO);
    }


    // 변호사 아이디 중복검사
    @Override
    public Optional<LawyerVO> duplicationLawyerCheckByEmail(LawyerVO lawyerVO) {
        return memberDAO.findLawyerByEmail(lawyerVO);
    }

    // 변호사 회원가입
    @Override
    public void joinLawyer(LawyerVO lawyerVO){
        memberDAO.saveLawyer(lawyerVO);
    }

}
