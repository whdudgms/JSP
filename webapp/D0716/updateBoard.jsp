<%--
  Created by IntelliJ IDEA.
  User: WD
  Date: 2024-07-16
  Time: 오전 11:32
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
    <h2>게시물 등록</h2>
    <hr>
    <form action="updateBoardOK.do" method="post" enctype="multipart/form-data">
        <input type="hidden" name="no" value="${b.no}">
        글제목 ㅣ <input type="text" name="title" value="${b.title}"><br>
        작성자 ㅣ ${b.writer}<br>
        <input type="hidden"  type="text" name="pwd" value="${b.pwd}"><br>
        글내용 ㅣ <textarea rows="10" cols="60" name="content" value="${b.content}"></textarea><br>
        <c:if text="${isImg == 'yes'}">
            <img src="upload"${b.fname} width="50" height="50">
        </c:if>

        <c:if text="${isImg != 'yes'}">
           참부파일 ${b.fname}
        </c:if>
        <input type="hidden" name="fname" value="${b.fname}">
        <input type="hidden" name="fsize" value="${b.fsize}">

        첨부파일 : <input type="file" name="uploadFile">
        <input type="submit" value="등록">
        <input type="reset" value="취소">
    </form>

</body>
</html>
