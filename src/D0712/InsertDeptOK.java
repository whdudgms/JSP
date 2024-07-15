package D0712;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet("/InsertDeptOk")
public class InsertDeptOK extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int dno = Integer.parseInt(request.getParameter("dno"));
        String dname = request.getParameter("dname");
        String loc = request.getParameter("loc");


        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "c##madang";
        String pw = "madang";

        String sql = "insert into dept values(?,?,?)";

        int re=0;
        try{
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url,username,pw);
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1,dno);
            pstmt.setString(2,dname);
            pstmt.setString(3,loc);
            re = pstmt.executeUpdate();

            System.out.println(re);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out =  response.getWriter();
        if(re > 0){
            out.print("<h1>성공</h1>");
        }else {
            out.print("<h1>실패</h1>");;
        }

    }
}