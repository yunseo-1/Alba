<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>채용공고 등록</title>
<style>
body {
	font-family: Arial, sans-serif;
	margin: 20px;
}

form {
	max-width: 600px;
	margin: 0 auto;
}

label {
	display: block;
	margin: 10px 0 5px;
}

input, textarea, select {
	width: 100%;
	padding: 8px;
	margin-bottom: 15px;
}

button {
	padding: 10px 20px;
	background-color: #007BFF;
	color: #FFF;
	border: none;
	cursor: pointer;
}

button:hover {
	background-color: #0056b3;
}

.table-container {
	display: flex;
	justify-content: center;
	margin-top: 20px;
}

table {
	border-collapse: collapse;
	width: 80%;
	margin: 0 auto;
}

th, td {
	border: 1px solid #ddd;
	padding: 8px;
	text-align: center;
}

th {
	background-color: #f2f2f2;
}
</style>
</head>
<body>
	<h1>채용공고 등록</h1>
	<form action="jobPosting" method="post">
		<!-- 제목 입력 -->
		<label for="employPostTitle">제목</label> 
		<input type="text" name="employPostTitle" maxlength="255" required>

		<!-- 일할 수 있는 기간 입력 -->
		<label for="wPeriod">일할 수 있는 기간</label> 
		<input type="text" name="wPeriod" required>

		<!-- 지역 입력 -->
		<label for="region">지역</label> 
		<input type="text" name="region" maxlength="100" required>

		<!-- 업종 입력 -->
		<label for="jobType">업종</label> 
		<input type="text" name="jobType" maxlength="100" required>

		<!-- 급여 입력 -->
		<label for="salary">급여</label> 
		<input type="number" name="salary" placeholder="숫자만 입력" required>

		<!-- 상세내용 입력 -->
		<label for="employPostDetail">상세내용</label>
		<textarea name="employPostDetail" rows="10" maxlength="1000" placeholder="상세내용을 입력하세요"></textarea>

		<!-- 등록 버튼 -->
		<button type="submit">등록</button>
	</form>

	<h2>타임테이블</h2>
	<form id="timeTableForm" method="post">
		<!-- 요일 입력 -->
		<label for="dayOfWeek">요일:</label> 
		<select id="dayOfWeek" name="dayOfWeek">
			<option value="MON">월요일</option>
			<option value="TUE">화요일</option>
			<option value="WED">수요일</option>
			<option value="THU">목요일</option>
			<option value="FRI">금요일</option>
			<option value="SAT">토요일</option>
			<option value="SUN">일요일</option>
		</select>

		<!-- 시간 입력 -->
		<label for="timeStart">시작 시간:</label> 
		<input type="time" id="timeStart" name="timeStart" required> 
		<label for="timeEnd">종료 시간:</label> 
		<input type="time" id="timeEnd" name="timeEnd" required>

		<!-- 저장 버튼 -->
		<button type="button" id="saveTimeTable">저장</button>
	</form>

	<div class="table-container">
		<table>
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
	</div>

	<script>
		document.querySelector('#saveTimeTable').addEventListener('click', async function() {
			const form = document.querySelector('#timeTableForm');
			const formData = new FormData(form);
			const response = await fetch('/timetable/add2', {
				method: 'POST',
				body: formData
			});

			if (response.ok) {
				alert('타임테이블이 저장되었습니다.');
				// 추가 작업: 필요시 테이블 업데이트
			} else {
				alert('저장 중 오류가 발생했습니다.');
			}
		});
	</script>
</body>
</html>
