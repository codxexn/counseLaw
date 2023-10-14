package com.app.counselawb.service;


import com.app.counselawb.domain.dto.PostsDTO;

import java.util.List;

public interface PostsService {

    // 상담 사례
    public List<PostsDTO> findByConsultingCasePosts();

    // 해결 사례 조회
    public List<PostsDTO> findBySolutionCasePosts();

    // 법률 가이드 조회
    public List<PostsDTO> findByLegalGuidePosts();

}
