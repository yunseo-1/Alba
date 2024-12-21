package com.example.demo.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping
    public String showAdminPage() {
        return "admin"; // admin.jsp
    }

    @GetMapping("/recruitments")
    public String redirectToRecruitments() {
        return "redirect:/recruitments";
    }

    @GetMapping("/jobSeekers")
    public String redirectToJobSeekers() {
        return "redirect:/jobSeekers";
    }

    @GetMapping("/members")
    public String redirectToMembers() {
        return "redirect:/members";
    }
}
