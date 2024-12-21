package com.example.demo.employerProfile;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/employer")
public class EmployerProfileController {

    @Autowired
    private EmployerProfileService employerProfileService;

    @GetMapping("/profile")
    public String showEmployerProfile(HttpSession session, Model model) {
        String userId = (String) session.getAttribute("userId");
        String userType = (String) session.getAttribute("userType");

        if (!"EMPLOYER".equals(userType)) {
            return "redirect:/main";
        }

        EmployerProfileDto profile = employerProfileService.getEmployerProfile(userId);
        List<String> jobPostTitles = employerProfileService.getJobPostTitlesByEmployerId(userId);

        if (profile == null) {
            model.addAttribute("error", "프로필 정보가 존재하지 않습니다.");
            return "errorPage";
        }

        model.addAttribute("profile", profile);
        model.addAttribute("jobPostTitles", jobPostTitles);
        return "employerProfile";
    }
}