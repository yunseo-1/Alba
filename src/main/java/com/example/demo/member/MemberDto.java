package com.example.demo.member;

import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {
    private String userName;
    private String userId;
    private String userPwd;
    private String nickName;
    private String comName;
    private String userType;
    private LocalDate birth;
    private String tel;
    
    //Getter Setter
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
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
	public LocalDate getBirth() {
		return birth;
	}
	public void setBirth(LocalDate birth) {
		this.birth = birth;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
}