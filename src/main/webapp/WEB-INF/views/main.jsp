<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<html>
<head>
    <title>메인 페이지</title>
</head>
<body>
    <h2>메인 페이지</h2>
    <%
        String userName = (String) session.getAttribute("userName");
        String userType = (String) session.getAttribute("userType");
        if (userName != null) { 
    %>
        <p>로그인에 성공하셨습니다, <%= userName %>님!</p>
        <a href="/logout">로그아웃</a>
        <% if ("EMPLOYER".equals(userType)) { %>
            <a href="/employer/profile">내 프로필 보기</a>
            <a href="/seeker/profile">구직자 프로필 보기</a>
        <% } else if ("SEEKER".equals(userType)) { %>
            <a href="/seeker/profile">내 프로필 보기</a>
        <% } %>
    <%
        } else {
    %>
        <p>로그인이 필요합니다.</p>
        <a href="/login">로그인</a>
        <a href="/register">회원가입</a>
    <%
        }
    %>

    <!-- 채용공고 리스트 -->
    <jsp:include page="jobPostingList.jsp" />
    
    <!-- 구직글 리스트  -->
    <jsp:include page="jobSeekingList.jsp" />
</body>
</html>
