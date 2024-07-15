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
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>도서 목록</title>
</head>
<body>
    <h2> <%=request.getParameter("name")%>의 주문 도서 목록</h2>

        <table border="1"width="80%">
            <thead>
            <tr>
                <th>도서번호</th>
                <th>도서명</th>
                <th>가격</th>
                <th>출판사</th>
            </tr>
            </thead>



        <tbody>
        <%
            //사용자가 요청한 문자셋은 한글입니다.
            request.setCharacterEncoding("UTF-8");

            //사용자가 요청한 고객의 이름을 받아 옵니다.
            String name = request.getParameter("name");

            String sql = "select bookid,bookname,price,publisher from book where bookid in (select bookid from orders where custid = (select custid from customer where name = '"+name+"'))";
            String driver = "oracle.jdbc.driver.OracleDriver";
            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            String username ="c##madang";
            String password ="madang";

            try{
                Class.forName(driver);
                Connection conn = DriverManager.getConnection(url,username,password);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                while(rs.next()){
        %>
        <tr>
            <td><%=rs.getInt(1)%></td>
            <td><%=rs.getString(2)%></td>
            <td><%=rs.getInt(3)%></td>
            <td><%=rs.getString(4) %></td>
        </tr>
        <%
                }

                rs.close();
                stmt.close();
                conn.close();

            }catch (Exception e){
                System.out.println("예외발생"+e.getMessage());
            }

        %>
        </tbody>
        </table>
</body>
</html>
