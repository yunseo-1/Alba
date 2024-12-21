package com.example.demo.timetable;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TIMETABLE")
public class TimeTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "time_id")  // 실제 데이터베이스 컬럼 이름
    private Integer timeId;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Enumerated(EnumType.STRING)
    @Column(name = "day_of_week", nullable = false)
    private DayOfWeek dayOfWeek;

    @Column(name = "time_start", nullable = false)
    private String timeStart;

    @Column(name = "time_end", nullable = false)
    private String timeEnd;

    public enum DayOfWeek {
        MON, TUE, WED, THU, FRI, SAT, SUN
    }

    // 직접 정의된 Getter/Setter
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
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