<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>타임테이블</title>
    <style>
        .highlight { background-color: yellow; }
    </style>
    <script>
        async function fetchTimetables() {
            const response = await fetch('/timetable/list');
            if (response.ok) {
                const timetables = await response.json();
                timetables.forEach(t => {
                    const days = {"MON": 1, "TUE": 2, "WED": 3, "THU": 4, "FRI": 5, "SAT": 6, "SUN": 7};
                    const column = days[t.dayOfWeek];
                    const startHour = parseInt(t.timeStart.split(':')[0]);
                    const endHour = parseInt(t.timeEnd.split(':')[0]);
                    for (let i = startHour; i < endHour; i++) {
                        const cell = document.getElementById(`${i}-${column}`);
                        if (cell) cell.classList.add("highlight");
                    }
                });
            }
        }
        fetchTimetables();
    </script>
</head>
<body>
<h2>타임테이블</h2>

<form action="/timetable/add" method="post">
    <label for="dayOfWeek">요일:</label>
    <select id="dayOfWeek" name="dayOfWeek">
        <option value="MON">월요일</option>
        <option value="TUE">화요일</option>
        <option value="WED">수요일</option>
        <option value="THU">목요일</option>
        <option value="FRI">금요일</option>
        <option value="SAT">토요일</option>
        <option value="SUN">일요일</option>
    </select><br>

    <label for="timeStart">시작 시간:</label>
    <input type="time" id="timeStart" name="timeStart" required><br>

    <label for="timeEnd">종료 시간:</label>
    <input type="time" id="timeEnd" name="timeEnd" required><br>

    <button type="submit">저장</button>
</form>

<table border="1">
    <thead>
        <tr>
            <th>시간</th>
            <th>월</th>
            <th>화</th>
            <th>수</th>
            <th>목</th>
            <th>금</th>
            <th>토</th>
            <th>일</th>
        </tr>
    </thead>
    <tbody>
        <script>
            for (let i = 0; i < 24; i++) {
                document.write(`<tr>
                    <td>${i.toString().padStart(2, '0')}:00</td>
                    <td id='${i}-1'></td>
                    <td id='${i}-2'></td>
                    <td id='${i}-3'></td>
                    <td id='${i}-4'></td>
                    <td id='${i}-5'></td>
                    <td id='${i}-6'></td>
                    <td id='${i}-7'></td>
                </tr>`);
            }
        </script>
    </tbody>
</table>
<script>
    async function compareTimeTables(receiverId) {
        const response = await fetch('/timetable/compare', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            body: new URLSearchParams({
                'receiverId': receiverId
            })
        });

        if (response.ok) {
            const commonTimes = await response.json();
            const resultContainer = document.getElementById("comparisonResult");
            resultContainer.innerHTML = ""; // 기존 결과 초기화

            if (commonTimes.length > 0) {
                resultContainer.innerHTML += "<h3>공통 시간대:</h3><ul>";
                commonTimes.forEach(time => {
                    resultContainer.innerHTML += `<li>${time.dayOfWeek}: ${time.timeStart} - ${time.timeEnd}</li>`;
                });
                resultContainer.innerHTML += "</ul>";
            } else {
                resultContainer.innerHTML = "<p>공통 시간대가 없습니다.</p>";
            }
        } else {
            alert("타임테이블 비교에 실패했습니다.");
        }
    }
</script>

<!-- 비교하기 버튼 -->
<button onclick="compareTimeTables('${receiverId}')">비교하기</button>

<!-- 결과 표시 영역 -->
<div id="comparisonResult"></div>

<a href="/main">메인으로 돌아가기</a>
</body>
</html>
