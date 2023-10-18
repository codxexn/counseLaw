package com.app.counselawb.repository;

import com.app.counselawb.domain.vo.NoticeVO;
import com.app.counselawb.mapper.NoticeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class NoticeDAO {
    private final NoticeMapper noticeMapper;

    // 관리자 페이지에서 공지사항 등록
    public void writeNotice(NoticeVO noticeVO) {noticeMapper.insertNotice(noticeVO);}

    // 공지사항 최신순 조회
    public List<NoticeVO> findLatestNotice() { return noticeMapper.selectLatestNotice(); }

    // 공지사항 오래된순 조회
    public List<NoticeVO> findOldNotice() { return  noticeMapper.selectOldNotice(); }

    // 공지사항 삭제
    public void deleteNotice(Long noticeId) { noticeMapper.deleteNotice(noticeId);}

}
