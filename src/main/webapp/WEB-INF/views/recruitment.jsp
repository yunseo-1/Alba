<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>채용공고 관리</title>
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
    <form action="/recruitments/delete" method="post">
        <table>
            <thead>
                <tr>
                    <th>선택</th>
                    <th>채용공고 번호</th>
                    <th>채용공고 제목</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="recruitment" items="${recruitments}">
                    <tr>
                        <td><input type="checkbox" name="selectedIds" value="${recruitment.employPostNo}" /></td>
                        <td>${recruitment.employPostNo}</td>
                        <td>${recruitment.employPostTitle}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <button type="submit">선택 삭제</button>
    </form>
</div>

