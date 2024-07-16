<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: WD
  Date: 2024-07-15
  Time: 오전 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<html>
<head>
    <title>update</title>
    <meta charset="UTF-8">
</head>
<body>
    <%
        int custid = Integer.parseInt(request.getParameter("custid"));
        String sql  ="select * from customer where custid = ?";
        String driver ="oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521";
        String username ="c##madang";
        String password="madang";


        String name="";
        String phone ="";
        String addr="";

        try{
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url,username,password);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,custid);
            ResultSet rs = pstmt.executeQuery();

            if(rs.next()){
                name = rs.getString(2);
                phone = rs.getString(3);
                addr = rs.getString(4);
            };
        }catch (Exception e){
            System.out.println(e.getMessage());
        }



    %>
    <h2>고객수정</h2>
    <hr>
    <form action="updateCustomerOk.jsp" method="post">
        고객번호 : <span><%=custid%><input type="hidden" name="custid" value="<%=custid%>"><br>
        고객이름 : <input type="text" name="name" value="<%=name%>"><br>
        고객주소 : <input type="text" name="address" value="<%=addr%>"><br>
        고객전화 : <input type="text" name="phone" value="<%=phone%>"><br>
        <input type="submit" value="수정">

        <input type="reset" value="취소">
    </form>
</body>
</html>
