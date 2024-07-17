<%--
  Created by IntelliJ IDEA.
  User: WD
  Date: 2024-07-17
  Time: 오전 10:24
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
    <c:if test="${re>0}">
        상품등록 성공
    </c:if>
    <hr>
    <c:if test="${re<=0}">
        상품등록 실패
    </c:if>
    <hr>

    <a href="insertGoods.do">상품등록</a>
    <a href="listGoods.do">상품리스트</a>>

</body>
</html>
