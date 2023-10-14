package com.app.counselawb;

import com.app.counselawb.domain.dto.PostsDTO;
import com.app.counselawb.mapper.PostsMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class PostsSelectTests {
    @Autowired
    private PostsMapper postsMapper;

    @Test
    public void legalGuideSelectTest() {
        List<PostsDTO> postsList = postsMapper.selectByLegalGuidePosts();

        postsList.forEach(post -> {
            log.info("Legal Guide ID: {}", post.getLegalGuideId());
            log.info("Legal Guide Title: {}", post.getLegalGuideTitle());
            log.info("Legal Guide Content: {}", post.getLegalGuideContent());
            log.info("Create Date: {}", post.getCreateDate());
            log.info("Lawyer Name: {}", post.getLawyerName());
        });
    }
}
