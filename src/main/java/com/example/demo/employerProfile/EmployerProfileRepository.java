package com.example.demo.employerProfile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployerProfileRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public EmployerProfileDto findEmployerProfileByUserId(String userId) {
        // SQL 쿼리: COALESCE를 사용해 NULL 값을 기본값으로 대체
        String sql = "SELECT m.userName, m.comName, m.userType, m.birth, m.tel, " +
                     "COALESCE(j.rate, 0.0) AS rate, COALESCE(j.region, '미정') AS region " +
                     "FROM MEMBER m " +
                     "LEFT JOIN JOB_POSTING j ON m.userId = j.employer_id " +
                     "WHERE m.userId = ?";

        // JdbcTemplate을 사용해 쿼리 실행 및 결과 매핑
        List<EmployerProfileDto> results = jdbcTemplate.query(sql, new Object[]{userId}, (rs, rowNum) ->
                new EmployerProfileDto(
                        rs.getString("userName"),                     // 사용자 이름
                        rs.getString("comName"),                      // 회사명
                        rs.getString("userType"),                     // 사용자 유형
                        rs.getString("birth"),                        // 생년월일
                        rs.getString("tel"),                          // 전화번호
                        rs.getBigDecimal("rate") != null 
                                ? rs.getBigDecimal("rate").doubleValue() // BigDecimal → Double 변환
                                : 0.0,                                 // NULL 값 처리 시 기본값 0.0
                        rs.getString("region")                        // 지역
                ));

        // 결과가 없을 경우 null 반환
        if (results.isEmpty()) {
            return null;
        }

        // 첫 번째 결과 반환
        return results.get(0);
    }
    
    public List<String> findJobPostTitlesByEmployerId(String userId) {
        String sql = "SELECT employPostTitle FROM JOB_POSTING WHERE employer_id = ?";
        return jdbcTemplate.query(sql, new Object[]{userId}, (rs, rowNum) -> rs.getString("employPostTitle"));
    }
}