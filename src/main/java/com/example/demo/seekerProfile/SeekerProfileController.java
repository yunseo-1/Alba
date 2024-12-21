package com.example.demo.seekerProfile;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.notification.NotificationDto;
import com.example.demo.notification.NotificationService;

import jakarta.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/seeker")
public class SeekerProfileController {

    @Autowired
    private SeekerProfileService seekerProfileService;

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/profile")
    public String showSeekerProfile(
            HttpSession session, 
            Model model, 
            @RequestParam(value = "receiverId", required = false) String receiverId) {
        // 세션에서 로그인 사용자 정보 가져오기
        String userType = (String) session.getAttribute("userType");
        String userId = (String) session.getAttribute("userId");

        // 권한 체크: EMPLOYER 또는 SEEKER만 접근 가능
        if (!"EMPLOYER".equals(userType) && !"SEEKER".equals(userType)) {
            return "redirect:/main";
        }

        
        
        
        String targetUserId = receiverId != null ? receiverId : userId;
        SeekerProfileDto profile1 = seekerProfileService.getSeekerProfile(targetUserId);
        if (profile1 == null) {
            model.addAttribute("error", "프로필 정보가 존재하지 않습니다.");
            return "errorPage";
        }
     // 구직글 목록 추가
        List<String> jobSeekingTitles = seekerProfileService.getAllJobSeekingTitles(targetUserId);
        model.addAttribute("jobSeekingTitles", jobSeekingTitles);

        model.addAttribute("profile", profile1);
        model.addAttribute("receiverId", targetUserId);
        
        
        
        
        
        
        
        // 구직자 프로필 조회: receiverId가 없으면 본인의 프로필로 이동
        SeekerProfileDto profile = seekerProfileService.getSeekerProfile(receiverId != null ? receiverId : userId);
        if (profile == null) {
            model.addAttribute("error", "프로필 정보가 존재하지 않습니다.");
            return "errorPage";
        }

        // 프로필 데이터와 receiverId를 모델에 추가
        model.addAttribute("profile", profile);
        model.addAttribute("receiverId", receiverId != null ? receiverId : userId);

        // 구직자(본인)가 알림을 확인하는 경우
        if ("SEEKER".equals(userType)) {
            List<NotificationDto> notifications = notificationService.getNotificationsByReceiverId(userId);
            model.addAttribute("notifications", notifications);
        }

        // 업주(EMPLOYER)가 구직자 프로필을 보는 경우
        model.addAttribute("isEmployer", "EMPLOYER".equals(userType));
        return "seekerProfile";
    }

    @PostMapping("/scout")
    public String scoutSeeker(
            HttpSession session, 
            @RequestParam("receiverId") String receiverId, 
            @RequestParam("message") String message) {
        // 업주의 회사명 가져오기
        String scoutCompanyName = (String) session.getAttribute("comName");
        if (scoutCompanyName == null) {
            return "redirect:/main"; // 세션 만료 시 메인 페이지로 이동
        }

        // 스카우트 알림 저장
        notificationService.sendNotification(scoutCompanyName, message, receiverId);
        return "redirect:/seeker/profile?receiverId=" + receiverId;
    }
    
    
}