package com.app.counselawb.controller;


import com.app.counselawb.domain.vo.*;
import com.app.counselawb.service.LawyerService;
import com.app.counselawb.service.LawyerWriteService;
import com.app.counselawb.service.LawyerWriteServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/lawyer-write/*")
public class LawyerWriteController {
    private final LawyerService lawyerService;
    private final LawyerWriteService lawyerWriteService;

    @GetMapping("lawyer-write-lg")
    public String GoToLegalGuideWrite(Model model, HttpSession session, LegalGuideVO legalGuideVO, MemberVO memberVO,
                                      LawyerVO lawyerVO){
        if (session.getAttribute("lawyer") == null){
            return "client-login/client-login";
        }
        LawyerVO currentLawyer = (LawyerVO) session.getAttribute("lawyer");
        Long lawyerId = currentLawyer.getLawyerId();
        model.addAttribute("lawyerId", lawyerId);
        List<FieldVO> fieldList = lawyerService.findAllFields();
        model.addAttribute("fieldList", fieldList);
        return "lawyer-write/lawyer-write-lg";
    }

    @PostMapping("lawyer-write-lg")
    public RedirectView postLegalGuide(@RequestParam("lawyerId") Long lawyerId, @RequestParam("title") String legalGuideTitle,
                                       @RequestParam("body") String legalGuideContent, @RequestParam("eachField") Long fieldId){
        LegalGuideVO legalGuideVO = new LegalGuideVO();
        legalGuideVO.setLawyerId(lawyerId);
        legalGuideVO.setLegalGuideTitle(legalGuideTitle);
        legalGuideVO.setLegalGuideContent(legalGuideContent);
        legalGuideVO.setFieldId(fieldId);
        lawyerWriteService.saveLegalGuide(legalGuideVO);
        return new RedirectView("/legal-guide-page/legal-guide");
    }

    @GetMapping("lawyer-write-sc")
    public String GoToSolutionCaseWrite(Model model, HttpSession session, LegalGuideVO legalGuideVO, MemberVO memberVO,
                                      LawyerVO lawyerVO){
        if (session.getAttribute("lawyer") == null){
            return "client-login/client-login";
        }
        LawyerVO currentLawyer = (LawyerVO) session.getAttribute("lawyer");
        Long lawyerId = currentLawyer.getLawyerId();
        model.addAttribute("lawyerId", lawyerId);
        List<FieldVO> fieldList = lawyerService.findAllFields();
        model.addAttribute("fieldList", fieldList);
        return "lawyer-write/lawyer-write-sc";
    }

    @PostMapping("lawyer-write-sc")
    public RedirectView postSolutionCase(@RequestParam("lawyerId") Long lawyerId, @RequestParam("title") String solutionCaseTitle,
                                         @RequestParam("body") String solutionCaseContent, @RequestParam("eachField") Long fieldId,
                                         @RequestParam("result") String sentenceResult, MultipartHttpServletRequest mhsr) throws Exception{
        SolutionCaseVO solutionCaseVO = new SolutionCaseVO();
        solutionCaseVO.setLawyerId(lawyerId);
        solutionCaseVO.setSolutionCaseTitle(solutionCaseTitle);
        solutionCaseVO.setSolutionCaseContent(solutionCaseContent);
        solutionCaseVO.setFieldId(fieldId);
        solutionCaseVO.setSentenceResult(sentenceResult);
        lawyerWriteService.saveSolutionCase(solutionCaseVO);
        List<MultipartFile> files = mhsr.getFiles("files");
        if (!files.isEmpty()){
            Long solutionCaseId = lawyerWriteService.findLatestIdByLawyerId(lawyerId);
            for (MultipartFile file : files){
                if (file.isEmpty()){
                    continue;
                }
                SolutionCaseImgVO solutionCaseImgVO = new SolutionCaseImgVO();
                solutionCaseImgVO.setSolutionCaseId(solutionCaseId);
                String originFileName = file.getOriginalFilename();
                String fileNameExtension = FilenameUtils.getExtension(originFileName).toLowerCase();
                String absolutePath = "/usr/upload";
                String fileUrl = "/solution-case-images/";
                File destinationFile;
                String destinationFileName;
                do {
                    destinationFileName = RandomStringUtils.randomAlphanumeric(32) + "." + fileNameExtension;
                    destinationFile = new File(absolutePath + fileUrl + destinationFileName);
                } while (destinationFile.exists());

                destinationFile.getParentFile().mkdirs();
                file.transferTo(destinationFile);

                solutionCaseImgVO.setImgSize(file.getSize());
                solutionCaseImgVO.setStoredFileName(destinationFileName);
                solutionCaseImgVO.setOriginFileName(originFileName);
                solutionCaseImgVO.setImgPath("/image/res" + fileUrl);
                lawyerWriteService.saveSolutionCaseImg(solutionCaseImgVO);
            }
        }
        return new RedirectView("/solution-case-page/solution-case");
    }
}
