package com.app.counselawb.service;

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

    @Override
    public Optional<MemberVO> memberLogin(MemberVO memberVO) {
        return memberDAO.findByLogin(memberVO);
    }
}
