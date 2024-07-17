<%--
  Created by IntelliJ IDEA.
  User: WD
  Date: 2024-07-17
  Time: 오전 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        window.onload=function(){
            document.querySelector("#btn_delete").onclick =function (){
                let re =  confirm("정말로 삭제하겠습니까?");
                if(re == false){
                    event.preventDefault();
                    return false;
                }
            }
        }
    </script>
</head>
<body>


<h2>게시물 상세</h2>
<hr>
상품번호 : ${g.no}<br>
상품이름 : ${g.item}<br>
상품가격 : ${g.price}<br>
상품수량 : ${g.qty}<br>
상품파일명 : ${g.fname}<br>
<img src="images/${g.fname}"  height="200" width="200">
<hr>
<a href="listGoods.do">상품목록</a><br>
<%--%bnsp; %bnsp;--%>
<a href="updateGoods.do?no=${g.no}">Goods수정</a><br>
<a id="btn_delete" href="deleteGoods.do?no=${g.no}">Goods삭제</a>
</body>
</html>
