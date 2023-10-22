package com.app.counselawb.service;

import com.app.counselawb.domain.dto.LawyerAndMemberDTO;
import com.app.counselawb.domain.pagination.Pagination;
import com.app.counselawb.domain.vo.LawyerVO;
import com.app.counselawb.domain.vo.MemberVO;
import com.app.counselawb.repository.LawyerAndMemberDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LawyerAndMemberServiceImpl implements LawyerAndMemberService {
    private final LawyerAndMemberDAO lawyerAndMemberDAO;

    @Override
    public List<LawyerAndMemberDTO> findAllLawyerAndMember(Pagination pagination) {
        return lawyerAndMemberDAO.findAllLawyerAndMember(pagination);
    }

    @Override
    public List<MemberVO> findAllMember(Pagination pagination) {
        return lawyerAndMemberDAO.findAllMember(pagination);
    }

    @Override
    public List<LawyerVO> findAllLawyer(Pagination pagination) {
        return lawyerAndMemberDAO.findAllLawyer(pagination);
    }

    @Override
    public int findAllTotalCount() {
        return lawyerAndMemberDAO.findAllTotalCount();
    }

    @Override
    public int findAllMemberTotalCount() {
        return lawyerAndMemberDAO.findAllMemberTotalCount();
    }

    @Override
    public int findAllLawyerTotalCount() {
        return lawyerAndMemberDAO.findAllLawyerTotalCount();
    }

    @Override
    public void modifyMember(Long memberId) {
        lawyerAndMemberDAO.modifyMember(memberId);
    }

    @Override
    public void modifyLawyer(Long lawyerId) {
        lawyerAndMemberDAO.modifyLawyer(lawyerId);
    }

    @Override
    public void modifyUnsuspendMember(Long memberId) {
        lawyerAndMemberDAO.modifyUnsuspendMember(memberId);
    }

    @Override
    public void modifyUnsuspendLawyer(Long lawyerId) {
        lawyerAndMemberDAO.modifyUnsuspendLawyer(lawyerId);
    }
}
