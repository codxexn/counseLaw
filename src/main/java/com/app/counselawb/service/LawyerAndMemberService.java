package com.app.counselawb.service;

import com.app.counselawb.domain.dto.LawyerAndMemberDTO;
import com.app.counselawb.domain.pagination.Pagination;
import com.app.counselawb.domain.vo.LawyerVO;
import com.app.counselawb.domain.vo.MemberVO;

import java.util.List;

public interface LawyerAndMemberService {
    // 모든 회원 조회
    public List<LawyerAndMemberDTO> findAllLawyerAndMember(Pagination pagination);

    // 모든 회원 조회 개수
    public int findAllTotalCount();

    // 일반 회원 조회
    public List<MemberVO> findAllMember(Pagination pagination);

    // 일반 회원 조회 개수
    public int findAllMemberTotalCount();

    // 변호사 회원 조회
    public List<LawyerVO> findAllLawyer(Pagination pagination);

    // 변호사 회원 조회 개수
    public int findAllLawyerTotalCount();

    // 멤버 삭제
    public void modifyMember(Long memberId);

    // 변호사 삭제
    public void modifyLawyer(Long lawyerId);

    // 멤버 복구
    public void modifyUnsuspendMember(Long memberId);

    // 변호사 복구
    public void modifyUnsuspendLawyer(Long lawyerId);


}
