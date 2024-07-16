<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
<h2>
    부서목록
</h2>

<hr>
<table border="1"width="80%">
    <thead>
    <tr>
        <th>부서번호</th>
        <th>부서이름</th>
        <th>부서위치</th>
    </tr>
    </thead>
    <tbody>
    <%
        Connection conn;
        Statement stmt;
        ResultSet rs;

        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String username = "c##madang";
        String password = "madang";
        String sql = "select * from dept";
        Class.forName(driver);
        conn = DriverManager.getConnection(url,username,password);
        stmt = conn.createStatement();
        rs =stmt.executeQuery(sql);
        while(rs.next()){
            %>
                 <tr>
                     <td><%= rs.getInt(1)  %></td>
                     <td><%= rs.getString(2)  %></td>
                     <td><%= rs.getString(3)  %></td>
                </tr>
                <%
                }
    %>
    <%%>
    </tbody>

</table>

</body>
</html>