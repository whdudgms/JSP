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

    String driver ="oracle.jdbc.driver.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521";
    String username ="c##madang";
    String password="madang";
    String sql =  "insert into customer values(?,?,?,?)";
    int re =-1;
    try{
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url,username,password);
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1,custid);
        pstmt.setString(2,name);
        pstmt.setString(3,address);
        pstmt.setString(4,phone);
        re =pstmt.executeUpdate();
        pstmt.close();
        conn.close();
    }catch (Exception e){
        System.out.println("예외발생 : "+e.getMessage());
    }

    if(re > 0){
        %>
            <h3>고객등록 성공</h3>
        <%
    }else{
        %>
         <h3>고객등록 실패</h3>
        <%
    }

%>

</body>
</html>
