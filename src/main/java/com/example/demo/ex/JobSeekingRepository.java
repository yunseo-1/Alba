package com.example.demo.ex;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.jobSeeking.JobSeeking;

@Repository
public interface JobSeekingRepository extends JpaRepository<JobSeeking, Integer> {
    List<JobSeeking> findAllByOrderBySeekPostNoAsc();
}