<%--
  Created by IntelliJ IDEA.
  User: WD
  Date: 2024-07-16
  Time: 오후 12:06
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
        <h2>게시물등록</h2>
        <hr>
        <table>
            <tr>
                <th>글번호</th>
                <th>글제목</th>
                <th>작성자</th>
                <th>등록일</th>
            </tr>
            <c:forEach var ="b" items="${list}">
                <tr>
                    <td><a href="detailBoard.do?no=${b.no}">${b.no}</a></td>
                    <td>${b.title}</td>
                    <td>${b.writer}</td>
                    <td>${b.regdate}</td>
                    <td>${b.fname}</td>
                    <td>${b.fsize}</td>
                </tr>
            </c:forEach>
        </table>
</body>
</html>
