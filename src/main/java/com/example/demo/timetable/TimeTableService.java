package com.example.demo.timetable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TimeTableService {

    @Autowired
    private TimeTableRepository timeTableRepository;

    public void addTimeTable(String userId, TimeTableDto timeTableDto) {
        TimeTable timeTable = new TimeTable();
        timeTable.setUserId(userId);
        timeTable.setDayOfWeek(TimeTable.DayOfWeek.valueOf(timeTableDto.getDayOfWeek()));
        timeTable.setTimeStart(timeTableDto.getTimeStart());
        timeTable.setTimeEnd(timeTableDto.getTimeEnd());
        timeTableRepository.save(timeTable);
    }
    
    /*
     * JobPosting.jsp에서 사용될 경우
     * 
     * */

    public List<TimeTableDto> getTimeTableByUserId(String userId) {
        List<TimeTableDto> timeTables = timeTableRepository.findByUserId(userId).stream()
                .map(t -> new TimeTableDto(
                        t.getDayOfWeek().name(), // 요일 (DayOfWeek enum → String 변환)
                        t.getTimeStart(),        // 시작 시간
                        t.getTimeEnd()))         // 종료 시간
                .collect(Collectors.toList()); // DTO 리스트로 변환

        // 반환 데이터를 콘솔로 확인
        System.out.println("UserId: " + userId);
        System.out.println("이 유저 아이디의 TimeTables: ");
        timeTables.forEach(t -> System.out.println(
                "DayOfWeek: " + t.getDayOfWeek() +
                ", TimeStart: " + t.getTimeStart() +
                ", TimeEnd: " + t.getTimeEnd()
        ));

        return timeTables;
    }
    
    // 고용주와 구직자의 타임테이블 비교
    public List<TimeTableDto> compareTimeTables(String employerId, String seekerId) {
        List<TimeTableDto> commonTimes = new ArrayList<>();

        // 고용주와 구직자의 모든 타임테이블 데이터를 가져옴
        List<TimeTable> employerTimes = timeTableRepository.findByUserId(employerId);
        List<TimeTable> seekerTimes = timeTableRepository.findByUserId(seekerId);

        // 두 타임테이블 데이터를 비교
        for (TimeTable employerTime : employerTimes) {
            for (TimeTable seekerTime : seekerTimes) {
                if (employerTime.getDayOfWeek().equals(seekerTime.getDayOfWeek())) {
                    // 동일한 요일인 경우 시간대 비교
                    String commonStart = max(employerTime.getTimeStart(), seekerTime.getTimeStart());
                    String commonEnd = min(employerTime.getTimeEnd(), seekerTime.getTimeEnd());

                    // 겹치는 시간이 있으면 추가
                    if (commonStart.compareTo(commonEnd) < 0) {
                    	TimeTableDto commonTime = new TimeTableDto(
                                employerTime.getDayOfWeek().name(),
                                commonStart,
                                commonEnd
                        );
                        commonTimes.add(commonTime);

                        // System.out.println으로 출력
                        System.out.println("공통 시간대 발견: " + commonTime.getDayOfWeek() +
                                " " + commonTime.getTimeStart() + " - " + commonTime.getTimeEnd());
                    }
                }
            }
        }

        if (commonTimes.isEmpty()) {
            System.out.println("공통 시간대가 없습니다.");
        }

        return commonTimes;
    }

    // 시간 비교 유틸리티 메서드
    private String max(String time1, String time2) {
        return time1.compareTo(time2) > 0 ? time1 : time2;
    }

    private String min(String time1, String time2) {
        return time1.compareTo(time2) < 0 ? time1 : time2;
    }
}
