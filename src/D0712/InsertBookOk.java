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

@WebServlet("/InsertBookOk")
public class InsertBookOk extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //폼 양식에서 새로운 도서 등록을 위하여 입력한 내용을 갖고 doPost로 옵니다.
        // 이때 사용자의 요청정보는 request에 실려서 옵니다.
        //request통해서 사용자가 요청한 정보(도서번호,도서명,출판사,가격을 받아 옮)
        req.setCharacterEncoding("UTF-8");
        
        //새로운 도서 등록을 위하여 요청한 데이터(도서번호,도서명,가격,출판사) 받아와서 변수에 저장
        //요청한 데이터는 모두 doPost메소드의 매개변수 request에 실려 있습니다.
        int bookid = Integer.parseInt(req.getParameter("no"));
        String bookName = req.getParameter("name");
        int price = Integer.parseInt(req.getParameter("price"));
        String publisher = req.getParameter("publisher");

        String sql =  "insert into book values(?,?,?,?)";
        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String id= "c##madang";
        String pw ="madang";
        int re=0;
        try{
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url,id,pw);
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setInt(1,bookid);
            psmt.setString(2,bookName);
            psmt.setInt(3,price);
            psmt.setString(4,publisher);

             re = psmt.executeUpdate();

            psmt.close();
            conn.close();

        }catch (Exception e){
            System.out.println("예외 발생"+e.getMessage());
        }

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        if(re>0){
            out.print("도서등록성공");
        }else{
            out.print("도서등록실패");

        }

    }
}