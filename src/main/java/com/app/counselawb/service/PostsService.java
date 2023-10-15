package com.app.counselawb.service;


import com.app.counselawb.domain.dto.PostsDTO;
import com.app.counselawb.domain.pagination.Pagination;

import java.util.List;

public interface PostsService {
    // 모든 포스트 조회
    public List<PostsDTO> findByAllPosts();

    // 상담 사례
    public List<PostsDTO> findByConsultingCasePosts(Pagination pagination);

    // 상담 사례 개수
    public int findTotalConsultingPosts();

    // 해결 사례 조회
    public List<PostsDTO> findBySolutionCasePosts();

    // 법률 가이드 조회
    public List<PostsDTO> findByLegalGuidePosts();

}
