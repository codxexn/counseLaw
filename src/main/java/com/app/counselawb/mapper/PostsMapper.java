package com.app.counselawb.mapper;

import com.app.counselawb.domain.dto.PostsDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostsMapper {
    // 전체 조회
    public List<PostsDTO> selectByAllPosts();

    // 상담 사례 조회
    public List<PostsDTO> selectByConsultingCasePosts();

    // 해결 사례 조회
    public List<PostsDTO> selectBySolutionCasePosts();

    // legalGuide Post 조회
    public List<PostsDTO> selectByLegalGuidePosts();
}
