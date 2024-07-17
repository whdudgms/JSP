<%--
  Created by IntelliJ IDEA.
  User: WD
  Date: 2024-07-16
  Time: 오전 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
</head>
<body>
        <h2>로그인</h2>
        <hr>
        <form action="loginOK.do" method="post">
            아이디 :  <input type="text" name="id"><br>
            암호 :    <input type="text" name="pwd"><br>
            <input type="submit" value="로그인">
            <input type="reset" value="초기화">
        </form>
</body>
</html>
