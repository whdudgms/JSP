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
<h2>고객수정 </h2>
<hr>
<form action="/updateCustomerOK.do" method="post">
    custid<span>${c.custid}</span> <input type="hidden" name="custid" value="${c.custid}"><br>
    name <input type="text" name="name" value="${c.name}"><br>
    address<input type="text" name="address" value="${c.address}"><br>
    phone<input type="text" name="phone" value="${c.phone}"><br>
    <input type="submit" value="수정">
    <input type="reset" value="다시입력">
</form>
</body>
</html>
