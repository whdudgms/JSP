<%--
  Created by IntelliJ IDEA.
  User: WD
  Date: 2024-07-16
  Time: 오후 2:30
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
<form action="deleteBoardOK.do" method="post">
    <input type="hidden" name="no" value="${no}">
    글 암호 : <input type="password" name="pwd">
    <input type="submit" value="삭제">
    <input type="reset" value="다시입력">
</form>
</body>
</html>
