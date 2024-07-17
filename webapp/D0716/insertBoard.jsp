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
    <form action="insertBoardOK.do" method="post" enctype="multipart/form-data">
        글제목 ㅣ <input type="text" name="title"><br>
        작성자 ㅣ <input type="text" name="writer" value="${userId}"><br>
        글암호 ㅣ <input type="text" name="pwd"><br>
        글내용 ㅣ <textarea rows="10" cols="60" name="content"></textarea><br>
        파일 ㅣ <input type="file" name="uploadFile"><br>
        <input type="submit" value="등록">
        <input type="reset" value="취소">
    </form>

</body>
</html>
