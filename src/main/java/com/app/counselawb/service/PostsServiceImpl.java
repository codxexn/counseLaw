package com.app.counselawb.service;

import com.app.counselawb.domain.dto.PostsDTO;
import com.app.counselawb.mapper.PostsMapper;
import com.app.counselawb.repository.PostsDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class PostsServiceImpl implements PostsService {
    private final PostsDAO postsDAO;
    @Override
    public List<PostsDTO> findByLegalGuidePosts() {
        return postsDAO.findByLegalGuidePosts();
    }
}
