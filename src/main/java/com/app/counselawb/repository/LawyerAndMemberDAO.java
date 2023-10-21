package com.app.counselawb.repository;

import com.app.counselawb.domain.dto.LawyerAndMemberDTO;
import com.app.counselawb.domain.vo.LawyerVO;
import com.app.counselawb.domain.vo.MemberVO;
import com.app.counselawb.mapper.LawyerAndMemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
@RequiredArgsConstructor
public class LawyerAndMemberDAO {
    private final LawyerAndMemberMapper lawyerAndMemberMapper;
    // 모든 회원 조회
    public List<LawyerAndMemberDTO> findAllLawyerAndMember() {return  lawyerAndMemberMapper.selectAllLawyerAndMember(); }

    // 일반 회원 조회
    public List<MemberVO> findAllMember() {return lawyerAndMemberMapper.selectAllMember(); }

    // 변호사 회원 조회
    public List<LawyerVO> findAllLawyer() {return lawyerAndMemberMapper.selectAllLawyer(); }
}
