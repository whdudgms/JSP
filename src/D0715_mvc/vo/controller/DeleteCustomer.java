package D0716.controller;

import D0716.dao.CustomerDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

@WebServlet("/deleteCustomer.do")
public class DeleteCustomer extends HttpServlet {

    private CustomerDAO dao;
    public DeleteCustomer(){
        dao = new CustomerDAO();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int re = dao.delete(Integer.parseInt(req.getParameter("custid")));

        System.out.println("삭제:" +re);

        if(re >0) {
            req.setAttribute("msg", "삭제성공");
        }else{
            req.setAttribute("msg", "삭제실패");

        }
        String viewPath =  req.getContextPath()+"/day0715_mvc/deleteCustomer.jsp";
        RequestDispatcher dis = req.getRequestDispatcher(viewPath);

        dis.forward(req,resp);
    }
}
