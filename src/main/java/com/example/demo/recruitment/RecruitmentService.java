package com.example.demo.recruitment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecruitmentService {

    @Autowired
    private RecruitmentRepository recruitmentRepository;

    public List<RecruitmentDto> getAllRecruitments() {
        return recruitmentRepository.findAllRecruitments();
    }

    public void deleteRecruitments(List<Integer> selectedIds) {
        recruitmentRepository.deleteRecruitmentsByIds(selectedIds);
    }
}
