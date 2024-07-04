<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Collections" %>
<%@ page import="java.util.Collection" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.DriverManager" %><%--
  Created by IntelliJ IDEA.
  User: WD
  Date: 2024-07-04
  Time: 오후 12:47
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
    // POST로ㅓ
    request.setCharacterEncoding("UTF-8");

    String name = request.getParameter("name");
    String addr = request.getParameter("addr");
    int age = Integer.parseInt(request.getParameter("age"));
    String email = request.getParameter("email");
    String pw = request.getParameter("pw");
    String[] hobby = request.getParameterValues("hobby");
    String hobby2 = String.join(",",hobby);
    String gender = request.getParameter("gender");
    String bloodType = request.getParameter("bloodType");
    String job = request.getParameter("job");
    String food = request.getParameter("food");
    String info = request.getParameter("self");
    String sql = "INSERT INTO member (\n" +
            "    no, \n" +
            "    name, \n" +
            "    addr, \n" +
            "    age, \n" +
            "    email, \n" +
            "    pwd, \n" +
            "    hobby, \n" +
            "    bloodType, \n" +
            "    job, \n" +
            "    food, \n" +
            "    info, \n" +
            "    gender\n" +
            ") VALUES (\n" +
            "    seq_member.NEXTVAL,  -- 시퀀스를 사용하여 no 값을 자동으로 증가시킵니다.\n" +
            "    '"+name+"',\n" +
            "    '"+addr+"',\n" +
            "    "+age+",\n" +
            "    '"+email+"',\n" +
            "    '"+pw+"',\n" +
            "    '"+hobby+"',\n" +
            "    '"+bloodType+"',\n" +
            "    '"+job+"',\n" +
            "    '"+food+"',\n" +
            "    '"+info+"',\n" +
            "    '"+gender+"'\n" +
            ")";

            Connection conn = null;
            Statement stmt = null;

            String driver = "oracle.jdbc.driver.OracleDriver";
            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            String username = "c##kosta1234";
            String password = "kosta1234";

            Class.forName(driver);
            conn = DriverManager.getConnection(url,username,password);
            stmt = conn.createStatement();

            boolean a = stmt.execute(sql);

            if(a){
                System.out.println("성공!!!!");
            }
%>

<%--이름:<%=name%> <br>--%>
<%--주소:<%=addr%>  <br>--%>
<%--나이:<%=age%>   <br>--%>
<%--이메일 : <%=email%>  <br>--%>
<%--비밀번호 : <%=pw%> <br>--%>
<%--hobby : <%--%>
<%--for(String h : hobby){--%>
<%--    %>--%>
<%--    <%=h%> &nbsp;--%>
<%--<%--%>
<%--}%>--%>
<%--<br>--%>
<%--hobby2 : <%=hobby2%> <br>--%>
<%--성별 : <%=gender%> <br>--%>
<%--혈핵형 : <%=blood%> <br>--%>
<%--직업 : <%=job%> <br>--%>
<%--음식 : <%=food%><br>--%>
<%--자기소개 : <%=self%><br>--%>

</body>
</html>
