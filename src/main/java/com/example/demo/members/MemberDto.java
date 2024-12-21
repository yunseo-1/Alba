package com.example.demo.members;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor // 모든 필드를 포함한 생성자를 자동 생성
public class MemberDto {
    private String userId;        // 회원 ID
    private String displayName;   // 닉네임 또는 회사명
    private String tel;           // 연락처
    private LocalDateTime signDate; // 가입일

    // 명시적 생성자 추가
    public MemberDto(String userId, String displayName, String tel, LocalDateTime signDate) {
        this.setUserId(userId);
        this.setDisplayName(displayName);
        this.setTel(tel);
        this.setSignDate(signDate);
    }

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public LocalDateTime getSignDate() {
		return signDate;
	}

	public void setSignDate(LocalDateTime signDate) {
		this.signDate = signDate;
	}
}
