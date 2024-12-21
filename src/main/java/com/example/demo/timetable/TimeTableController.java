package com.example.demo.timetable;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/timetable")
public class TimeTableController {

    @Autowired
    private TimeTableService timeTableService;

    @GetMapping("/list")
    @ResponseBody
    public ResponseEntity<List<TimeTableDto>> getTimeTables(HttpSession session) {
        String userId = (String) session.getAttribute("userId");
        if (userId == null) {
            return ResponseEntity.status(403).build();
        }
        List<TimeTableDto> timeTables = timeTableService.getTimeTableByUserId(userId);
        return ResponseEntity.ok(timeTables);
    }

    @PostMapping("/add")
    public String addTimeTable(@ModelAttribute TimeTableDto timeTableDto, HttpSession session) {
        String userId = (String) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/login";
        }
        timeTableService.addTimeTable(userId, timeTableDto);
        return "redirect:/timetable";
    }
    
    @PostMapping("/add2")
    @ResponseBody
    public ResponseEntity<String> addTimeTablePosting(@ModelAttribute TimeTableDto timeTableDto, HttpSession session) {
        String userId = (String) session.getAttribute("userId");
        if (userId == null) {
            return ResponseEntity.status(403).body("Unauthorized"); // 인증되지 않은 사용자 처리
        }

        // 타임테이블 데이터 저장 로직
        timeTableService.addTimeTable(userId, timeTableDto);
        return ResponseEntity.ok("Time table saved successfully"); // 성공 메시지 반환
    }
    @GetMapping
    public String showTimeTablePage() {
        return "timetable";
    }
    
    @PostMapping("/compare")
    @ResponseBody
    public ResponseEntity<List<TimeTableDto>> compareTimeTables(
            HttpSession session,
            @RequestParam("receiverId") String receiverId) {
        String employerId = (String) session.getAttribute("userId");
        System.out.println("EmployerId: " + employerId);
        System.out.println("ReceiverId: " + receiverId);
        if (employerId == null) {
            return ResponseEntity.status(403).build(); // 인증되지 않은 사용자
        }

        List<TimeTableDto> commonTimes = timeTableService.compareTimeTables(employerId, receiverId);
        return ResponseEntity.ok(commonTimes); // 비교 결과 반환
    }
}
