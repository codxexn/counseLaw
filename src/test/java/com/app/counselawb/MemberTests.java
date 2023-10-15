package com.app.counselawb;

import com.app.counselawb.domain.vo.LawyerVO;
import com.app.counselawb.domain.vo.MemberVO;
import com.app.counselawb.mapper.MemberMapper;
import com.app.counselawb.repository.MemberDAO;
import com.app.counselawb.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class MemberTests {

    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private MemberDAO memberDAO;
    @Autowired
    private MemberService memberService;

    // 일반 회원 로그인 테스트
    @Test
    public void selectByLoginMapperTest() {
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail("admin@counselaw.com");
        memberVO.setMemberPassword("rhksflwk");
        memberMapper.selectByLogin(memberVO).map(MemberVO::toString).ifPresent(log::info);
    }

    @Test
    public void findByLoginDAOTest() {
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail("admin@counselaw.com");
        memberVO.setMemberPassword("rhksflwk");
        memberDAO.findByLogin(memberVO).map(MemberVO::toString).ifPresent(log::info);
    }

    @Test
    public void memberLoginServiceTest() {
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail("admin@counselaw.com");
        memberVO.setMemberPassword("rhksflwk");
        memberService.memberLogin(memberVO).map(MemberVO::toString).ifPresent(log::info);
    }

    // 변호사 회원 로그인 테스트
    @Test
    public void selectLawyerByLoginMapperTest() {
        LawyerVO lawyerVO = new LawyerVO();
        lawyerVO.setLawyerEmail("lawyerTest@gmail.com");
        lawyerVO.setLawyerPassword("1234");
        memberMapper.selectLawyerByLogin(lawyerVO).map(LawyerVO::toString).ifPresent(log::info);
    }

}
