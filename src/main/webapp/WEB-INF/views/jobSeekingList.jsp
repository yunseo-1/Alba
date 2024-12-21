<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">
<title>구직글 리스트</title>
</head>
<body>
	<div class="container w-75 mt-5 mx-auto">
		<h2>구직글 목록</h2>
		<hr>

		<!-- 구직글 리스트 출력 -->
		<ul class="list-group">
			<c:forEach var="job" items="${seekingList}" varStatus="status">
				<li
					class="list-group-item d-flex justify-content-between align-items-center">
					<div>[${status.count}] ${job.seekPostTitle}</div> 
					<!-- 보기 버튼 -->
					<a
					href="${pageContext.request.contextPath}/jobSeeking/Detail?id=${job.seekPostNo}"
					class="btn btn-primary btn-sm"> 보기 </a>

				</li>
			</c:forEach>
		</ul>

		<!-- 에러 메시지 출력 -->
		<c:if test="${error != null}">
			<div class="alert alert-danger mt-3" role="alert">${error}</div>
		</c:if>
	</div>
</body>
</html>
