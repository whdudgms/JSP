<%--
  Created by IntelliJ IDEA.
  User: WD
  Date: 2024-07-12
  Time: 오후 2:41
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
<form action="/D0712/insertDeptOK.jsp" method="post">
    부서번호 : <input type="text" name="dno"><br>
    부서이름 : <input type="text" name="dname"><br>
    부서위치 : <input type="text" name="loc"><br>
    <input type="submit" value="전송"><br>
     <input type="reset" value="취소">
</form>

</body>
</html>
