package com.app.counselawb.mapper;

import com.app.counselawb.domain.Search;
import com.app.counselawb.domain.dto.PostsDTO;
import com.app.counselawb.domain.pagination.Pagination;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostsMapper {
    // 전체 조회
    public List<PostsDTO> selectByAllPosts(Pagination pagination);

    // 전체 조회 개수
    public int selectTotalAllPosts();

    // 상담 사례 조회
    public List<PostsDTO> selectByConsultingCasePosts(Pagination pagination);

    // 상담 사례 전체 개수
    public int selectTotalConsultingPosts();

    // 해결 사례 조회
    public List<PostsDTO> selectBySolutionCasePosts(Pagination pagination);


    // 해결 사례 전체 개수
    public int selectTotalSolutionCasePosts();

    // legalGuide Post 조회
    public List<PostsDTO> selectByLegalGuidePosts(Pagination pagination);

    // 법률 가이드 전체 개수
    public int selectTotalLegalGuidePosts();



    // 상담 사례 검색
    public List<PostsDTO> searchConsultingCases(Search search);

    // 상담 사례 검색 개수
    public int searchTotalConsultingCases(Search search);

    // 해결 사례 검색
    public List<PostsDTO> searchSolutionCases(Search search);

    // 해결 사례 검색 개수
    public int searchTotalSolutionCases(Search search);

    // 법률 가이드 검색
    public List<PostsDTO> searchLegalGuides(Search search);

    // 법률 가이드 검색 개수
    public int searchTotalLegalGuides(Search search);

    // 해결 사례 게시글 삭제
    public void deleteSolutionCasePost(Long solutionCaseId);
    // 상담 사례 게시글 삭제
    public void deleteConsultingCasePost(Long consultingCaseId);

    // 법률 가이드 삭제
    public void deleteLegalGuidePost(Long legalGuideId);

    // 상담 사례 답변 삭제
    public void deleteConsultingCaseReply(Long consultingCaseId);

    // 해결 사례 이미지들 삭제
    public void deleteSolutionCaseImages(Long solutionCaseId);
}
