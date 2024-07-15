<%--
  Created by IntelliJ IDEA.
  User: WD
  Date: 2024-07-05
  Time: 오전 9:36
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
        request.setCharacterEncoding("UTF-8");
        String a = request.getParameter("name");
        String b = request.getParameter("content");
        String c = request.getParameter("content2");
    %>

    name : <%=a%><br>
    content : <%=b%><br>
    conten1 : <%=c%>



</body>
</html>
