<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>메인 페이지</title>
<style>
body {
	font-family: 'Arial', sans-serif;
}

.header {
	display: flex;
	justify-content: space-between;
	align-items: center;
	padding: 10px 20px;
	background-color: #f0f0f0;
}

.header a {
	text-decoration: none;
	margin: 0 10px;
}

.main-content {
	text-align: center;
	margin-top: 50px;
}

.job-listing {
	width: 80%;
	margin: 20px auto;
	border-collapse: collapse;
}

.job-listing th, .job-listing td {
	border: 1px solid #ddd;
	padding: 10px;
}

.job-listing th {
	background-color: #f2f2f2;
}

.footer {
	margin-top: 30px;
	text-align: center;
	padding: 10px 0;
	background-color: #f0f0f0;
}
</style>
</head>
<body>
	<!-- 상단 네비게이션 -->
	<div class="header">
		<div>
			<a href="/login">로그인</a> | <a href="/register">회원가입</a>
		</div>
		<div>
			<a href="/scout">스카우트 알림</a> | <a href="/mypage">마이페이지</a>
		</div>
	</div>

	<!-- 메인 섹션 -->
	<div class="main-content">
		<h1>채용공고</h1>
		<form action="/filter" method="get">
			<label>지역:</label> <input type="text" name="region"> <label>직종:</label>
			<input type="text" name="jobType"> <label>근무 기간:</label> <input
				type="text" name="wPeriod">
			<button type="submit">검색</button>
		</form>


		<!-- 채용 공고 리스트 -->
		<table class="job-listing">
			<tr>
				<th>채용공고 제목</th>
				<th>회사명</th>
				<th>월급</th>
				<th>근무 지역</th>
			</tr>
			<c:forEach var="job" items="${jobs}">
				<tr>
					<td>${job.employPostTitle}</td>
					<td>${job.comName}</td>
					<td>${job.salary}</td>
					<td>${job.region}</td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<!-- 푸터 -->
	<div class="footer">
		<p>© 알바 24</p>
	</div>
</body>
</html>
