package com.app.counselawb.repository;

import com.app.counselawb.domain.Search;
import com.app.counselawb.domain.dto.PostsDTO;
import com.app.counselawb.domain.dto.SearchDTO;
import com.app.counselawb.domain.pagination.Pagination;
import com.app.counselawb.mapper.PostsMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
@RequiredArgsConstructor
public class SearchDAO {
    private final PostsMapper postsMapper;

    // 모든  포스트 검색
    public List<PostsDTO> findByAllPosts(Pagination pagination, Search search) {return postsMapper.searchAllPosts(pagination, search);}

    // 모든 포스트 검색 개수
    public int findAllPostsTotal(Search search) { return  postsMapper.searchTotalAllPosts(search); }

//        상담 사례 검색
    public List<PostsDTO> findConsultingCases(Pagination pagination, Search search) {return postsMapper.searchConsultingCases(pagination, search); }
//    상담 사례 검색 개수
    public int findTotalConsultingCases(Search search) {return postsMapper.searchTotalConsultingCases(search);}

//        해결 사례
    public  List<PostsDTO> findSolutionCases(Pagination pagination, Search search) {return postsMapper.searchSolutionCases(pagination, search); }

//    해결 사례 검색 개수
    public int findTotalSolutionCases(Search search) {return postsMapper.searchTotalSolutionCases(search);}

//        법률 가이드 검색
    public List<PostsDTO> findLegalGuides(Pagination pagination, Search search) {return postsMapper.searchLegalGuides(pagination, search);}
//    법률 가이드 검색 개수
    public int findTotalLegalGuides(Search search) {return postsMapper.searchTotalLegalGuides(search);}
;

}





