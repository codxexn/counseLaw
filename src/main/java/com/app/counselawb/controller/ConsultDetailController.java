package com.app.counselawb.controller;


import com.app.counselawb.domain.dto.ConsultDetailDTO;
import com.app.counselawb.domain.pagination.Pagination;
import com.app.counselawb.service.ConsultingCaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/consult-detail/*")
public class ConsultDetailController {

    private final ConsultingCaseService consultingCaseService;

    @GetMapping("/{consultId}")
    public String goToConsultationDetail(@PathVariable long consultId, Model model, Pagination pagination){
        List<ConsultDetailDTO> consultDetailDTO = consultingCaseService.readDetails(pagination);
        model.addAttribute("consultDetail",consultDetailDTO);
        return "consult-detail/consult-detail";
    }

}
