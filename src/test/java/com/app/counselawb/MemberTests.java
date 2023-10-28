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


    // 일반회원 가입 테스트
    @Test
    public void insertMemberMapperTest() {
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail("no1zeus@gmail.com");
        memberVO.setMemberPassword("1111");
        memberVO.setMemberName("제우스");
        memberVO.setMemberPhone("01011111111");

        if(memberMapper.selectMemberByEmail(memberVO).isPresent()) {
            log.info("이미 가입한 회원입니다.");
        } else  {
            memberMapper.insertMember(memberVO);
            log.info("회원가입이 완료되었습니다.");
        }
    }

    @Test
    public void saveMemberDAOTest() {
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail("hades4@gmail.com");
        memberVO.setMemberPassword("1234");
        memberVO.setMemberName("하데스");
        memberVO.setMemberPhone("01043214321");

        if(memberDAO.findMemberByEmail(memberVO).isPresent()) {
            log.info("이미 가입한 회원입니다.");
        } else  {
            memberDAO.saveMember(memberVO);
            log.info("회원가입이 완료되었습니다.");
        }
    }


    @Test
    public void joinMemberServiceTest() {
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail("hades4@gmail.com");
        memberVO.setMemberPassword("1234");
        memberVO.setMemberName("하데스");
        memberVO.setMemberPhone("01043214321");

        if(memberService.duplicationMemberCheckByEmail(memberVO).isPresent()) {
            log.info("이미 가입한 회원입니다.");
        } else  {
            memberService.joinMember(memberVO);
            log.info("회원가입이 완료되었습니다.");
        }
    }

    // 변호사회원 가입 테스트
    @Test
    public void insertLawyerMapperTest() {
        LawyerVO lawyerVO = new LawyerVO();
        lawyerVO.setLawyerEmail("poseidon@gmail.com");
        lawyerVO.setLawyerPassword("1234");
        lawyerVO.setLawyerName("세이돈");
        lawyerVO.setLawyerPhone("01012341234");
        lawyerVO.setLawyerCompany("법무법인 올림푸스");

        if(memberMapper.selectLawyerByEmail(lawyerVO).isPresent()) {
            log.info("이미 가입한 변호사 회원입니다.");
        } else  {
            memberMapper.insertLawyer(lawyerVO);
            log.info("변호사 회원가입이 완료되었습니다.");
        }
    }



}
