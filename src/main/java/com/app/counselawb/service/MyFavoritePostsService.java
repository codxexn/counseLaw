package com.app.counselawb.service;

import com.app.counselawb.domain.dto.LegalGuideDTO;
import com.app.counselawb.domain.dto.MyFavoriteConsultDTO;

import java.util.List;

public interface MyFavoritePostsService {

//    나의 관심글에 쓸 내용 불러오기
    public List<MyFavoriteConsultDTO> readMyFavoritePosts(Long memberId);

    public List<LegalGuideDTO> findAllLegalGuideWithDetail();

}
