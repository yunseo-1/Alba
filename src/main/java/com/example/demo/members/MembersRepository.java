package com.example.demo.members;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MembersRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<MemberDto> findAllMembers() {
        String sql = "SELECT userId, nickName, comName, tel, signDate, userType " +
                     "FROM MEMBER " +
                     "ORDER BY signDate DESC";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            String displayName = "정보 없음";
            String userType = rs.getString("userType");

            if ("employer".equalsIgnoreCase(userType)) {
                displayName = rs.getString("comName");
            } else if ("seeker".equalsIgnoreCase(userType)) {
                displayName = rs.getString("nickName");
            }

            return new MemberDto(
                    rs.getString("userId"),
                    displayName,
                    rs.getString("tel"),
                    rs.getTimestamp("signDate").toLocalDateTime()
            );
        });
    }




    public void deleteMembersByIds(List<String> ids) {
        if (ids.isEmpty()) return; // 빈 목록 처리
        // IN 절에 사용할 자리 표시자 생성
        String placeholders = String.join(",", ids.stream().map(id -> "?").toArray(String[]::new));
        String sql = "DELETE FROM MEMBER WHERE userId IN (" + placeholders + ")";
        jdbcTemplate.update(sql, ids.toArray());
    }

}
