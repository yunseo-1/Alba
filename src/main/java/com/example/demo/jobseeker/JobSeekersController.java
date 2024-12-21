package com.example.demo.jobseeker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/jobSeekers")
public class JobSeekersController {

    @Autowired
    private JobSeekersService jobSeekersService;

    @GetMapping
    public String listJobSeekers(Model model) {
        List<JobSeekersDto> jobSeekers = jobSeekersService.getAllJobSeekers();
        model.addAttribute("jobSeekers", jobSeekers);
        return "jobSeekers"; // jobSeekers.jsp로 연결
    }

    @PostMapping("/delete")
    public String deleteJobSeekers(@RequestParam("selectedIds") List<Integer> selectedIds) {
        jobSeekersService.deleteJobSeekers(selectedIds);
        return "redirect:/jobSeekers"; // 삭제 후 목록 새로고침
    }
}
