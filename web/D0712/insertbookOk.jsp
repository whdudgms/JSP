<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %><%--
  Created by IntelliJ IDEA.
  User: WD
  Date: 2024-07-12
  Time: 오전 11:46
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
      int bookid = Integer.parseInt(request.getParameter("bookid"));
      String bookname = request.getParameter("bookname");
      int price =  Integer.parseInt(request.getParameter("price"));
      String publisher = request.getParameter("publisher");

      //데이터베이스 연결하여 실행시킬

      String sql = "insert into book values(?,?,?,?)";

      String driver = "oracle.jdbc.driver.OracleDriver";
      String url = "jdbc:oracle:thin:@localhost:1521:XE";
      String username = "c##madang";
      String password = "madang";
      int re=0;
      try{
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url,username,password);
        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setInt(1, bookid);
        pstmt.setString(2, bookname);
        pstmt.setInt(3,price);
        pstmt.setString(4,publisher);
        re = pstmt.executeUpdate();

        pstmt.close();
        conn.close();
      }catch (Exception e){
        System.out.println(e.getMessage());
      }
      if(re > 0){
    %>
    <h2>도서 등록 성공</h2>
    <%
    }else{

    %>
    <h2>도서 등록  실패</h2>

    <%
      }
    %>



  </body>
</html>
