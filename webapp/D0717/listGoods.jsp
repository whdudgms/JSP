<%--
  Created by IntelliJ IDEA.
  User: WD
  Date: 2024-07-17
  Time: 오전 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
</head>
<body>
<a href="insertGoods.do">상품등록</a>
<table border="1" width="80%">
    <tr>
        <th>상품번호</th>
        <th>이름</th>
        <th>가격</th>
        <th>수량</th>
        <th>파일명</th>
    </tr>
    <c:forEach var ="g" items="${list}">
        <tr>
            <td>${g.no}</td>
            <td><a href="detailGoods.do?no=${g.no}">${g.item}</a></td>
            <td>${g.price}</td>
            <td>${g.qty}</td>
            <td>${g.fname}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
