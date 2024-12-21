package com.example.demo.jobPosting;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "job_posting") // 데이터베이스 테이블 이름
public class JobPosting {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본 키 자동 생성
    private int employPostNo;				// 채용 공고 번호
    private String employPostTitle;			// 채용 공고  제목
    private String comName;					// 회사명
    private double rate;					// 평점
    private int rate_cnt;					// 평가 횟수
    private int rate_sum;					// 평점 누적
    private String wPeriod;					// 근무 기간
    private String region;					// 근무 지역
    private String jobType;					// 업종
    private int salary;						// 급여
    private String employPostDetail;		// 상세 내용
    private String employer_id;
    
    // Getter Setter
    public int getEmployPostNo() {
        return employPostNo;
    }

    public void setEmployPostNo(int employPostNo) {
        this.employPostNo = employPostNo;
    }

    public String getEmployPostTitle() {
        return employPostTitle;
    }

    public void setEmployPostTitle(String employPostTitle) {
        this.employPostTitle = employPostTitle;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getRateCnt() {
        return rate_cnt;
    }

    public void setRateCnt(int rate_cnt) {
        this.rate_cnt = rate_cnt;
    }

    public int getRateSum() {
        return rate_sum;
    }

    public void setRateSum(int rate_sum) {
        this.rate_sum = rate_sum;
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getEmployPostDetail() {
        return employPostDetail;
    }

    public void setEmployPostDetail(String employPostDetail) {
        this.employPostDetail = employPostDetail;
    }

	public String getEmployer_id() {
		return employer_id;
	}

	public void setEmployer_id(String employer_id) {
		this.employer_id = employer_id;
	}
}
