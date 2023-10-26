package com.app.counselawb.domain;

import com.app.counselawb.domain.pagination.Pagination;
import lombok.Data;

@Data
public class Search {
    private String order;
    private String keyword;
}
