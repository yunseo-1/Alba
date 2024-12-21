package com.example.demo.timetable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeTableRepository extends JpaRepository<TimeTable, Integer> {
    List<TimeTable> findByUserId(String userId);
    List<TimeTable> findByUserIdAndDayOfWeek(String userId, TimeTable.DayOfWeek dayOfWeek);
}
