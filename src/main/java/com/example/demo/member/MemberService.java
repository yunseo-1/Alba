package com.example.demo.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String registerMember(MemberDto member) {
        String sql = "INSERT INTO MEMBER (userName, userId, userPwd, nickName, comName, userType, birth, tel) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            jdbcTemplate.update(sql,
                    member.getUserName(),
                    member.getUserId(),
                    member.getUserPwd(),
                    member.getNickName(),
                    member.getComName(),
                    member.getUserType(),
                    member.getBirth(),
                    member.getTel());
            return "Registration successful!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error during registration: " + e.getMessage();
        }
    }

    public boolean validateLogin(String userId, String userPwd) {
        String sql = "SELECT COUNT(*) FROM MEMBER WHERE userId = ? AND userPwd = ?";
        Integer count = jdbcTemplate.queryForObject(sql, new Object[]{userId, userPwd}, Integer.class);
        return count != null && count > 0;
    }
    
    public String getUserNameByUserId(String userId) {
        String sql = "SELECT userName FROM MEMBER WHERE userId = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{userId}, String.class);
    }
    
    public String getUserTypeByUserId(String userId) {
        String sql = "SELECT userType FROM MEMBER WHERE userId = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{userId}, String.class);
    }
    
    public String getCompanyNameByUserId(String userId) {
        String sql = "SELECT comName FROM MEMBER WHERE userId = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{userId}, String.class);
    }
}