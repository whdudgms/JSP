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
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet("/ListServlet")
public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sql = "select custid, name from customer";

        String data = "<html>";
        data += "<body>";
        data += "<h2>고객목록</h2>";
        data += "<hr>";
        data += "<ul>";

        String driver ="oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String id = "c##madang";
        String pw = "madang";



        try{
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url,id,pw);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                int custid = rs.getInt(1);
                String name = rs.getString(2);
                data += "<li><a href='DetailCustomer?custid="+custid+"'>"+name+"</a></li>";
            }

            rs.close();
            stmt.close();
            conn.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        data += "</ul>";
        data += "</body>";
        data += "</html>";

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print(data);
        out.close();


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}