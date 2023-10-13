package com.app.counselawb.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Data
public class MemberVO {
    // 일반 유저 VO
    // 아이디(pk)
    private Long memberId;
    // 이메일(로그인 용 아이디)
    private String memberEmail;
    // 비밀 번호
    private String memberPassword;
    // 이름
    private String memberName;
    // 상태 (가용, 탈퇴, 제재)
    private String memberState;
    // 전화 번호
    private String memberPhone;
    // 사용자 로그인 코드(가입 유형에 따라 normal, kakao)
    private String memberLoginCode;
    // 생성 날짜
    private LocalDate createDate;
    // 수정 날짜
    private LocalDate updateDate;
}
