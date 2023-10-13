package com.app.counselawb.domain.vo;


import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class PaymentVO {
    // 결제 id
    private Long paymentId;
    // 결제 가격
    private int paymentPrice;
    // 결제 내역(내용)
    private String paymentList;
    // 기본 세팅
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    //////////////
    // 예약 id (fk)
    private Long reservationId;

}
