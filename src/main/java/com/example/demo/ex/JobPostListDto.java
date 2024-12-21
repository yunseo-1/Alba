package com.example.demo.ex;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobPostListDto {
    private int employPostNo;
    private String employPostTitle;
    private String comName;
    private int salary;
    private String region;
    
    
	public JobPostListDto(int employPostNo, String employPostTitle, String comName, int salary, String region) {
        this.employPostNo = employPostNo;
        this.employPostTitle = employPostTitle;
        this.comName = comName;
        this.salary = salary;
        this.region = region;
    }
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
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
}
