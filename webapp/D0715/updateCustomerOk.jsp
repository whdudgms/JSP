<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %><%--
  Created by IntelliJ IDEA.
  User: WD
  Date: 2024-07-15
  Time: 오전 10:19
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
    int custid = Integer.parseInt(request.getParameter("custid"));
    String name = request.getParameter("name");
    String address =request.getParameter("address");
    String phone = request.getParameter("phone");
    String sql = "update customer set name=?,address=?,phone=? where custid=?";

    String driver ="oracle.jdbc.driver.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521";
    String username ="c##madang";
    String password="madang";
    int re =-1;
    try{
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url,username,password);
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,name);
        pstmt.setString(2,address);
        pstmt.setString(3,phone);
        pstmt.setInt(4,custid);
        re =pstmt.executeUpdate();
        pstmt.close();
        conn.close();
    }catch (Exception e){
        System.out.println("예외발생 : "+e.getMessage());
    }

    if(re > 0){
        %>
            <h3>고객수정 성공</h3>
        <%
    }else{
        %>
         <h3>고객수정 실패</h3>
        <%
    }

%>

</body>
</html>
