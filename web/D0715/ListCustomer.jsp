<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: WD
  Date: 2024-07-15
  Time: 오전 9:46
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
<h2>고객목록</h2>
<hr>



    <table  border="1 solid black">
        <tr>
            <td>고객번호</td>
            <td>고객이름</td>
            <td>고객주소</td>
            <td>고객저나번호</td>
        </tr>

    <%
        String sql = "select * from customer";
        String driver ="oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521";
        String username ="c##madang";
        String password="madang";
        int re = -1;

        try{
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url,username,password);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){
                %>
                    <tr>
                        <td><%=rs.getInt(1)%></td>
                        <td><a href="detailCustomer.jsp?custid=<%=rs.getInt(1)%>"><%=rs.getString(2)%></a></td>
                        <td><%=rs.getString(3)%></td>
                        <td><%=rs.getString(4)%></td>
                    </tr>
                <%
            }

        }catch(Exception e){
            System.out.println("예외발생 : "+e.getMessage());
        }
    %>

</table>
</body>
</html>
