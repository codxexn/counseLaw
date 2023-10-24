package com.app.counselawb.service;

import com.app.counselawb.domain.pagination.Pagination;
import com.app.counselawb.domain.vo.NoticeVO;

import java.util.List;
import java.util.Optional;

public interface NoticeService {
    public void saveNotice(NoticeVO noticeVO);

    // 공지사항 상세 조회
    public Optional<NoticeVO> findByNoticeId(Long noticeId);

    // 공지사항 최신순 조회
    public List<NoticeVO> findLatestNotice(Pagination pagination);

    // 공지사항 오래된순 조회
    public List<NoticeVO> findOldNotice(Pagination pagination);

    // 공지사항 총 개수
    public int findTotalNotice();

    // 공지사항 수정
    public void reviseNotice(NoticeVO noticeVO);

    // 공지사항 삭제
    public void deleteNotice(Long noticeId);
}
