package com.app.counselawb.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
@Data
public class PostsDTO {
    private Long legalGuideId;
    private Long solutionCaseId;
    private Long consultingCaseId;
    private Long memberId;
    private Long lawyerId;
    private String memberName;
    private String lawyerName;
    private String legalGuideTitle;
    private String legalGuideContent;
    private String solutionCaseTitle;
    private String solutionCaseContent;
    private String caseTitle;
    private String caseContent;
    private LocalDateTime createDate;
    private String postType;
    private Long postId;
    private String postTitle;
    private String postContent;
    private LocalDateTime postCreateDate;
    private String postAuthorName;
}
