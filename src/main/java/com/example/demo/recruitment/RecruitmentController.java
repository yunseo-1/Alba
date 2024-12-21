package com.example.demo.recruitment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/recruitments")
public class RecruitmentController {

    @Autowired
    private RecruitmentService recruitmentService;

    @GetMapping
    public String listRecruitments(Model model) {
        List<RecruitmentDto> recruitments = recruitmentService.getAllRecruitments();
        model.addAttribute("recruitments", recruitments);
        return "recruitment"; // recruitment.jsp로 연결
    }

    @PostMapping("/delete")
    public String deleteRecruitments(@RequestParam("selectedIds") List<Integer> selectedIds) {
        if (selectedIds != null && !selectedIds.isEmpty()) {
            recruitmentService.deleteRecruitments(selectedIds);
        }
        return "redirect:/recruitments";
    }
}
