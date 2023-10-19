package com.app.counselawb.domain.dto;


import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class AveragePriceDTO {
    // 전화 상담 가격 평균
    private double callPriceAverage;
    // 영상 상담 가격 평균
    private double videoPriceAverage;
    // 방문 상담 가격 평균
    private double visitPriceAverage;
    // 전화 상담 가격 개수
    private int callPriceCount;
    // 영상 상담 가격 개수
    private int videoPriceCount;
    // 방문 상담 가격 개수
    private int visitPriceCount;
    // 전화 상담 가격 최댓값
    private int callPriceMax;
    // 전화 상담 가격 최솟값
    private int callPriceMin;
    // 영상 상담 가격 최댓값
    private int videoPriceMax;
    // 영상 상담 가격 최솟값
    private int videoPriceMin;
    // 방문 상담 가격 최댓값
    private int visitPriceMax;
    // 방문 상담 가격 최솟값
    private int visitPriceMin;
}
