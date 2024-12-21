<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인</title>
</head>
<body>
    <h2>로그인</h2>
    <form action="/login" method="post">
        아이디: <input type="text" name="userId" required><br>
        비밀번호: <input type="password" name="userPwd" required><br>
        <button type="submit">로그인</button>
    </form>
    <p style="color: red">${error}</p>
    <a href="/register">회원가입</a>
</body>
</html>