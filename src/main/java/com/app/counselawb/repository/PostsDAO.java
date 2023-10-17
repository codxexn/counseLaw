package com.app.counselawb.repository;

import com.app.counselawb.domain.Search;
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
    public List<PostsDTO> findByAllPosts(Pagination pagination) { return postsMapper.selectByAllPosts(pagination); }

    // 모든 포스트 개수
    public int findTotalAllPosts() { return postsMapper.selectTotalAllPosts(); }

    // 상담 사례 조회
    public List<PostsDTO> findByConsultingCasePosts(Pagination pagination) { return postsMapper.selectByConsultingCasePosts(pagination); }

    // 상담 사례 개수
    public int findTotalConsultingPosts() { return  postsMapper.selectTotalConsultingPosts(); }

    // 해결 사례 조회
    public List<PostsDTO> findBySolutionCasePosts(Pagination pagination) { return postsMapper.selectBySolutionCasePosts(pagination); }

    // 해결 사례 전체 개수
    public int findTotalSolutionCasePosts() { return  postsMapper.selectTotalSolutionCasePosts(); }

    // 법률 가이드 조회
    public List<PostsDTO> findByLegalGuidePosts(Pagination pagination) {
        return postsMapper.selectByLegalGuidePosts(pagination);
    }

    // 법률 가이드 전체 개수
    public int findTotalLegalGuidePosts() { return  postsMapper.selectTotalLegalGuidePosts(); }

}
