package com.app.counselawb.service;

import com.app.counselawb.domain.Search;
import com.app.counselawb.domain.dto.PostsDTO;
import com.app.counselawb.domain.dto.SearchDTO;
import com.app.counselawb.domain.pagination.Pagination;
import com.app.counselawb.repository.SearchDAO;

import java.util.List;

public interface SearchService {

   public SearchDTO getResult(Search search);
}