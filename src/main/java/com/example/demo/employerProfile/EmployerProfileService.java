package com.example.demo.employerProfile;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployerProfileService {

    @Autowired
    private EmployerProfileRepository employerProfileRepository;

    public EmployerProfileDto getEmployerProfile(String userId) {
        return employerProfileRepository.findEmployerProfileByUserId(userId);
    }
    
    public List<String> getJobPostTitlesByEmployerId(String userId) {
        return employerProfileRepository.findJobPostTitlesByEmployerId(userId);
    }
}