package com.example.demo.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public AdminSummaryDto getAdminSummary() {
        long recruitmentsCount = adminRepository.countRecruitments();
        long jobSeekersCount = adminRepository.countJobSeekers();
        long membersCount = adminRepository.countMembers();

        return new AdminSummaryDto(recruitmentsCount, jobSeekersCount, membersCount);
    }
}
