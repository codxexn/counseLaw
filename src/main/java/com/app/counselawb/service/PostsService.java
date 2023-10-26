package com.app.counselawb.service;


import com.app.counselawb.domain.Search;
import com.app.counselawb.domain.dto.PostsDTO;
import com.app.counselawb.domain.pagination.Pagination;

import java.util.List;

public interface PostsService {
    // 모든 포스트 조회
    public List<PostsDTO> findByAllPosts(Pagination pagination);

    // 모든 포스트 개수
    public int findTotalAllPosts();

    // 상담 사례
    public List<PostsDTO> findByConsultingCasePosts(Pagination pagination);

    // 상담 사례 개수
    public int findTotalConsultingPosts();


    // 해결 사례 조회
    public List<PostsDTO> findBySolutionCasePosts(Pagination pagination);

    // 해결 사례 전체 개수
    public int findTotalSolutionCasePosts();

    // 법률 가이드 조회
    public List<PostsDTO> findByLegalGuidePosts(Pagination pagination);

    // 법률 가이드 전체 개수
    public int findTotalLegalGuidePosts();

    // 해결 사례 게시글 삭제
    public void removeSolutionCasePost(Long solutionCaseId);
    // 상담 사례 게시글 삭제
    public void removeConsultingCasePost(Long consultingCaseId);
    // 법률 가이드 삭제
    public void removeLegalGuidePost(Long legalGuideId);

    // 상담 사례 답변 삭제
    public void removeConsultingCaseReply(Long consultingCaseId);

    // 해결 사례 이미지들 삭제
    public void removeSolutionCaseImages(Long solutionCaseId);

}
