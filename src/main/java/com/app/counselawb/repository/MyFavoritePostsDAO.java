package com.app.counselawb.repository;

import com.app.counselawb.domain.dto.LegalGuideDTO;
import com.app.counselawb.domain.dto.MyFavoriteConsultDTO;
import com.app.counselawb.mapper.MyFavoritePostsMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class MyFavoritePostsDAO {
    private final MyFavoritePostsMapper myFavoritePostsMapper;

//    나의 관심페이지에 호출할 내용 불러오기
    public List<MyFavoriteConsultDTO> readMyPosts(Long memberId){
        return myFavoritePostsMapper.readMyFavoritePosts(memberId);
    }

    public List<LegalGuideDTO> findAllLegalGuideWithDetail(){
        return myFavoritePostsMapper.selectAllLegalGuideWithDetail();
    }


}
