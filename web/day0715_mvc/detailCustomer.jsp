<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
</head>
<body>
${customer.custid}<br>
${customer.name}<br>
${customer.address}<br>
${customer.phone}<br>


<a href="/updateCustomer.do?custid=${customer.custid}">수정</a>
<a href="/deleteCustomer.do?custid=${customer.custid}">삭제</a>

</body>
</html>
