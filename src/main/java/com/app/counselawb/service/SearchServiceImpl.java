package com.app.counselawb.service;

import com.app.counselawb.domain.Search;
import com.app.counselawb.domain.dto.SearchDTO;
import com.app.counselawb.domain.pagination.Pagination;
import com.app.counselawb.repository.SearchDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class SearchServiceImpl implements SearchService {
    private final SearchDAO searchConsultingCases;

    @Override
    public SearchDTO getResult(Search search) {
        SearchDTO searchDTO = new SearchDTO();
        searchDTO.setSearchConsultingCases(searchConsultingCases.findSearchConsultingCases(search));
        searchDTO.setSearchConsultingTotalCount(searchConsultingCases.findSearchTotalConsultingCases(search));
        return searchDTO;
    }
}
