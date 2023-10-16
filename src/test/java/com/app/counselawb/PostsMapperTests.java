package com.app.counselawb;

import com.app.counselawb.domain.dto.PostsDTO;
import com.app.counselawb.domain.pagination.Pagination;
import com.app.counselawb.mapper.PostsMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PostsMapperTests {
    @Autowired
    private PostsMapper postsMapper;

    @Test
    public void selectByLegalGuidePostsTest(Pagination pagination) {
        List<PostsDTO> legalGuides = postsMapper.selectByLegalGuidePosts(pagination);

        for (PostsDTO legalGuide : legalGuides) {
            System.out.println("Legal Guide ID: " + legalGuide.getLegalGuideId());
            System.out.println("Legal Guide Title: " + legalGuide.getLegalGuideTitle());
            System.out.println("Legal Guide Content: " + legalGuide.getLegalGuideContent());
            System.out.println("Create Date: " + legalGuide.getCreateDate());
            System.out.println("Lawyer Name: " + legalGuide.getLawyerName());
            System.out.println("--------------");
        }
    }
}
