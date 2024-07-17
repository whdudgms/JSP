package D0715_mvc2;

import D0716.dao.CustomerDAO;
import D0715_mvc.vo.CustomerVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.ArrayList;

//@WebServlet("/kostaController.do")
public class KostaController extends HttpServlet {

    private CustomerDAO dao;

    public KostaController(){
        dao = new CustomerDAO();
    }

    public void pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("KostaController 동작함");

        String uri = request.getRequestURI();
        String cmd = uri.substring(uri.lastIndexOf("/") + 1);

        String viewPage = "";
        request.setCharacterEncoding("UTF-8");
        System.out.println("Context Path: " + request.getContextPath());
        System.out.println("Command: " + cmd);

        if (cmd.equals("listCustomerM2.do")) {
            System.out.println("come here listCustomerM2 ");
            ArrayList<CustomerVO> list = dao.findAll();
            request.setAttribute("list", list);
            System.out.println(request.getContextPath());
            viewPage = request.getContextPath()+"/D0715_mvc2/listCustomer.jsp";

        } else if (cmd.equals("insertCustomerM2.do")) {
            viewPage = request.getContextPath() + "/day0715_mvc2/insertCustomer.jsp";

        } else if (cmd.equals("insertCustomerOKM2.do")) {
            int custid = Integer.parseInt(request.getParameter("custid"));
            String name = request.getParameter("name");
            String address = request.getParameter("address");
            String phone = request.getParameter("phone");
            CustomerVO c = new CustomerVO();
            c.setCustid(custid);
            c.setName(name);
            c.setAddress(address);
            c.setPhone(phone);
            int re = dao.insert(c);
            if (re > 0) {
                request.setAttribute("msg", "고객등록 성공");
            } else {
                request.setAttribute("msg", "고객등록 실패");
            }
            viewPage = request.getContextPath() + "/D0715_mvc2/insertCustomerOK.jsp";

        } else if (cmd.equals("detailCustomerM2.do")) {
            int custid = Integer.parseInt(request.getParameter("custid"));
            CustomerVO c = new CustomerVO();
            c = dao.findByCustid(custid);
            request.setAttribute("customer", c);
            viewPage = request.getContextPath() + "/day0715_mvc2/detailCustomer.jsp";

        } else if (cmd.equals("updateCustomerM2.do")) {
            int custid = Integer.parseInt(request.getParameter("custid"));
            CustomerVO c = new CustomerVO();
            c = dao.findByCustid(custid);
            request.setAttribute("customer", c);
            viewPage = request.getContextPath() + "/day0715_mvc2/updateCustomer.jsp";

        } else if (cmd.equals("updateCustomerOKM2.do")) {
            int custid = Integer.parseInt(request.getParameter("custid"));
            String name = request.getParameter("name");
            String address = request.getParameter("address");
            String phone = request.getParameter("phone");
            CustomerVO c = new CustomerVO();
            c.setCustid(custid);
            c.setName(name);
            c.setAddress(address);
            c.setPhone(phone);
            int re = dao.insert(c);
            if (re > 0) {
                request.setAttribute("msg", "고객변경 성공");
            } else {
                request.setAttribute("msg", "고객변경 실패");
            }
            viewPage = request.getContextPath() + "/day0715_mvc2/updateCustomerOK.jsp";

        } else if (cmd.equals("deleteCustomerM2.do")) {
            int custid = Integer.parseInt(request.getParameter("custid"));
            int re = dao.delete(custid);
            if (re > 0) {
                request.setAttribute("msg", "고객변경 성공");
            } else {
                request.setAttribute("msg", "고객변경 실패");
            }
            viewPage = request.getContextPath() + "/day0715_mvc2/deleteCustomerOK.jsp";
        }

        System.out.println("View Page: " + viewPage);
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
        dispatcher.forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doget"+req.getContextPath());
        pro(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost"+req.getContextPath());
        pro(req, resp);


    }
}