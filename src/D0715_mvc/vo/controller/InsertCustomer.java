package D0716.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

@WebServlet("/insertCustomer.do")
public class InsertCustomer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String viewPath = req.getContextPath()+"/day0715_mvc/" +"insertCustomer.jsp";
        req.getRequestDispatcher(viewPath).forward(req, resp);
    }


}