package com.app.counselawb.mapper;

import com.app.counselawb.domain.vo.NoticeVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper

public interface NoticeMapper {
    // 관리자 페이지에서 공지사항 등록
    public void insertNotice(NoticeVO noticeVO);

    // 공지사항 1개 조회
    public Optional<NoticeVO> selectByNoticeId(Long noticeId);

    // 공지사항 최신순 조회
    public List<NoticeVO> selectLatestNotice();

    // 공지사항 오래된순 조회
    public List<NoticeVO> selectOldNotice();

    // 공지사항 수정
    public void updateNotice(NoticeVO noticeVO);

    // 공지사항 삭제
    public void deleteNotice(Long noticeId);
}
