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
import java.sql.ResultSet;

@WebServlet("/DetailCustomer")
public class DetailCustomer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int custid = Integer.parseInt(req.getParameter("custid"));

        String sql = "select * from customer where custid=?";
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        String data = "<html>";
        data += "<body>";


        String driver="oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String username = "c##madang";
        String pw = "madang";
        try{
            Class.forName(driver);

            Connection conn = DriverManager.getConnection(url,username,pw);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,custid);

            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                String name = rs.getString(2);
                String address = rs.getString(3);
                String phone = rs.getString(4);

                data += "고객번호" +custid+"<br>";
                data += "고객이름" +name+"<br>";
                data += "고객주소" +address+"<br>";
                data += "고객저나" +phone+"<br>";

            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        data += "<br>";

        data += "<br>";
        data += "<br>";
        data += "<br>";
        data += "<br>";

        data += "<a href='UpdateCustomer?custid="+custid+"'>수정</a>";

        data += "</body>";
        data += "</html>";
        out.print(data);
        out.close();
    }
}