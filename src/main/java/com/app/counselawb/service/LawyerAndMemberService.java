package com.app.counselawb.service;

import com.app.counselawb.domain.dto.LawyerAndMemberDTO;
import com.app.counselawb.domain.vo.LawyerVO;
import com.app.counselawb.domain.vo.MemberVO;

import java.util.List;

public interface LawyerAndMemberService {
    // 모든 회원 조회
    public List<LawyerAndMemberDTO> findAllLawyerAndMember();
    // 일반 회원 조회
    public List<MemberVO> findAllMember();

    // 변호사 회원 조회
    public List<LawyerVO> findAllLawyer();

}
