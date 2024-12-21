package com.example.demo.jobPosting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.member.MemberDto;

@Repository
public class JobPostingDAO {
    final String JDBC_URL = "jdbc:mysql://localhost:3306/test2";
    final String JDBC_USER = "root";
    final String JDBC_PASSWORD = "1234";

    private Connection open() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    public void addJobPosting(JobPosting job) throws Exception {
        String sql = "INSERT INTO job_posting (employPostTitle, comName, wPeriod, region, jobType, salary, employPostDetail, postDate, employer_id) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, NOW(), ?)";

        try (Connection conn = open(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, job.getEmployPostTitle());
            pstmt.setString(2, job.getComName());
            pstmt.setString(3, job.getwPeriod());
            pstmt.setString(4, job.getRegion());
            pstmt.setString(5, job.getJobType());
            pstmt.setInt(6, job.getSalary());
            pstmt.setString(7, job.getEmployPostDetail());
            pstmt.setString(8, job.getEmployer_id()); // employer_id 설정
            pstmt.executeUpdate();
        }
    }

    public JobPosting getJobPostingDetail(int employPostNo) throws Exception {
        String sql = "SELECT employPostNo, employPostTitle, comName, rate, rate_cnt, rate_sum, wPeriod, region, jobType, salary, employPostDetail FROM job_posting WHERE employPostNo = ?";
        try (Connection conn = open(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, employPostNo);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    JobPosting detail = new JobPosting();
                    detail.setEmployPostNo(rs.getInt("employPostNo"));
                    detail.setEmployPostTitle(rs.getString("employPostTitle"));
                    detail.setComName(rs.getString("comName"));
                    detail.setRate(rs.getDouble("rate"));
                    detail.setRateCnt(rs.getInt("rate_cnt"));
                    detail.setRateSum(rs.getInt("rate_sum"));
                    detail.setwPeriod(rs.getString("wPeriod"));
                    detail.setRegion(rs.getString("region"));
                    detail.setJobType(rs.getString("jobType"));
                    detail.setSalary(rs.getInt("salary"));
                    detail.setEmployPostDetail(rs.getString("employPostDetail"));
                    return detail;
                } else {
                    return null;
                }
            }
        }
    }

    public void updateRating(int employPostNo, int rating) throws Exception {
        String sql = "UPDATE job_posting SET rate_cnt = rate_cnt + 1, rate_sum = rate_sum + ?, rate = ROUND((rate_sum + ?) / (rate_cnt + 1), 1) WHERE employPostNo = ?";
        try (Connection conn = open(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, rating);
            pstmt.setInt(2, rating);
            pstmt.setInt(3, employPostNo);
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Update successful for employPostNo: " + employPostNo);

                // Recalculate the correct rate
                String recalculateSql = "SELECT rate_cnt, rate_sum FROM job_posting WHERE employPostNo = ?";
                try (PreparedStatement recalculateStmt = conn.prepareStatement(recalculateSql)) {
                    recalculateStmt.setInt(1, employPostNo);
                    try (ResultSet rs = recalculateStmt.executeQuery()) {
                        if (rs.next()) {
                            int rateCnt = rs.getInt("rate_cnt");
                            int rateSum = rs.getInt("rate_sum");
                            double newRate = rateCnt > 0 ? Math.round((double) rateSum / rateCnt * 10) / 10.0 : 0.0;

                            // Update the rate to the correct value
                            String updateRateSql = "UPDATE job_posting SET rate = ? WHERE employPostNo = ?";
                            try (PreparedStatement updateRateStmt = conn.prepareStatement(updateRateSql)) {
                                updateRateStmt.setDouble(1, newRate);
                                updateRateStmt.setInt(2, employPostNo);
                                updateRateStmt.executeUpdate();
                            }

                            System.out.println("Recalculated Rate: " + newRate);
                        }
                    }
                }
            } else {
                System.out.println("No rows affected for employPostNo: " + employPostNo);
            }
        } catch (Exception e) {
            System.out.println("Error updating rating for employPostNo: " + employPostNo);
            e.printStackTrace();
            throw e;
        }
    }

    public List<JobPosting> getAllJobPostings() throws Exception {
        String sql = "SELECT employPostNo, employPostTitle FROM job_posting";
        List<JobPosting> jobPostingList = new ArrayList<>();
        try (Connection conn = open();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                JobPosting job = new JobPosting();
                job.setEmployPostNo(rs.getInt("employPostNo"));
                job.setEmployPostTitle(rs.getString("employPostTitle"));
                jobPostingList.add(job);
            }
        }
        return jobPostingList;
    }
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public String getEmployerIdByEmployPostNo(int employPostNo) {
        String sql = "SELECT employer_id FROM job_posting WHERE employPostNo = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{employPostNo}, String.class);
        } catch (EmptyResultDataAccessException e) {
            System.out.println("employPostNo " + employPostNo + "에 해당하는 employer_id가 없습니다.");
            return null;
        }
    }
    
    public String getCompanyNameByEmployerId(String employerId) throws Exception {
        System.out.println("Fetching company name for employerId: " + employerId);
        String sql = "SELECT comName FROM member WHERE userId = ?";
        try (Connection conn = open(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, employerId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String comName = rs.getString("comName");
                    System.out.println("Company name found: " + comName);
                    return comName;
                } else {
                    System.out.println("No company name found for employerId: " + employerId);
                }
            }
        }
        return null;
    }

}
