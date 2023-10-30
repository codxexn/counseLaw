package com.app.counselawb.service;

import com.app.counselawb.domain.dto.LegalGuideDTO;
import com.app.counselawb.domain.dto.MyFavoriteConsultDTO;
import com.app.counselawb.repository.MyFavoritePostsDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MyFavoritePostsServiceImpl implements MyFavoritePostsService {

    private final MyFavoritePostsDAO myFavoritePostsDAO;

    @Override
    public List<MyFavoriteConsultDTO> readMyFavoritePosts(Long memberId) {
        return myFavoritePostsDAO.readMyPosts(memberId);
    }

    @Override
    public List<LegalGuideDTO> findAllLegalGuideWithDetail() {
        return myFavoritePostsDAO.findAllLegalGuideWithDetail();
    }
}
