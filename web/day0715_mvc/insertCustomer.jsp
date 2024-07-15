<%--
  Created by IntelliJ IDEA.
  User: WD
  Date: 2024-07-15
  Time: 오후 2:03
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
<form action="/insertCustomerOK.do" method="post">
    custid<input type="text" name="custid"><br>
    name <input type="text" name="name"><br>
    address<input type="text" name="address"><br>
    phone<input type="text" name="phone"><br>
    <input type="submit" value="등록">
    <input type="reset" value="다시입력">
</form>
</body>
</html>
