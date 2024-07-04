<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>도서 목록</title>
</head>
<body>
<h2>도서 목록</h2>
<ul>
    <%
        try {
            String driver = "oracle.jdbc.driver.OracleDriver";
            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            String username = "c##madang";
            String password = "madang";
            String sql = "SELECT * FROM book";

            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;

            // 1. JDBC 드라이버를 메모리로 로드한다.
            Class.forName(driver);

            // 2. DB 서버에 연결한다.
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
    %>
        <li><%= rs.getString(2) %></li>
    <%
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    %>
</ul>
</body>
</html>
