package com.example.demo.notification;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public void sendNotification(String scoutCompanyName, String notificationMessage, String receiverId) {
        notificationRepository.saveNotification(scoutCompanyName, notificationMessage, receiverId);
    }

    public List<NotificationDto> getNotificationsByReceiverId(String receiverId) {
        return notificationRepository.findNotificationsByReceiverId(receiverId);
    }
}