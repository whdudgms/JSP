<%--
  Created by IntelliJ IDEA.
  User: WD
  Date: 2024-07-16
  Time: 오전 10:11
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

<c:if test="${re == 1}">
    회원가입 성공 되었습니다.
    <a href="login.do">로그인으로 이동 ^^</a>
</c:if>

<c:if test="${re == 0}">
    회원가입 잘못되었습니다.
</c:if>

</body>
</html>