package com.app.counselawb.domain.dto;


import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class AveragePriceDTO {
    // 전화 상담 가격 평균
    private double phonePriceAverage;
    // 영상 상담 가격 평균
    private double videoPriceAverage;
    // 방문 상담 가격 평균
    private double visitPriceAverage;
}
