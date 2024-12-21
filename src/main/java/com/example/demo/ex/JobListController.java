package com.example.demo.ex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class JobListController {

    @Autowired
    private JobListService jobListService;
    
    
    @GetMapping("/main")
    public String showPostMainPage(Model model) {
    	// 채용공고 리스트
    	List<JobPostListDto> jobList = jobListService.getAllJobPostings();
        model.addAttribute("jobList", jobList); // jobList 데이터를 추가
        
        //구직글 리스트
        List<JobSeekListDto> seekingList = jobListService.getAllJobSeekings();
        model.addAttribute("seekingList", seekingList);
        return "main";
    }
}