package com.example.demo.admin;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class AdminSummaryDto {
    private long recruitments;
    private long jobSeekers;
    private long members;
	public AdminSummaryDto(long recruitmentsCount, long jobSeekersCount, long membersCount) {
		// TODO Auto-generated constructor stub
	}
	public long getRecruitments() {
		return recruitments;
	}
	public void setRecruitments(long recruitments) {
		this.recruitments = recruitments;
	}
	public long getJobSeekers() {
		return jobSeekers;
	}
	public void setJobSeekers(long jobSeekers) {
		this.jobSeekers = jobSeekers;
	}
	public long getMembers() {
		return members;
	}
	public void setMembers(long members) {
		this.members = members;
	}
}
