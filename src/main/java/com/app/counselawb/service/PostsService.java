package com.app.counselawb.service;


import com.app.counselawb.domain.dto.PostsDTO;

import java.util.List;

public interface PostsService {
    // 법률 가이드 조회
    public List<PostsDTO> findByLegalGuidePosts();
}
