<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>채용공고 상세 페이지</title>
<style>
body {
	font-family: Arial, sans-serif;
	margin: 20px;
}

h4 {
	margin: 10px 0;
}

.error {
	color: red;
}

.success {
	color: green;
}
</style>
<script>
    document.addEventListener("DOMContentLoaded", function () {
        document.getElementById("ratingForm").addEventListener("submit", function (e) {
            const rating = document.getElementById("rating").value;
            if (rating < 1 || rating > 5) {
                e.preventDefault();
                alert("평점은 1과 5 사이의 값이어야 합니다.");
            }
        });
    });
</script>
<script>
window.onload = async function() {
    try {
        const response = await fetch('/member/companyName');
        if (response.ok) {
            const companyName = await response.text();
            document.getElementById('comName').value = companyName;
        } else {
            console.warn('회사명을 불러오는 중 문제가 발생했습니다.');
            document.getElementById('comName').value = '회사명을 불러올 수 없음';
        }
    } catch (error) {
        console.error('Error fetching company name:', error);
        document.getElementById('comName').value = '네트워크 오류';
    }
};
</script>
</head>
<body>
	<h1>채용공고 상세 페이지</h1>

	<!-- 에러 메시지 출력 -->
	<c:if test="${error != null}">
		<div class="error">${error}</div>
	</c:if>

	<!-- 성공 메시지 출력 -->
	<c:if test="${message != null}">
		<div class="success">${message}</div>
	</c:if>

	<!-- 채용공고 상세 정보 출력 -->
	<h4 class="employPostTitle">제목: ${job.employPostTitle}</h4>
	<h4 class="comName">회사명: ${job.comName}</h4>
	<h4 class="rate">평점: ${job.rate}</h4>
	<!--  <h4 class="rateCnt">평점 수: ${job.rateCnt}</h4>
    <h4 class="rateSum">평점 총합: ${job.rateSum}</h4>  -->

	<!-- 평점 입력 폼 -->
	<form id="ratingForm" action="/jobPosting/rate" method="post">
		<label for="rating">평점을 입력하세요 (1~5): </label> <input type="number"
			id="rating" name="rating" min="1" max="5" required> <input
			type="hidden" name="employPostNo" value="${job.employPostNo}">
		<button type="submit">평점 제출</button>
	</form>


	<h4 class="salary">월급: ${job.salary}</h4>
	<h4 class="wPeriod">근무기간: ${job.wPeriod}</h4>
	<h4 class="region">지역: ${job.region}</h4>

	<h4 class="jobType">업종: ${job.jobType}</h4>
	<h4 class="employPostDetail">상세 내용: ${job.employPostDetail}</h4>

	<!-- 타임테이블 섹션 -->
	<h3>타임테이블</h3>
	<jsp:include page="timetable.jsp" />
	
	</form>
	</form>
</body>
</html>
