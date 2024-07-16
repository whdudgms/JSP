<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: WD
  Date: 2024-07-15
  Time: 오전 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
    <script>
        window.onload=function(){
            document.querySelector("#delete_btn").onclick=function(event){
                let re = confirm("정말로 삭제할까요?");
                if(re === false){
                    event.preventDefault();
                    return false;
                }
            }
        }

    </script>
</head>
<body>
<h2>고객 상세 정보</h2>
<%
    int custid = Integer.parseInt(request.getParameter("custid"));
    String sql = "select * from customer where custid =?";
    String driver ="oracle.jdbc.driver.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521";
    String username ="c##madang";
    String password="madang";

    try{
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url,username,password);
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1,custid);
        ResultSet rs = pstmt.executeQuery();
        if(rs.next()){
        %>
            고객번호 : <%=custid%><br>
            고객이름 : <%=rs.getString(2)%><br>
            고객주소 : <%=rs.getString(3)%><br>
            고객전화 : <%=rs.getString(4)%><br>
        <%

        }
            rs.close();
            pstmt.close();
            conn.close();


    }catch(Exception e){
        System.out.println("예외발생 : " +e.getMessage());
    }
%>
<hr>
<a href="updateCustomer.jsp?custid=<%=custid%>">수정</a>
<a href="deleteCustomer.jsp?custid=<%=custid%>">삭제</a>
</body>
</html>
