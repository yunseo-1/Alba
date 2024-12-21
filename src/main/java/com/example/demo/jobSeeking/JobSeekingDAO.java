package com.example.demo.jobSeeking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class JobSeekingDAO {
	final String JDBC_URL = "jdbc:mysql://localhost:3306/test2";
	final String JDBC_USER = "root";
	final String JDBC_PASSWORD = "1234";

	// DB 결말 메서드
	private Connection open() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
	}

	// 구직글 등록
	public void addJobSeeking(JobSeeking job) throws Exception {
		String sql = "INSERT INTO job_seeking (seekPostTitle, wPeriod, region, jobType, postDate, jobseeker_id) VALUES (?, ?, ?, ?, NOW(), ?)";
		try (Connection conn = open(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, job.getSeekPostTitle());
			pstmt.setString(2, job.getwPeriod());
			pstmt.setString(3, job.getRegion());
			pstmt.setString(4, job.getJobType());
			pstmt.setString(5, job.getJobseeker_id());

			// 디버깅 로그 추가
			System.out.println("Inserting JobSeeker ID: " + job.getJobseeker_id());

			pstmt.executeUpdate();
		}
	}

	// 구직글 상세 가져오기
	public JobSeeking getJobSeekingDetail(int seekPostNo) throws Exception {
		String sql = "SELECT seekPostNo, seekPostTitle, wPeriod, region, jobType, jobseeker_id FROM job_seeking WHERE seekPostNo = ?";
		try (Connection conn = open(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, seekPostNo);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					JobSeeking detail = new JobSeeking();
					detail.setSeekPostNo(rs.getInt("seekPostNo"));
					detail.setSeekPostTitle(rs.getString("seekPostTitle"));
					detail.setwPeriod(rs.getString("wPeriod"));
					detail.setRegion(rs.getString("region"));
					detail.setJobType(rs.getString("jobType"));
					detail.setJobseeker_id(rs.getString("jobseeker_id")); // jobseeker_id 추가

					// 디버깅 로그
					System.out.println("Fetched JobSeeker ID: " + detail.getJobseeker_id());
					return detail;
				}
			}
		}
		return null;
	}

	// 구직글 리스트 가져오기
	public List<JobSeeking> getAllJobSeekings() throws Exception {
		String sql = "SELECT seekPostNo, seekPostTitle FROM job_seeking";
		List<JobSeeking> jobSeekingList = new ArrayList<>();
		try (Connection conn = open();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			while (rs.next()) {
				JobSeeking job = new JobSeeking();
				job.setSeekPostNo(rs.getInt("seekPostNo"));
				job.setSeekPostTitle(rs.getString("seekPostTitle"));
				jobSeekingList.add(job);
			}
		}
		return jobSeekingList;
	}

	// 닉네임 가져오기
	public String getNickNameByJobSeekerId(String jobSeekerId) throws Exception {
		String sql = "SELECT nickName FROM MEMBER WHERE userId = ?";
		try (Connection conn = open(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, jobSeekerId);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return rs.getString("nickName");
				}
			}
		}
		return null;
	}
}