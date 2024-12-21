package com.example.demo.ex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobListService {

    @Autowired
    private JobListRepository jobListRepository;
    @Autowired
    private JobSeekingRepository jobSeekingRepository;
    
    public List<JobPostListDto> getAllJobPostings() {
        return jobListRepository.findAllByOrderByEmployPostNoAsc()
                .stream()
                .map(job -> new JobPostListDto(
                        job.getEmployPostNo(),
                        job.getEmployPostTitle(),
                        job.getComName(),
                        job.getSalary(),
                        job.getRegion()
                ))
                .collect(Collectors.toList());
    }
    
    public List<JobSeekListDto> getAllJobSeekings() {
        return jobSeekingRepository.findAllByOrderBySeekPostNoAsc()
                .stream()
                .map(seek -> new JobSeekListDto(
                        seek.getSeekPostNo(),
                        seek.getSeekPostTitle(),
                        seek.getRegion(),
                        seek.getJobType(),
                        seek.getwPeriod()
                ))
                .collect(Collectors.toList());
    }

}
