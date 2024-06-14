package com.app.counselawb.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Component
@Data
public class ReservationDTO {

    //예약 id
    private long reservationId;
    // 변호사 id
    private long lawyerId;
    // 변호사명
    private String lawyerName;
    // 변호사 사진
    private String lawyerImage;
    // 예약 시간
    private Date reservationTime;
    // 예약 날짜
    private Date reservationDate;
    // 상담 유형
    private String consultingType;
    // 예약한 일시
    private Date createDate;
    // 취소된 일시
    private Date updateDate;
    // 후기 여부
    private int reviewOrNot;
    // 예약 현황
    private String reservationStatus;
    // 변호사 탈퇴 여부
    private String lawyerState;

}
