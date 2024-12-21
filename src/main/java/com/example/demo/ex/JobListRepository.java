package com.example.demo.ex;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.jobPosting.JobPosting;

import java.util.List;

@Repository
public interface JobListRepository extends JpaRepository<JobPosting, Integer> {
    List<JobPosting> findAllByOrderByEmployPostNoAsc();
}