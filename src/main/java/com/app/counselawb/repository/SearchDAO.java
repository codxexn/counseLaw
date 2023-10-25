package com.app.counselawb.repository;

import com.app.counselawb.domain.Search;
import com.app.counselawb.domain.dto.PostsDTO;
import com.app.counselawb.domain.pagination.Pagination;
import com.app.counselawb.mapper.PostsMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class SearchDAO {
    private final PostsMapper postsMapper;

    // 상담 사례 검색
    public List<PostsDTO> findSearchConsultingCases(Search search) {return postsMapper.searchConsultingCases(search);}

    // 상담 사례 검색 개수
    public int findSearchTotalConsultingCases(Search search) {return postsMapper.searchTotalConsultingCases(search);}
}
