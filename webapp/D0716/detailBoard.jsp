<%--
  Created by IntelliJ IDEA.
  User: WD
  Date: 2024-07-16
  Time: 오후 12:19
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
    <h2>게시물 상세</h2>
    <hr>
    글번호 : ${b.no}<br>
    글제목 : ${b.title}<br>
    작성자 : ${b.writer}<br>
    글내용 : <textarea readonly="readonly" rows="10" cols="60">${b.content}</textarea><br>
    등록일 : ${b.regdate}<br>



    <c:if test="${isImg == 'yes'}">
    <img src="upload/${b.fname}" width="200" height="200">
    </c:if>
    <c:if test="${isImg != 'yes'}">
        이미지는 아님
        <a href="upload.${b.fname}">${b.fname} ${b.fsize}</a>
    </c:if>

    hit : ${b.hit}<br>
    <hr>
    <a href="updateBoard.do?no=${b.no}">수정</a>
    %bnsp; %bnsp;
    <a href="deleteBoard.do?no=${b.no}">삭제</a>

</body>
</html>
