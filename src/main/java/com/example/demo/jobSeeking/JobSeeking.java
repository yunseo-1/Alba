package com.example.demo.jobSeeking;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // JPA 엔티티임을 선언
@Table(name = "job_seeking") // 매핑할 테이블 이름(필요 시)
public class JobSeeking {
    
    @Id // 기본 키(primary key)로 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본 키 자동 생성 설정 (필요 시)
    private int seekPostNo; // 기본 키 필드
    
    private String seekPostTitle;
    private String wPeriod;
    private String region;
    private String jobType;
    private String jobseeker_id;

    // Getter와 Setter
    public int getSeekPostNo() {
        return seekPostNo;
    }

    public void setSeekPostNo(int seekPostNo) {
        this.seekPostNo = seekPostNo;
    }

    public String getSeekPostTitle() {
        return seekPostTitle;
    }

    public void setSeekPostTitle(String seekPostTitle) {
        this.seekPostTitle = seekPostTitle;
    }

    public String getwPeriod() {
        return wPeriod;
    }

    public void setwPeriod(String wPeriod) {
        this.wPeriod = wPeriod;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getJobseeker_id() {
        return jobseeker_id;
    }

    public void setJobseeker_id(String jobseeker_id) {
        this.jobseeker_id = jobseeker_id;
    }
}