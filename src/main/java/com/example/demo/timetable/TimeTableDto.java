package com.example.demo.timetable;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TimeTableDto {
    private String dayOfWeek;  // 요일
    private String timeStart; // 시작 시간
    private String timeEnd;   // 종료 시간
	public String getDayOfWeek() {
		return dayOfWeek;
	}
	
	// Constructor
	public TimeTableDto(String dayOfWeek, String timeStart, String timeEnd) {
        this.dayOfWeek = dayOfWeek;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
    }
	
	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	public String getTimeStart() {
		return timeStart;
	}
	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}
	public String getTimeEnd() {
		return timeEnd;
	}
	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}
}
