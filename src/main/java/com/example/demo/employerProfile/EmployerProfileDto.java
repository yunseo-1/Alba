package com.example.demo.employerProfile;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployerProfileDto {
    private String userName;
    private String comName;
    private String userType;
    private String birth;
    private String tel;
    private Double rate;
    private String region;
    
    // Constructor
    public EmployerProfileDto(String userName, String comName, String userType, String birth, String tel, Double rate, String region) {
        this.userName = userName;
        this.comName = comName;
        this.userType = userType;
        this.birth = birth;
        this.tel = tel;
        this.rate = rate;
        this.region = region;
    }
    
    // Getter Setter
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Double getRate() {
		return rate;
	}
	public void setRate(Double rate) {
		this.rate = rate;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
}