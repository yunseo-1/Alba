package com.example.demo.ex;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobSeekListDto {
    private int seekPostNo;       // 구직글 번호
    private String seekPostTitle; // 구직글 제목
    private String region;        // 지역
    private String jobType;       // 업종
    private String wPeriod;       // 근무 기간
    
    public JobSeekListDto(int seekPostNo, String seekPostTitle, String region, String jobType, String wPeriod) {
        this.seekPostNo = seekPostNo;
        this.seekPostTitle = seekPostTitle;
        this.region = region;
        this.jobType = jobType;
        this.wPeriod = wPeriod;
    }
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
	public String getwPeriod() {
		return wPeriod;
	}
	public void setwPeriod(String wPeriod) {
		this.wPeriod = wPeriod;
	}
}
