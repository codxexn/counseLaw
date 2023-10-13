package com.app.counselawb.domain.vo;


import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class NoticeVO {
    // 공지사항 id
    private Long noticeId;
    // 공지사항 제목
    private String noticeTitle;
    // 공지사항 내용
    private String noticeContent;
    // 기본 세팅
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
