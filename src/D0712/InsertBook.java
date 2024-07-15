package D0712;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/insertBook")
public class InsertBook extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out= resp.getWriter();
        String data  = "    <form action='/InsertBookOk' method='post'><br>" +
                "    북 번호 <input name='no' type='text'><br>" +
                "    북 이름 <input name='name' type='text'><br>" +
                "    가격 <input name='price' type='text'><br>" +
                "    출판사  <input name='publisher' type='text'><br>" +
                "      <input name='submit' type='submit' value='등록'><br>" +
                "      <input name='reset' type='reset' value='취소'><br>" +
                "    </form>";

        resp.setContentType("text/html;charset=UTF-8");
        out.println(data);
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}