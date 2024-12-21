<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원가입</title>
</head>
<body>
    <h2>회원가입</h2>
    <form action="/register" method="post">
        이름: <input type="text" name="userName" required><br>
        아이디: <input type="text" name="userId" required><br>
        비밀번호: <input type="password" name="userPwd" required><br>
        닉네임: <input type="text" name="nickName"><br>
        회사명: <input type="text" name="comName"><br>
        사용자 타입: 
        <select name="userType">
            <option value="EMPLOYER">EMPLOYER</option>
            <option value="SEEKER">SEEKER</option>
            <option value="MANAGER">MANAGER</option>
        </select><br>
        생년월일: <input type="date" name="birth" required><br>
        전화번호: <input type="text" name="tel" required><br>
        <button type="submit">회원가입</button>
    </form>
    <p style="color: green">${message}</p>
</body>
</html>