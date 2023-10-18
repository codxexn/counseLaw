package com.app.counselawb.service;

import com.app.counselawb.domain.vo.NoticeVO;
import com.app.counselawb.repository.NoticeDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService {
    private final NoticeDAO noticeDAO;
    @Override
    public void saveNotice(NoticeVO noticeVO) { noticeDAO.writeNotice(noticeVO); }

    @Override
    public List<NoticeVO> findLatestNotice() {
        return noticeDAO.findLatestNotice();
    }

    @Override
    public List<NoticeVO> findOldNotice() {
        return noticeDAO.findOldNotice();
    }

    @Override
    public void deleteNotice(Long noticeId) {
        noticeDAO.deleteNotice(noticeId);
    }
}
