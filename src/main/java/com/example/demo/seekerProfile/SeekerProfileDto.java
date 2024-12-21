package com.example.demo.seekerProfile;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SeekerProfileDto {
    private String userName;    // 회원 이름
    private String userId;      // 회원 아이디
    private String nickName;    // 닉네임
    private String userType;    // 회원 구분
    private String birth;       // 생년월일
    private String tel;         // 전화번호
    private String region;      // 지역
    private String seekPostTitle; // 구직글 제목
    
    // Controller
    public SeekerProfileDto(String userName, String userId, String nickName, String userType, String birth, String tel, String region, String seekPostTitle) {
        this.userName = userName;
        this.userId = userId;
        this.nickName = nickName;
        this.userType = userType;
        this.birth = birth;
        this.tel = tel;
        this.region = region;
        this.seekPostTitle = seekPostTitle;
    }
    
    // Getter Setter
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
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
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
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getSeekPostTitle() {
		return seekPostTitle;
	}
	public void setSeekPostTitle(String seekPostTitle) {
		this.seekPostTitle = seekPostTitle;
	}
}