package com.app.counselawb.service;

import com.app.counselawb.domain.vo.NoticeVO;

import java.util.List;

public interface NoticeService {
    public void saveNotice(NoticeVO noticeVO);

    // 공지사항 최신순 조회
    public List<NoticeVO> findLatestNotice();

    // 공지사항 오래된순 조회
    public List<NoticeVO> findOldNotice();

    // 공지사항 삭제
    public void deleteNotice(Long noticeId);
}
