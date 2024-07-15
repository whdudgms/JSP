package D0712;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String data = "<h1>Hello Servlet</h1>";
        data += "<hr>";
        data += "<h1>한글</h1>";

        //응답 방식을 설정!
        response.setContentType("text/html;charset=utf-8");

        //동적으로 생성한 HTML을 요청한 사용자의 브라우저에 응답(출력)하기 위하여 스트림을 얻어 온다.
        PrintWriter out = response.getWriter();

        out.print(data);

        out.close();

    }
}