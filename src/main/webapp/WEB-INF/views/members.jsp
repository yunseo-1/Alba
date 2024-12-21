<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 정보 관리</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 0; padding: 0; }
        header { background-color: #333; color: white; text-align: center; padding: 10px 0; }
        nav { background-color: #f4f4f4; padding: 10px; text-align: center; }
        nav a { margin: 0 15px; text-decoration: none; color: #333; font-weight: bold; }
        .container { padding: 20px; }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        table, th, td { border: 1px solid #ddd; }
        th, td { padding: 10px; text-align: center; }
        th { background-color: #f4f4f4; }
    </style>
</head>
<body>

<header>
    <h1><a href="/admin" style="text-decoration: none; color: inherit;">관리자 페이지</a></h1>
</header>

<nav>
    <a href="/recruitments">채용공고 관리</a>
    <a href="/jobSeekers">구직글 관리</a>
    <a href="/members">회원 정보 관리</a>
</nav>

<div class="container">
    <h3>회원 정보 관리</h3>
    <form action="/members/delete" method="post">
        <table>
            <thead>
                <tr>
                    <th>선택</th>
                    <th>회원 ID</th>
                    <th>닉네임 / 회사명</th>
                    <th>연락처</th>
                    <th>가입일</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="member" items="${members}">
                    <tr>
                        <td><input type="checkbox" name="selectedIds" value="${member.userId}" /></td>
                        <td><c:out value="${member.userId}" /></td>
                        <td><c:out value="${member.displayName}" /></td>
                        <td><c:out value="${member.tel}" /></td>
                        <td><c:out value="${member.signDate}" /></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <button type="submit" style="margin-top: 10px;">선택 삭제</button>
    </form>
</div>

</body>
</html>