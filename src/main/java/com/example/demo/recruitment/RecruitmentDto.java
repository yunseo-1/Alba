package com.example.demo.recruitment;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class RecruitmentDto {
    private int employPostNo;       // 게시글 번호
    private String employPostTitle; // 채용공고 제목
    private String comName;         // 회사명
    private LocalDateTime postDate; // 등록일자

    // 기본 생성자 (필요하면 추가)
    public RecruitmentDto() {
    }

    
    public RecruitmentDto(int employPostNo, String employPostTitle, String comName, LocalDateTime postDate) {
        this.setEmployPostNo(employPostNo);
        this.setEmployPostTitle(employPostTitle);
        this.setComName(comName);
        this.setPostDate(postDate);
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

	public LocalDateTime getPostDate() {
		return postDate;
	}

	public void setPostDate(LocalDateTime postDate) {
		this.postDate = postDate;
	}
}
