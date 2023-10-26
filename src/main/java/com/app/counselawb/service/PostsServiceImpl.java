package com.app.counselawb.service;

import com.app.counselawb.domain.Search;
import com.app.counselawb.domain.dto.PostsDTO;
import com.app.counselawb.domain.pagination.Pagination;
import com.app.counselawb.mapper.PostsMapper;
import com.app.counselawb.repository.PostsDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class PostsServiceImpl implements PostsService {
    private final PostsDAO postsDAO;

    @Override
    public List<PostsDTO> findByAllPosts(Pagination pagination) { return  postsDAO.findByAllPosts(pagination); }

    @Override
    public int findTotalAllPosts() {return  postsDAO.findTotalAllPosts(); }

    @Override
    public List<PostsDTO> findByConsultingCasePosts(Pagination pagination) {
        return postsDAO.findByConsultingCasePosts(pagination);
    }

    @Override
    public int findTotalConsultingPosts() {
        return postsDAO.findTotalConsultingPosts();
    }

    @Override
    public List<PostsDTO> findBySolutionCasePosts(Pagination pagination) {
        return postsDAO.findBySolutionCasePosts(pagination);
    }

    // 해결 사례 전체 개수
    public int findTotalSolutionCasePosts() { return  postsDAO.findTotalSolutionCasePosts(); }

    @Override
    public List<PostsDTO> findByLegalGuidePosts(Pagination pagination) {
        return postsDAO.findByLegalGuidePosts(pagination);
    }

    @Override
    // 법률 가이드 전체 개수
    public int findTotalLegalGuidePosts() { return  postsDAO.findTotalLegalGuidePosts(); }

    @Override
    // 해결 사례 게시글 삭제
    public void removeSolutionCasePost(Long solutionCaseId) {postsDAO.deleteSolutionCasePost(solutionCaseId);}

    @Override
    // 상담 사례 게시글 삭제
    public void removeConsultingCasePost(Long consultingCaseId) {postsDAO.deleteConsultingCasePost(consultingCaseId);}

    @Override
    // 법률 가이드 삭제
    public void removeLegalGuidePost(Long legalGuideId) {postsDAO.deleteLegalGuidePost(legalGuideId);}

    @Override
    // 상담 사례 답변 삭제
    public void removeConsultingCaseReply(Long consultingCaseId) {postsDAO.deleteConsultingCaseReply(consultingCaseId);}

    // 해결 사례 이미지들 삭제
    @Override
    public void removeSolutionCaseImages(Long solutionCaseId) {postsDAO.deleteSolutionCaseImages(solutionCaseId);}
}
