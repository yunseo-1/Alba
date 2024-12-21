<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>업주 프로필</title>
</head>
<body>
    <h2>업주 프로필</h2>
    <p>이름: ${profile.userName}</p>
    <p>회사명: ${profile.comName}</p>
    <p>유형: ${profile.userType}</p>
    <p>생년월일: ${profile.birth}</p>
    <p>전화번호: ${profile.tel}</p>
    <p>평점: ${profile.rate}</p>
    <p>지역: ${profile.region}</p>

    <h3>본인이 작성한 게시글 목록</h3>
    <ul>
        <c:forEach var="title" items="${jobPostTitles}">
            <li>${title}</li>
        </c:forEach>
    </ul>

    <a href="/main">메인으로 돌아가기</a>
</body>
</html>