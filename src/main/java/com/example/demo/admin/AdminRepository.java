package com.example.demo.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AdminRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public long countRecruitments() {
        String sql = "SELECT COUNT(*) FROM JOB_POSTING";
        return jdbcTemplate.queryForObject(sql, Long.class);
    }

    public long countJobSeekers() {
        String sql = "SELECT COUNT(*) FROM JOB_SEEKING";
        return jdbcTemplate.queryForObject(sql, Long.class);
    }

    public long countMembers() {
        String sql = "SELECT COUNT(*) FROM MEMBER";
        return jdbcTemplate.queryForObject(sql, Long.class);
    }
}
