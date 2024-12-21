package com.example.demo.jobseeker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekersService {

    @Autowired
    private JobSeekersRepository jobSeekersRepository;

    public List<JobSeekersDto> getAllJobSeekers() {
        return jobSeekersRepository.findAllJobSeekers();
    }

    public void deleteJobSeekers(List<Integer> ids) {
        jobSeekersRepository.deleteJobSeekersByIds(ids);
    }
}
