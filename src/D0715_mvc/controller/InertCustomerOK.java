package D0715_mvc.controller;

import D0715_mvc.dao.CustomerDAO;
import D0715_mvc.vo.CustomerVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
@WebServlet("/insertCustomerOK.do")

public class InertCustomerOK extends HttpServlet {

    private CustomerDAO dao;

    public InertCustomerOK(){
        dao = new CustomerDAO();
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        int custid = Integer.parseInt(req.getParameter("custid"));
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");


        CustomerVO c = new CustomerVO();
        c.setCustid(custid);
        c.setName(name);
        c.setAddress(address);
        c.setPhone(phone);

        int re = dao.insert(c);

        if(re > 0){
            req.setAttribute("msg","고객등록에 성공하였습니다.");
        }else{
            req.setAttribute("msg","고객등록에 실패하였습니다.");
        }
        String viewPath =  req.getContextPath()+"/day0715_mvc/insertCustomerOK.jsp";
        RequestDispatcher dis = req.getRequestDispatcher(viewPath);
        dis.forward(req,resp);
    }
}