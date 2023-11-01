    package com.app.counselawb.controller;

    import com.app.counselawb.domain.Search;
    import com.app.counselawb.domain.dto.*;
    import com.app.counselawb.domain.pagination.Pagination;
    import com.app.counselawb.domain.vo.*;
    import com.app.counselawb.service.*;
    import lombok.RequiredArgsConstructor;
    import lombok.extern.slf4j.Slf4j;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.*;
    import org.springframework.web.servlet.view.RedirectView;

    import javax.servlet.http.HttpSession;
    import java.time.LocalDate;
    import java.time.LocalDateTime;
    import java.time.format.DateTimeFormatter;
    import java.util.List;
    import java.util.Optional;

    @Controller
    @Slf4j
    @RequiredArgsConstructor
    @RequestMapping("/manager/*")
    public class ManageController {
        private final PostsService postsService;
        private final SearchService searchService;
        private final ConsultingCaseReplyService consultingCaseReplyService;
        private final SolutionCaseImgService solutionCaseImgService;
        private final NoticeService noticeService;
        private final LawyerAndMemberService lawyerAndMemberService;
        private final CouponAdminService couponAdminService;


        @GetMapping("manager-mainpage")
    //    public void goTomanagePage() {;}
        public String goToManageMain(@RequestParam(value = "memberId", required = false) Long memberId, @RequestParam(name="selectedOption", defaultValue = "selectAll") String selectedOption, @RequestParam(name = "keyword", required = false, defaultValue = "") String keyword,
                                     Model model, Pagination pagination, HttpSession session) {
            model.addAttribute("selectedOption", selectedOption);
            session.setAttribute("memberId", memberId);
            if ((keyword == null || keyword.isEmpty()) && "selectAll".equals(selectedOption)) {
                pagination.setTotal(postsService.findTotalAllPosts());
                pagination.progress();
                model.addAttribute("pagination", pagination);
                List<PostsDTO> selectAllPosts = postsService.findByAllPosts(pagination);
                model.addAttribute("selectAllPosts", selectAllPosts);
            } else {
                if (keyword != null && !keyword.isEmpty()) {
                    Search search = new Search();
                    search.setKeyword(keyword);
                    SearchDTO searchResults = searchService.getResult(search);
                    model.addAttribute("searchResults", searchResults);
                    model.addAttribute("pagination", pagination);

                    log.info("Keyword received: " + keyword);
                } else {
                    if ("solutionCase".equals(selectedOption)) {
                        pagination.setTotal(postsService.findTotalSolutionCasePosts());
                        pagination.progress();
                        model.addAttribute("pagination", pagination);
                        // 해결 사례 조회
                        List<PostsDTO> solutionCases = postsService.findBySolutionCasePosts(pagination);
                        model.addAttribute("solutionCases", solutionCases);
                    } else if ("consultingCase".equals(selectedOption)) {
                        pagination.setTotal(postsService.findTotalConsultingPosts());
                        pagination.progress();
                        model.addAttribute("pagination", pagination);
                        // 상담 사례 조회
                        List<PostsDTO> consultingCases = postsService.findByConsultingCasePosts(pagination);
                        model.addAttribute("consultingCases", consultingCases);
                    } else if ("legalGuide".equals(selectedOption)) {
                        pagination.setTotal(postsService.findTotalLegalGuidePosts());
                        pagination.progress();
                        model.addAttribute("pagination", pagination);
                        // 법률 가이드 정보 조회
                        List<PostsDTO> legalGuides = postsService.findByLegalGuidePosts(pagination);
                        model.addAttribute("legalGuides", legalGuides);
                    }
                }
            }
            model.addAttribute("keyword", keyword);


//                if ("selectAll".equals(selectedOption)) {
//                    pagination.setTotal(postsService.findTotalAllPosts());
//                    pagination.progress();
//                    model.addAttribute("pagination", pagination);
//                    List<PostsDTO> selectAllPosts = postsService.findByAllPosts(pagination);
//                    model.addAttribute("selectAllPosts", selectAllPosts);
//                } else if ("solutionCase".equals(selectedOption)) {
//                    pagination.setTotal(postsService.findTotalSolutionCasePosts());
//                    pagination.progress();
//                    model.addAttribute("pagination", pagination);
//                    // 해결 사례 조회
//                    List<PostsDTO> solutionCases = postsService.findBySolutionCasePosts(pagination);
//                    model.addAttribute("solutionCases", solutionCases);
//                } else if ("consultingCase".equals(selectedOption)) {
//                    pagination.setTotal(postsService.findTotalConsultingPosts());
//                    pagination.progress();
//                    model.addAttribute("pagination", pagination);
//                    // 상담 사례 조회
//                    List<PostsDTO> consultingCases = postsService.findByConsultingCasePosts(pagination);
//                    model.addAttribute("consultingCases", consultingCases);
//                } else if ("legalGuide".equals(selectedOption)) {
//                    pagination.setTotal(postsService.findTotalLegalGuidePosts());
//                    pagination.progress();
//                    model.addAttribute("pagination", pagination);
//                    // 법률 가이드 정보 조회
//                    List<PostsDTO> legalGuides = postsService.findByLegalGuidePosts(pagination);
//                    model.addAttribute("legalGuides", legalGuides);
//                }




            return "manager/manager-mainpage";
        }




        @PostMapping("posts-delete")
        public RedirectView deletePostAndGoToMainpage(@RequestParam(name = "legalGuideId", required = false) Long legalGuideId,
                                                      @RequestParam(name = "solutionCaseId", required = false) Long solutionCaseId,
                                                      @RequestParam(name = "consultingCaseId", required = false) Long consultingCaseId) {



            if (legalGuideId != null) {
                // 법률 가이드 게시물 삭제
                postsService.removeLegalGuidePost(legalGuideId);
            } else if (solutionCaseId != null) {
                List<SolutionCaseImgVO> foundImages = solutionCaseImgService.findSolutionCaseImages(solutionCaseId);
                if (!foundImages.isEmpty()) {
                    postsService.removeSolutionCaseImages(solutionCaseId);
                }
                // 해결 사례 게시물 삭제
                postsService.removeSolutionCasePost(solutionCaseId);
            } else if (consultingCaseId != null) {
                List<ConsultingCaseReplyDTO> foundReplies = consultingCaseReplyService.findAllByConsultingCaseId(consultingCaseId);
                if(!foundReplies.isEmpty()) {
                    postsService.removeConsultingCaseReply(consultingCaseId);
                }
                // 상담 사례 게시물 삭제
                postsService.removeConsultingCasePost(consultingCaseId);
            }

            return new RedirectView("/manager/manager-mainpage");
        }

        @GetMapping("manager-announcement")
        public String goToAnnouncementPage(@RequestParam(name="selectedOption", defaultValue = "latestPost") String selectedOption, NoticeVO noticeVO, Model model, Pagination pagination){
            model.addAttribute("selectedOption", selectedOption);

            if ("latestPost".equals(selectedOption)) {
                pagination.setTotal(noticeService.findTotalNotice());
                pagination.progress();
                model.addAttribute("pagination", pagination);
                List<NoticeVO> latestNotices = noticeService.findLatestNotice(pagination);
                model.addAttribute("latestNotices", latestNotices);
            } else if("oldPost".equals(selectedOption)) {
                pagination.setTotal(noticeService.findTotalNotice());
                pagination.progress();
                model.addAttribute("pagination", pagination);
                List<NoticeVO> oldNotices = noticeService.findOldNotice(pagination);
                model.addAttribute("oldNotices", oldNotices);
            }

            return "manager/manager-announcement";
        }

        // 공지사항 작성
        @GetMapping("manager-post")
        public void announcementPostToWritePost(NoticeVO noticeVO) {;}


        @PostMapping("manager-post")
        public RedirectView uploadAnnouncementPost(NoticeVO noticeVO){
            noticeService.saveNotice(noticeVO);

            return new RedirectView("/manager/manager-announcement");
        }

        // 공지사항 수정
        @PostMapping("detail-notice-update")
        public String detailNoticeUpdate(@RequestParam(name = "noticeId", required = false) Long noticeId, Model model, NoticeVO noticeVO ) {
            Optional<NoticeVO> foundNotice = noticeService.findByNoticeId(noticeId);
            if (foundNotice.isPresent()) {
                model.addAttribute("foundNotice", foundNotice.get());
            } else {
                model.addAttribute("foundNotice", null);
            }

            return "manager/manager-updatePost";

        }

        @PostMapping("manager-updatePost")
        public RedirectView uploadUpdateNoticePost(@RequestParam(name = "noticeId", required = false) Long noticeId, @RequestParam("noticeTitle") String noticeTitle, @RequestParam("noticeContent") String noticeContent) {
            NoticeVO noticeVO = new NoticeVO();
            noticeVO.setNoticeId(noticeId);
            noticeVO.setNoticeTitle(noticeTitle);
            noticeVO.setNoticeContent(noticeContent);

            noticeService.reviseNotice(noticeVO);

            return new RedirectView("/manager/manager-announcement");
        }

        // 공지사항 삭제
        @PostMapping("notices-delete")
        public RedirectView deleteNoticesAndGoToAnnouncement(@RequestParam(name = "noticeId", required = false) Long noticeId) {
            noticeService.deleteNotice(noticeId);

            return new RedirectView("/manager/manager-announcement");

        }

        //회원 관리

        @GetMapping("manager-member")
        public String goToManagerMemberPage(@RequestParam(name = "selectedOption", defaultValue = "selectAll") String selectedOption, Model model, Pagination pagination){
            model.addAttribute("selectedOption", selectedOption);

            if("selectAll".equals(selectedOption)) {
                pagination.setTotal(lawyerAndMemberService.findAllTotalCount());
                pagination.progress();
                model.addAttribute("pagination", pagination);
                List<LawyerAndMemberDTO> selectAllLawyerAndMember = lawyerAndMemberService.findAllLawyerAndMember(pagination);
                model.addAttribute("selectAllLawyerAndMember", selectAllLawyerAndMember);
            } else if("member".equals(selectedOption)) {
                pagination.setTotal(lawyerAndMemberService.findAllMemberTotalCount());
                pagination.progress();
                model.addAttribute("pagination", pagination);
                List<MemberVO> selectAllMembers = lawyerAndMemberService.findAllMember(pagination);
                model.addAttribute("selectAllMembers", selectAllMembers);
            } else if("lawyer".equals(selectedOption)) {
                pagination.setTotal(lawyerAndMemberService.findAllLawyerTotalCount());
                pagination.progress();
                model.addAttribute("pagination", pagination);
                List<LawyerVO> selectAllLawyers = lawyerAndMemberService.findAllLawyer(pagination);
                model.addAttribute("selectAllLawyers", selectAllLawyers);
            }



            return "manager/manager-member";
        }

        @PostMapping("member-suspend")
        public RedirectView suspendMemberAndLawyerGoToMemberpage(@RequestParam(name = "memberId", required = false) Long memberId, @RequestParam(name = "lawyerId", required = false) Long lawyerId) {
            if(memberId != null) {
                lawyerAndMemberService.modifyMember(memberId);
            } else if (lawyerId != null) {
                lawyerAndMemberService.modifyLawyer(lawyerId);
            }

            return new RedirectView("/manager/manager-member");
        }

       @PostMapping("member-unsuspend")
        public RedirectView unsuspendMemberAndLawyerGoToMemberPage(@RequestParam(name = "memberId", required = false) Long memberId, @RequestParam(name = "lawyerId", required = false) Long lawyerId) {
            if(memberId != null) {
                lawyerAndMemberService.modifyUnsuspendMember(memberId);
            } else if (lawyerId != null) {
                lawyerAndMemberService.modifyUnsuspendLawyer(lawyerId);
            }

            return new RedirectView("/manager/manager-member");
       }

       @GetMapping("manager-coupon")
       public String goToManagerCouponPage(Pagination pagination, Model model){
            int couponCount = couponAdminService.findCouponCount();
            model.addAttribute("couponCount", couponCount);
            pagination.setTotal(couponCount);
            pagination.progress();
            model.addAttribute("pagination", pagination);
            List<CouponAdminDTO> coupons = couponAdminService.findAllCoupons(pagination);
            model.addAttribute("coupons", coupons);

            return "manager/manager-coupon";
       }

        @PostMapping("coupon-insert")
        @ResponseBody
        public String insertCoupon(@RequestParam("couponTitle") String couponTitle,
                                   @RequestParam("couponExpireDate") String couponExpireDate,
                                   @RequestParam("couponAvailableType") String couponAvailableType,
                                   @RequestParam("couponDiscountRate") int couponDiscountRate,
                                   @RequestParam("couponNumber") String couponNumber,
                                   @RequestParam("memberId") String memberId){
            try {
                CouponVO couponVO = new CouponVO();
                couponVO.setCouponTitle(couponTitle);
                if (!couponExpireDate.equals("false")){
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDateTime expireDate = LocalDate.parse(couponExpireDate, dtf).atStartOfDay();
                    couponVO.setCouponExpireDate(expireDate);
                } else {
                    couponVO.setCouponExpireDate(null);
                }
                couponVO.setCouponAvailableType(couponAvailableType);
                couponVO.setCouponDiscountRate(couponDiscountRate);
                couponAdminService.saveCoupon(couponVO);
                if (!couponNumber.equals("false") && !memberId.equals("false")) {
                    CouponAdminVO couponAdminVO = new CouponAdminVO();
                    couponAdminVO.setCouponId(couponAdminService.findLatestCoupon());
                    couponAdminVO.setCouponNumber(couponNumber);
                    couponAdminVO.setMemberId(Long.parseLong(memberId));
                    couponAdminService.saveAdminCoupon(couponAdminVO);
                }
                return "success";
            } catch (Exception e) {
                log.info("{}", e.getMessage());
                return "fail";
            }
        }


        @PostMapping("coupon-delete")
        @ResponseBody
        public String deleteCoupon(@RequestParam("couponId") Long couponId){
            try {
                couponAdminService.discardAdminCoupon(couponId);
                couponAdminService.discardMemberCoupon(couponId);
                couponAdminService.discardCoupon(couponId);
                return "success";
            } catch (Exception e){
                log.info("{}", e.getMessage());
                return "fail";
            }
        }








































    }
