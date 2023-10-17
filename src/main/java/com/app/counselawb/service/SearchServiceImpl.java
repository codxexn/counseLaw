package com.app.counselawb.service;

import com.app.counselawb.domain.Search;
import com.app.counselawb.domain.dto.SearchDTO;
import com.app.counselawb.domain.pagination.Pagination;
import com.app.counselawb.repository.SearchDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class SearchServiceImpl implements SearchService {

    private final SearchDAO searchAllPosts;
    private final SearchDAO searchConsultingCases;
    private final SearchDAO searchSolutionCases;
    private final SearchDAO searchLegalGuides;

    @Override
    public SearchDTO getResult(Pagination pagination, Search search) {
        SearchDTO searchDTO = new SearchDTO();
        searchDTO.setAllPosts(searchAllPosts.findByAllPosts(pagination, search));
        searchDTO.setTotalAllPosts(searchAllPosts.findAllPostsTotal(search));
        searchDTO.setConsultingCases(searchConsultingCases.findConsultingCases(pagination, search));
        searchDTO.setTotalConsultingCases(searchConsultingCases.findTotalConsultingCases(search));
        searchDTO.setSolutionCases(searchSolutionCases.findSolutionCases(pagination, search));
        searchDTO.setTotalSolutionCases(searchSolutionCases.findTotalSolutionCases(search));
        searchDTO.setLegalGuides(searchLegalGuides.findLegalGuides(pagination, search));
        searchDTO.setTotalLegalGuides(searchLegalGuides.findTotalLegalGuides(search));

        return searchDTO;
    }
}
