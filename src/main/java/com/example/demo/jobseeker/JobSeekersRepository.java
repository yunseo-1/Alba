package com.example.demo.jobseeker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class JobSeekersRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<JobSeekersDto> findAllJobSeekers() {
        String sql = "SELECT js.seekPostNo, js.seekPostTitle, m.nickName, js.postDate " +
                     "FROM JOB_SEEKING js " +
                     "JOIN MEMBER m ON js.jobseeker_id = m.userId " +
                     "ORDER BY js.postDate DESC";

        return jdbcTemplate.query(sql, (rs, rowNum) -> new JobSeekersDto(
                rs.getInt("seekPostNo"),
                rs.getString("seekPostTitle"),
                rs.getString("nickName"),
                rs.getTimestamp("postDate").toLocalDateTime()
        ));
    }


    public void deleteJobSeekersByIds(List<Integer> ids) {
        if (ids.isEmpty()) return; // 빈 목록 처리
        String placeholders = ids.stream().map(id -> "?").collect(Collectors.joining(","));
        String sql = "DELETE FROM JOB_SEEKING WHERE seekPostNo IN (" + placeholders + ")";
        jdbcTemplate.update(sql, ids.toArray());
    }
}
