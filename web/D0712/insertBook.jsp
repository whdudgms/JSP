<%--
  Created by IntelliJ IDEA.
  User: WD
  Date: 2024-07-12
  Time: 오전 11:40
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
    <h2>도서등록</h2>
    <hr>
    <form action="/D0712/insertbookOk.jsp" method="post">
        도서번호 : <input type="text" name="bookid"><br>
        도서이름 : <input type="text" name="bookname"><br>
        도서가격 : <input type="text" name="price"><br>
        출판사명 : <input type="text" name="publisher"><br>
        <input type="submit" value="등록">
        <input type="reset" value="다시 입력">
    </form>

</body>
</html>
