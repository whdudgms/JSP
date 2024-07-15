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

@WebServlet("/InsertCustomer")
public class InsertCustomer extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doget 시작");
        String data ="";
        data += "<html>";
        data += "<body>";
        data += "<form action='InsertCustomer' method='post'>";
        data += "고객번호 :<input type='text' name='custid'><br>";
        data += "고객이름 :<input type='text' name='name'><br>";
        data += "고객주소 :<input type='text' name='address'><br>";
        data += "고객전화 :<input type='text' name='phone'><br>";
        data += " <input type='submit' value='submit'><br>";
        data += " <input type='reset' value='reset'><br>";
        data += "</form>";
        data += "</body>";
        data += "</html>";

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out =  resp.getWriter();
        out.print(data);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int custid = Integer.parseInt(req.getParameter("custid"));
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");


        String sql = "insert into customer values(?,?,?,?)";
        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String username = "c##madang";
        String pw = "madang";
        int re = -1;

        try{
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url,username,pw);
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1,custid);
            pstmt.setString(2,name);
            pstmt.setString(3,address);
            pstmt.setString(4,phone);
            re = pstmt.executeUpdate();

            pstmt.close();
            conn.close();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        if(re > 0){
            out.print("고객등록");
        }else{
            out.print("고객등록 실패");
        }

        out.close();

    }
}