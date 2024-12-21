package com.example.demo.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }

    @PostMapping("/register")
    public String registerMember(@ModelAttribute MemberDto memberDto, Model model) {
        String message = memberService.registerMember(memberDto);
        model.addAttribute("message", message);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(
            @RequestParam("userId") String userId,
            @RequestParam("userPwd") String userPwd,
            HttpSession session,
            Model model) {
        boolean isValidUser = memberService.validateLogin(userId, userPwd);

        if (isValidUser) {
            String userName = memberService.getUserNameByUserId(userId);
            String userType = memberService.getUserTypeByUserId(userId);
            session.setAttribute("userId", userId);
            session.setAttribute("userName", userName);
            session.setAttribute("userType", userType);

            // EMPLOYER인 경우 comName 저장
            if ("EMPLOYER".equals(userType)) {
                String comName = memberService.getCompanyNameByUserId(userId);
                session.setAttribute("comName", comName);
                System.out.println("Company Name set in session: " + comName);
            }

            return "redirect:/main";
        } else {
            model.addAttribute("error", "아이디 또는 비밀번호가 틀렸습니다.");
            return "login";
        }
    }

    /*
    @GetMapping("/main")
    public String showMainPage() {
        return "main";
    }
*/
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // 세션 비우기
        session.invalidate();
        return "redirect:/main";
    }
}