<%@ page import="D0715_mvc.vo.CustomerVO" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: WD
  Date: 2024-07-15
  Time: 오후 12:04
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<html>
<head>
  <title>Title</title>
  <meta charset="UTF-8">
</head>
<body>
    <%=request.getAttribute("msg")%>
    <br>
    ${msg}

  <table border="1" width ="80%">
    <tr>
      <th>고객번호</th>
      <th>고객이름</th>
      <th>주소</th>
      <th>전화</th>
    </tr>
    <c:forEach var="c" items="${list}">
      <tr>
        <td>${c.custid}</td>
        <td><a href="/detailCustomer.do?custid=${c.custid}">${c.name}</a></td>
        <td>${c.address}</td>
        <td>${c.phone}</td>
      </tr>
    </c:forEach>

  </table>
</body>
</html>
