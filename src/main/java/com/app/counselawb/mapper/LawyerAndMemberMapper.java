package com.app.counselawb.mapper;

import com.app.counselawb.domain.dto.LawyerAndMemberDTO;
import com.app.counselawb.domain.vo.LawyerVO;
import com.app.counselawb.domain.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LawyerAndMemberMapper {
    // 모든 회원 조회
    public List<LawyerAndMemberDTO> selectAllLawyerAndMember();

    // 일반 회원 조회
    public List<MemberVO> selectAllMember();

    // 뱐호사 회원 조회
    public List<LawyerVO> selectAllLawyer();
}
