package com.app.counselawb.repository;

import com.app.counselawb.domain.dto.LawyerAndMemberDTO;
import com.app.counselawb.domain.pagination.Pagination;
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
    public List<LawyerAndMemberDTO> findAllLawyerAndMember(Pagination pagination) {return  lawyerAndMemberMapper.selectAllLawyerAndMember(pagination); }

    // 모든 회원 조회 개수
    public int findAllTotalCount() { return lawyerAndMemberMapper.selectAllTotalCount(); }

    // 일반 회원 조회
    public List<MemberVO> findAllMember(Pagination pagination) {return lawyerAndMemberMapper.selectAllMember(pagination); }

    // 일반 회원 조회 개수
    public int findAllMemberTotalCount() {return lawyerAndMemberMapper.selectAllMemberTotalCount(); }

    // 변호사 회원 조회
    public List<LawyerVO> findAllLawyer(Pagination pagination) {return lawyerAndMemberMapper.selectAllLawyer(pagination); }

    // 변호사 회원 조회 개수
    public int findAllLawyerTotalCount() { return  lawyerAndMemberMapper.selectAllLawyerTotalCount(); }


    // 멤버 삭제
    public void modifyMember(Long memberId) {lawyerAndMemberMapper.updateMember(memberId); }

    // 변호사 삭제
    public void modifyLawyer(Long lawyerId) {lawyerAndMemberMapper.updateLawyer(lawyerId);}

    // 멤버 복구
    public void modifyUnsuspendMember(Long memberId) {lawyerAndMemberMapper.updateUnsuspendMember(memberId); }

    // 변호사 복구
    public void modifyUnsuspendLawyer(Long lawyerId) {lawyerAndMemberMapper.updateUnsuspendLawyer(lawyerId);}
}
