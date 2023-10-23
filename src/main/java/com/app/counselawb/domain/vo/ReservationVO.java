package com.app.counselawb.domain.vo;


import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Component
@Data
public class ReservationVO {
    // 상담 예약 id
    private Long reservationId;
    // 예약 시간
    private LocalTime reservationTime;
    // 예약 날짜
    private LocalDate reservationDate;
    // 상담 유형
    private String consultingType;
    // 상담예약 내용
    private String reservationContent;
    // 유저 이름(가명)
    private String memberFakeName;
    // 연락 가능한 유저 번호
    private String memberDesiredPhone;
    // 기본 세팅
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    ///////////////
    // 멤버 id (fk)
    private Long memberId;
    // 변호사 id (fk)
    private Long lawyerId;
}
