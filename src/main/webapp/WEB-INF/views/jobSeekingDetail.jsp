<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>구직글 상세 페이지</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        h4 { margin: 10px 0; }
        .error { color: red; }
    </style>
</head>
<body>
    <h1>구직글 상세 페이지</h1>

    <!-- 에러 메시지 출력 -->
    <c:if test="${error != null}">
        <div class="error">${error}</div>
    </c:if>

    <!-- 구직글 상세 정보 출력 -->
    <h4 class="seekPostTitle">제목: ${job.seekPostTitle}</h4>
    <h4 class="nickName">닉네임: ${nickName}</h4>
    <h4 class="wPeriod">희망 근무기간: ${job.wPeriod}</h4>
    <h4 class="region">희망 지역: ${job.region}</h4>
    <h4 class="jobType">희망 업종: ${job.jobType}</h4>
</body>
</html>
