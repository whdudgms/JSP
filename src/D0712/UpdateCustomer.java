package D0712;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/UpdateCustomer")
public class UpdateCustomer extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int custid = Integer.parseInt(req.getParameter("custid"));
        String driver="oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String username = "c##madang";
        String pw = "madang";

        String sql = "select * from customer where custid = ?";
        String name="";
        String address ="";
        String phone ="";

        try{
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url,username,pw);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,custid);
            ResultSet rs =  pstmt.executeQuery();
            if(rs.next()){
                name =rs.getString(2);
                address = rs.getString(3);
                phone = rs.getString(4);
            }
            rs.close();
            pstmt.close();
            conn.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }




        System.out.println("doget 시작");
        String data ="";
        data += "<html>";
        data += "<body>";
        data += "<h2>고객수정</h2>";
        data += "<hr>";


        data += "<form action='UpdateCustomer' method='post'>";
        data += "고객번호 :<span>"+custid+"</span><input type='hidden'  value="+custid+" name='custid'><br>";
        data += "고객이름 :<input type='text' value="+name+" name='name'><br>";
        data += "고객주소 :<input type='text' value="+address+" name='address'><br>";
        data += "고객전화 :<input type='text' value="+phone+" name='phone'><br>";
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


        String sql = "update cust" +
                "omer set name=?, address=?, phone=? where custid=? ";
        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String username = "c##madang";
        String pw = "madang";
        int re = -1;

        try{
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url,username,pw);
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1,name);
            pstmt.setString(2,address);
            pstmt.setString(3,phone);
            pstmt.setInt(4,custid);
            re = pstmt.executeUpdate();

            pstmt.close();
            conn.close();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        if(re > 0){
            out.print("고객 수정 성공");
        }else{
            out.print("고객 수정 실패");
        }

        out.close();

    }
}