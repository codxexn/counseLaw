package com.app.counselawb.mapper;

import com.app.counselawb.domain.dto.PostsDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostsMapper {
    // legalGuide Post 조회
    public List<PostsDTO> selectByLegalGuidePosts();
}
