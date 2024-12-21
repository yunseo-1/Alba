package com.example.demo.seekerProfile;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeekerProfileService {

    @Autowired
    private SeekerProfileRepository seekerProfileRepository;

    public SeekerProfileDto getSeekerProfile(String userId) {
        return seekerProfileRepository.findSeekerProfileByUserId(userId);
    }
    
    public List<String> getAllJobSeekingTitles(String userId) {
        return seekerProfileRepository.findAllJobSeekingTitlesByUserId(userId);
    }
}