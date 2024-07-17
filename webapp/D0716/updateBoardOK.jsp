<%--
  Created by IntelliJ IDEA.
  User: WD
  Date: 2024-07-16
  Time: 오전 11:32
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
        게시물을 수정하였습니다.
    </c:if>
    <c:if test="${re<=0}">
        게시물을 수정에 실패하였습니다.
    </c:if>
    <hr>
    <a href="listBoard.do">리스트로 이동</a>
    
</body>
</html>
