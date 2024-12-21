package com.example.demo.seekerProfile;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SeekerProfileRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 지역 ID를 지역명으로 매핑
    private String mapRegion(String regionId) {
        switch (regionId) {
            case "1":
                return "정왕1동";
            case "2":
                return "정왕2동";
            case "3":
                return "정왕3동";
            case "4":
                return "정왕4동";
            case "5":
                return "정왕동";
            case "6":
                return "정왕본동";
            default:
                return "Unknown Region";
        }
    }

    public List<String> findAllJobSeekingTitlesByUserId(String userId) {
        String sql = "SELECT seekPostTitle FROM JOB_SEEKING WHERE jobseeker_id = ?";
        return jdbcTemplate.query(sql, new Object[]{userId}, (rs, rowNum) -> rs.getString("seekPostTitle"));
    }
    
    public SeekerProfileDto findSeekerProfileByUserId(String userId) {
        String sql = "SELECT m.userName, m.userId, m.nickName, m.userType, m.birth, m.tel, " +
                     "COALESCE(s.region, '미정') AS region, " +
                     "COALESCE(s.seekPostTitle, '작성된 구직글이 없습니다') AS seekPostTitle " +
                     "FROM MEMBER m " +
                     "LEFT JOIN JOB_SEEKING s ON m.userId = s.jobseeker_id " +
                     "WHERE m.userId = ? AND m.userType = 'SEEKER'";

        List<SeekerProfileDto> results = jdbcTemplate.query(sql, new Object[]{userId}, (rs, rowNum) -> {
            String regionId = rs.getString("region");
            String mappedRegion = mapRegion(regionId);
            return new SeekerProfileDto(
                    rs.getString("userName"),        // 회원 이름
                    rs.getString("userId"),          // 회원 아이디
                    rs.getString("nickName"),        // 닉네임
                    rs.getString("userType"),        // 회원 구분
                    rs.getString("birth"),           // 생년월일
                    rs.getString("tel"),             // 전화번호
                    mappedRegion,                    // 매핑된 지역명
                    rs.getString("seekPostTitle")    // 구직글 제목
            );
        });

        if (results.isEmpty()) {
            return null;
        }
        return results.get(0);
    }
}