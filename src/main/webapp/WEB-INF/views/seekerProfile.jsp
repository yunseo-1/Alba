<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>구직자 프로필</title>
</head>
<body>
    <h2>구직자 프로필</h2>
    <p>이름: ${profile.userName}</p>
    <p>닉네임: ${profile.nickName}</p>
    <p>유형: ${profile.userType}</p>
    <p>생년월일: ${profile.birth}</p>
    <p>전화번호: ${profile.tel}</p>
    <p>지역: ${profile.region}</p>
     <h3>작성한 구직글 목록</h3>
    <ul>
        <c:forEach var="title" items="${jobSeekingTitles}">
            <li>${title}</li>
        </c:forEach>
    </ul>

    <!-- 타임테이블 섹션 -->
    <h3>타임테이블</h3>
    <jsp:include page="timetable.jsp" /> 

    <!-- 업주로 로그인한 경우 -->
    <c:if test="${isEmployer}">
        <h3>스카우트</h3>
        <form action="/seeker/scout" method="post">
            <input type="hidden" name="receiverId" value="${receiverId}" />
            <label for="message">스카우트 메시지:</label><br>
            <textarea id="message" name="message" required></textarea><br>
            <button type="submit">스카우트</button>
        </form>
    </c:if>

    <!-- 구직자로 로그인한 경우 -->
    <c:if test="${!isEmployer}">
        <h3>스카우트 알림</h3>
        <ul>
            <c:forEach var="notification" items="${notifications}">
                <li>회사명: ${notification.scoutCompanyName}, 메시지: ${notification.notificationMessage}</li>
            </c:forEach>
        </ul>
    </c:if>

    <a href="/main">메인으로 돌아가기</a>
</body>
</html>
