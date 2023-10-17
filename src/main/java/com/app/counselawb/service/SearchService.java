package com.app.counselawb.service;

import com.app.counselawb.domain.Search;
import com.app.counselawb.domain.dto.PostsDTO;
import com.app.counselawb.domain.dto.SearchDTO;
import com.app.counselawb.domain.pagination.Pagination;

import java.util.List;

public interface SearchService {
    // 검색 모아둠
    public SearchDTO getResult(Pagination pagination, Search search);

}
