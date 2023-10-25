package com.app.counselawb.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class SearchDTO {
    private List<PostsDTO> searchConsultingCases;
    private int searchConsultingTotalCount;
}
