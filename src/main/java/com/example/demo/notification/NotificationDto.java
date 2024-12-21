package com.example.demo.notification;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotificationDto {
    private String scoutCompanyName;   // 업주 회사명
    private String notificationMessage; // 스카우트 메시지
    
    // Constructor
    public NotificationDto(String scoutCompanyName, String notificationMessage) {
        this.scoutCompanyName = scoutCompanyName;
        this.notificationMessage = notificationMessage;
    }
    
    // Getter Setter
	public String getScoutCompanyName() {
		return scoutCompanyName;
	}
	public void setScoutCompanyName(String scoutCompanyName) {
		this.scoutCompanyName = scoutCompanyName;
	}
	public String getNotificationMessage() {
		return notificationMessage;
	}
	public void setNotificationMessage(String notificationMessage) {
		this.notificationMessage = notificationMessage;
	}
}