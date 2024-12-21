package com.example.demo.members;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/members")
public class MembersController {

    @Autowired
    private MembersService membersService;

    @GetMapping
    public String listMembers(Model model) {
        List<MemberDto> members = membersService.getAllMembers();
        model.addAttribute("members", members);
        return "members"; // members.jsp로 연결
    }

    @PostMapping("/delete")
    public String deleteMembers(@RequestParam("selectedIds") List<String> selectedIds) {
        membersService.deleteMembers(selectedIds);
        return "redirect:/members"; // 삭제 후 목록 새로고침
    }
}
