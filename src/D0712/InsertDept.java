package D0712;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/InsertDept")
public class InsertDept extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        String data ="<form method='post' action='/InsertDeptOk'>";
        data += "부서번호 : <input name='dno' type='text'> <br>";
        data += "부서이름 : <input name='dname' type='text'> <br>";
        data += "부서위치 : <input name='loc' type='text'> <br>";
        data += "<input  type='submit'  value='등록'> <br>";
        data += "<input type='reset' value='취소'>";
        data += "</form>";
        out.print(data);
        out.close();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}