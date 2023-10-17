    package com.app.counselawb.controller;

    import com.app.counselawb.domain.Search;
    import com.app.counselawb.domain.dto.ConsultingCaseReplyDTO;
    import com.app.counselawb.domain.dto.PostsDTO;
    import com.app.counselawb.domain.dto.SearchDTO;
    import com.app.counselawb.domain.pagination.Pagination;
    import com.app.counselawb.domain.vo.SolutionCaseImgVO;
    import com.app.counselawb.service.ConsultingCaseReplyService;
    import com.app.counselawb.service.PostsService;
    import com.app.counselawb.service.SearchService;
    import com.app.counselawb.service.SolutionCaseImgService;
    import lombok.RequiredArgsConstructor;
    import lombok.extern.slf4j.Slf4j;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RequestParam;
    import org.springframework.web.servlet.view.RedirectView;

    import java.util.List;

    @Controller
    @Slf4j
    @RequiredArgsConstructor
    @RequestMapping("/manager/*")
    public class ManageController {
        private final PostsService postsService;
        private final SearchService searchService;
        private final ConsultingCaseReplyService consultingCaseReplyService;
        private final SolutionCaseImgService solutionCaseImgService;



        @GetMapping("manager-mainpage")
    //    public void goTomanagePage() {;}
        public String goToManageMain(@RequestParam(name="selectedOption", defaultValue = "selectAll") String selectedOption, @RequestParam(name = "keyword", required = false) String keyword,
            Model model, Pagination pagination) {
            model.addAttribute("selectedOption", selectedOption);

            if (keyword != null && !keyword.isEmpty()) {
                Search search = new Search();
                search.setKeyword(keyword);
                SearchDTO searchResults = searchService.getResult(pagination, search);
                model.addAttribute("searchResults", searchResults);
                log.info("Keyword received: " + keyword);
            }else {
                if("selectAll".equals(selectedOption)) {
                    pagination.setTotal(postsService.findTotalAllPosts());
                    pagination.progress();
                    model.addAttribute("pagination", pagination);
                    List<PostsDTO> selectAllPosts = postsService.findByAllPosts(pagination);
                    model.addAttribute("selectAllPosts", selectAllPosts);
                } else if("solutionCase".equals(selectedOption)) {
                    pagination.setTotal(postsService.findTotalSolutionCasePosts());
                    pagination.progress();
                    model.addAttribute("pagination", pagination);
                    // 해결 사례 조회
                    List<PostsDTO> solutionCases = postsService.findBySolutionCasePosts(pagination);
                    model.addAttribute("solutionCases", solutionCases);
                } else if("consultingCase".equals(selectedOption)) {
                    pagination.setTotal(postsService.findTotalConsultingPosts());
                    pagination.progress();
                    model.addAttribute("pagination", pagination);
                    // 상담 사례 조회
                    List<PostsDTO> consultingCases = postsService.findByConsultingCasePosts(pagination);
                    model.addAttribute("consultingCases",consultingCases);
                } else if("legalGuide".equals(selectedOption)) {
                    pagination.setTotal(postsService.findTotalLegalGuidePosts());
                    pagination.progress();
                    model.addAttribute("pagination", pagination);
                    // 법률 가이드 정보 조회
                    List<PostsDTO> legalGuides = postsService.findByLegalGuidePosts(pagination);
                    model.addAttribute("legalGuides", legalGuides);
                }
            }



            return "manager/manager-mainpage";
        }



        @PostMapping("posts-delete")
        public RedirectView deletePostAndGoToMainpage(@RequestParam(name = "legalGuideId", required = false) Long legalGuideId,
                                                      @RequestParam(name = "solutionCaseId", required = false) Long solutionCaseId,
                                                      @RequestParam(name = "consultingCaseId", required = false) Long consultingCaseId) {
            List<SolutionCaseImgVO> foundImages = solutionCaseImgService.findSolutionCaseImages(solutionCaseId);
            if (!foundImages.isEmpty()) {
                postsService.removeSolutionCaseImages(solutionCaseId);
            }

            List<ConsultingCaseReplyDTO> foundReplies = consultingCaseReplyService.findAllByConsultingCaseId(consultingCaseId);
            if(!foundReplies.isEmpty()) {
                postsService.removeConsultingCaseReply(consultingCaseId);
            }

            if (legalGuideId != null) {
                // 법률 가이드 게시물 삭제
                postsService.removeLegalGuidePost(legalGuideId);
            } else if (solutionCaseId != null) {
                // 해결 사례 게시물 삭제
                postsService.removeSolutionCasePost(solutionCaseId);
            } else if (consultingCaseId != null) {
                // 상담 사례 게시물 삭제
                postsService.removeConsultingCasePost(consultingCaseId);
            }

            return new RedirectView("/manager/manager-mainpage");
        }

    }
