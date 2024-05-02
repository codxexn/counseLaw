package com.app.counselawb.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Data
public class MyFavoriteConsultDTO {
//    관심글의 Id
    private Long consultingCaseId;
//    관심글 제목git 
    private String consultingCaseTitle;
//    관심글 원본의 작성 날짜
//    private LocalDate createDate;
//    조회수
    private Long viewCount;
//    변호사 답변 개수
    private Long lawyerReplyCount;
//    관심글의 Id번호
    private Long favoritePostsId;
//    회원 Id
    private Long memberId;

}
