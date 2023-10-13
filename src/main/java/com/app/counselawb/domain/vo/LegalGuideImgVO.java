package com.app.counselawb.domain.vo;


import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class LegalGuideImgVO {
    // 법률 가이드 이미지 id
    private Long legalGuideImgId;
    // 원래 파일명
    private String originFileName;
    // (프로젝트에 랜덤으로) 저장된(될) 파일명
    private String storedFileName;
    // 이미지 크기 (byte 기준이므로 Long타입으로 선언합니다.)
    private Long imgSize;
    // 이미지 경로 ("/static/image/{폴더}/")
    private String imgPath;
    // 기본 세팅
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    ////////////////
    // 법률가이드 id (fk)
    private Long legalGuideId;
}
