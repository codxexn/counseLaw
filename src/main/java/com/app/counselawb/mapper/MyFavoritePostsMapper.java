package com.app.counselawb.mapper;

import com.app.counselawb.domain.dto.LegalGuideDTO;
import com.app.counselawb.domain.dto.MyFavoriteConsultDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MyFavoritePostsMapper {
    public List<MyFavoriteConsultDTO> readMyFavoritePosts(Long memberId);

    public List<LegalGuideDTO> selectAllLegalGuideWithDetail();
}
