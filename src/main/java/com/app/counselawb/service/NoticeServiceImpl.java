package com.app.counselawb.service;

import com.app.counselawb.domain.vo.NoticeVO;
import com.app.counselawb.repository.NoticeDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService {
    private final NoticeDAO noticeDAO;
    @Override
    public void saveNotice(NoticeVO noticeVO) { noticeDAO.writeNotice(noticeVO); }

    @Override
    public Optional<NoticeVO> findByNoticeId(Long noticeId) {
        return noticeDAO.readByNoticeId(noticeId);
    }

    @Override
    public List<NoticeVO> findLatestNotice() {
        return noticeDAO.findLatestNotice();
    }

    @Override
    public List<NoticeVO> findOldNotice() {
        return noticeDAO.findOldNotice();
    }

    @Override
    public void reviseNotice(NoticeVO noticeVO) {
        noticeDAO.modifyNotice(noticeVO);
    }

    @Override
    public void deleteNotice(Long noticeId) {
        noticeDAO.deleteNotice(noticeId);
    }
}
