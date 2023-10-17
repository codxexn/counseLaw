package com.app.counselawb.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class SearchDTO {
    // 모든 포스트 검색 결과
    private List<PostsDTO> allPosts;
    // 모든 포스트 검색 결과의 총 개수
    private int totalAllPosts;

    // 상담 사례 검색 결과
    private List<PostsDTO> consultingCases;
    // 상담 사례 검색 결과의 총 개수
    private int totalConsultingCases;

    // 해결 사례 검색 결과
    private List<PostsDTO> solutionCases;
    // 해결 사례 검색 결과의 총 개수
    private int totalSolutionCases;

    // 법률 가이드 검색 결과
    private List<PostsDTO> legalGuides;
    // 법률 가이드 검색 결과의 총 개수
    private int totalLegalGuides;
}
