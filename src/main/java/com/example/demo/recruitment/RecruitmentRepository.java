package com.example.demo.recruitment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RecruitmentRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<RecruitmentDto> findAllRecruitments() {
        String sql = "SELECT employPostNo, employPostTitle, comName, postDate FROM JOB_POSTING ORDER BY postDate DESC";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new RecruitmentDto(
                rs.getInt("employPostNo"),
                rs.getString("employPostTitle"),
                rs.getString("comName"),
                rs.getTimestamp("postDate").toLocalDateTime()
        ));
    }

    public void deleteRecruitmentsByIds(List<Integer> ids) {
        if (ids.isEmpty()) return; // 빈 목록 처리
        String placeholders = ids.stream().map(id -> "?").collect(Collectors.joining(","));
        String sql = "DELETE FROM JOB_POSTING WHERE employPostNo IN (" + placeholders + ")";
        jdbcTemplate.update(sql, ids.toArray());
    }
}
