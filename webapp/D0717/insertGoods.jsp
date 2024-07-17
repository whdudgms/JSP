<%--
  Created by IntelliJ IDEA.
  User: WD
  Date: 2024-07-17
  Time: 오전 10:21
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
    <h2>입력</h2>
    <hr>
    <form action="insertGoodsOK.do" method="post" enctype="multipart/form-data">
        상품이름 : <input type="text" name="item"><br>
        상품가격 : <input type="text" name="price"><br>
        상품수량 : <input type="text" name="qty"><br>
        상품사진 : <input type="file" name="uploadFile"><br>
        <input type="submit" value="등록">
        <input type="reset" value="다시입력">
    </form>

</body>
</html>
