package com.app.counselawb.service;

import com.app.counselawb.domain.dto.LawyerAndMemberDTO;
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
    public List<LawyerAndMemberDTO> findAllLawyerAndMember() {
        return lawyerAndMemberDAO.findAllLawyerAndMember();
    }

    @Override
    public List<MemberVO> findAllMember() {
        return lawyerAndMemberDAO.findAllMember();
    }

    @Override
    public List<LawyerVO> findAllLawyer() {
        return lawyerAndMemberDAO.findAllLawyer();
    }
}
