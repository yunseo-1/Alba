package com.example.demo.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NotificationRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void saveNotification(String scoutCompanyName, String notificationMessage, String receiverId) {
        String sql = "INSERT INTO NOTIFICATION (scout_company_name, notification_message, receiver_id) " +
                     "VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, scoutCompanyName, notificationMessage, receiverId);
    }

    public List<NotificationDto> findNotificationsByReceiverId(String receiverId) {
        String sql = "SELECT scout_company_name, notification_message " +
                     "FROM NOTIFICATION WHERE receiver_id = ?";
        return jdbcTemplate.query(sql, new Object[]{receiverId}, (rs, rowNum) ->
                new NotificationDto(
                        rs.getString("scout_company_name"),
                        rs.getString("notification_message")
                ));
    }
}