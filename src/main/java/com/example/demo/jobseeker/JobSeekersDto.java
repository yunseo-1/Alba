package com.example.demo.jobseeker;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class JobSeekersDto {
    private int seekPostNo;       // 구직글 번호
    private String seekPostTitle; // 구직글 제목
    private String nickName;      // 닉네임
    private LocalDateTime postDate; // 등록일자

    // 생성자 추가
    public JobSeekersDto(int seekPostNo, String seekPostTitle, String nickName, LocalDateTime postDate) {
        this.setSeekPostNo(seekPostNo);
        this.setSeekPostTitle(seekPostTitle);
        this.setNickName(nickName);
        this.setPostDate(postDate);
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

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public LocalDateTime getPostDate() {
		return postDate;
	}

	public void setPostDate(LocalDateTime postDate) {
		this.postDate = postDate;
	}
}
