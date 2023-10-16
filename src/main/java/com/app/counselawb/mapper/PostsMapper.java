package com.app.counselawb.mapper;

import com.app.counselawb.domain.dto.PostsDTO;
import com.app.counselawb.domain.pagination.Pagination;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostsMapper {
    // 전체 조회
    public List<PostsDTO> selectByAllPosts();

    // 상담 사례 조회
    public List<PostsDTO> selectByConsultingCasePosts(Pagination pagination);

    // 상담 사례 전체 개수
    public int selectTotalConsultingPosts();

    // 해결 사례 조회
    public List<PostsDTO> selectBySolutionCasePosts();

    public int selectTotalSolutionCasePosts();

    // legalGuide Post 조회
    public List<PostsDTO> selectByLegalGuidePosts();
}
