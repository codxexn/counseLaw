package com.app.counselawb.mapper;

import com.app.counselawb.domain.dto.LawyerAndMemberDTO;
import com.app.counselawb.domain.pagination.Pagination;
import com.app.counselawb.domain.vo.LawyerVO;
import com.app.counselawb.domain.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LawyerAndMemberMapper {
    // 모든 회원 조회
    public List<LawyerAndMemberDTO> selectAllLawyerAndMember(Pagination pagination);

    // 모든 회원 조회 개수
    public int selectAllTotalCount();

    // 일반 회원 조회
    public List<MemberVO> selectAllMember(Pagination pagination);

    // 일반 회원 조회 개수
    public int selectAllMemberTotalCount();

    // 뱐호사 회원 조회
    public List<LawyerVO> selectAllLawyer(Pagination pagination);

    // 변호사 회원 조회 개수
    public int selectAllLawyerTotalCount();

    // 멤버 삭제
    public void updateMember(Long memberId);

    // 변호사 삭제
    public void updateLawyer(Long lawyerId);

    // 멤버 복구
    public void updateUnsuspendMember(Long memberId);

    // 변호사 복구
    public void updateUnsuspendLawyer(Long lawyerId);
}
