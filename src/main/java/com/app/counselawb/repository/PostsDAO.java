package com.app.counselawb.repository;

import com.app.counselawb.domain.dto.PostsDTO;
import com.app.counselawb.domain.pagination.Pagination;
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

    // 모든 포스트 조회
    public List<PostsDTO> findByAllPosts() { return postsMapper.selectByAllPosts(); }

    // 상담 사례 조회
    public List<PostsDTO> findByConsultingCasePosts(Pagination pagination) { return postsMapper.selectByConsultingCasePosts(pagination); }

    // 상담 사례 개수
    public int findTotalConsultingPosts() { return  postsMapper.selectTotalConsultingPosts(); }

    // 해결 사례 조회
    public List<PostsDTO> findBySolutionCasePosts() { return postsMapper.selectBySolutionCasePosts(); }

    // 법률 가이드 조회
    public List<PostsDTO> findByLegalGuidePosts() {
        return postsMapper.selectByLegalGuidePosts();
    }
}
