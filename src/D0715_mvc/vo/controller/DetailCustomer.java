package D0716.controller;

import D0716.dao.CustomerDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/detailCustomer.do")
public class DetailCustomer extends HttpServlet {
    private CustomerDAO dao;
    public DetailCustomer(){
        dao = new CustomerDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("customer",   dao.findByCustid(Integer.parseInt (req.getParameter("custid"))));

        String viewPath =  req.getContextPath()+"/day0715_mvc/detailCustomer.jsp";
        RequestDispatcher dis = req.getRequestDispatcher(viewPath);
        dis.forward(req,resp);
    }


}