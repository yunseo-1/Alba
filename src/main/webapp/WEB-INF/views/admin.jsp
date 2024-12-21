<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 페이지</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 0; padding: 0; }
        header { background-color: #333; color: white; text-align: center; padding: 10px; }
        nav { background-color: #f4f4f4; padding: 10px; text-align: center; }
        nav a { margin: 0 15px; text-decoration: none; color: #333; font-weight: bold; }
        .container { padding: 20px; }
        h3 { margin-bottom: 20px; }
        .buttons { display: flex; justify-content: space-evenly; margin-top: 20px; }
        .buttons a { padding: 10px 20px; background-color: #333; color: white; text-decoration: none; border-radius: 5px; }
        .buttons a:hover { background-color: #555; }
    </style>
</head>
<body>

<header>
    <h1>관리자 페이지</h1>
</header>

<div class="container">
    <h3>관리 기능</h3>
    <div class="buttons">
        <a href="/recruitments">채용공고 관리</a>
        <a href="/jobSeekers">구직글 관리</a>
        <a href="/members">회원 정보 관리</a>
    </div>
</div>

</body>
</html>
