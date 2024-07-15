<%--
  Created by IntelliJ IDEA.
  User: WD
  Date: 2024-07-15
  Time: 오전 10:16
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
    <h2>고객등록</h2>
    <hr>
    <form action="insertCustomerOk.jsp" method="post">
        고객번호 : <input type="text" name="custid"><br>
        고객이름 : <input type="text" name="name"><br>
        고객주소 : <input type="text" name="address"><br>
        고객전화 : <input type="text" name="phone"><br>
        <input type="submit" value="등록">
        <input type="reset" value="취소">
    </form>
</body>
</html>
