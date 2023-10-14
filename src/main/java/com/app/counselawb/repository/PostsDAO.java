package com.app.counselawb.repository;

import com.app.counselawb.domain.dto.PostsDTO;
import com.app.counselawb.mapper.PostsMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
@RequiredArgsConstructor
public class PostsDAO {
    private final PostsMapper postsMapper;

    // 법률 가이드 조회
    public List<PostsDTO> findByLegalGuidePosts() {
        return postsMapper.selectByLegalGuidePosts();
    }
}
