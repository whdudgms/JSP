<%@ page import="D0715_mvc.vo.CustomerVO" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: WD
  Date: 2024-07-15
  Time: 오후 12:04
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

<%
  ArrayList<CustomerVO> list = (ArrayList<CustomerVO>) request.getAttribute("list");
%>


<h2>고객 목록</h2>
<hr>
<table border="1" width="80%">
  <tr>
    <td>고객번호</td>
    <td>고객이름</td>
    <td>고객주소</td>
    <td>고객번호</td>
  </tr>
    <%
      for(CustomerVO c : list){
    %>
    <tr>
      <td><%=c.getCustid()%></td>
      <td><%=c.getName()%></td>
      <td><%=c.getAddress()%></td>
      <td><%=c.getPhone()%></td>
    </tr>
  <%
    }
  %>

</table>
</body>
</html>
