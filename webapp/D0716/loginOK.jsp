<%--
  Created by IntelliJ IDEA.
  User: WD
  Date: 2024-07-16
  Time: 오전 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>loginOkK</title>
    <meta charset="UTF-8">
</head>
<body>
<%
System.out.println(request.getAttribute("re"));
    %>
    <c:if test="${re == 1}">
        "${userId}"
        님    로그인이 되었습니다.
    </c:if>
    <c:if test="${re == 0}">
        암호가 잘못되었습니다.
    </c:if>
    <c:if test="${re == -1}">
        존재하지 않는 아이디 입니다.
    </c:if>

</body>
</html>
