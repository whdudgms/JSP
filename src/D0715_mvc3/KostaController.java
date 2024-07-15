//package D0715_mvc3;
//
//import D0715_mvc.dao.CustomerDAO;
//import D0715_mvc.vo.CustomerVO;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.ArrayList;
//
////@WebServlet("/kostaController.do")
//public class KostaController extends HttpServlet {
//
//    private CustomerDAO dao;
//
//    public KostaController(){
//        dao = new CustomerDAO();
//    }
//
//    public void pro(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException{
//        System.out.println("KostaController 동작함");
//
////        String url = request.getRequestURL().toString();
////        String uri = request.getRequestURI();
////
////        System.out.println("url : "+url);
////        System.out.println("uri : "+uri);
////request.getContextPath()+"/day0715_mvc2/
//        String uri = request.getRequestURI();
//
//        String cmd = uri.substring(uri.lastIndexOf("/")+1);
//
//        String viewPage="";
//        request.setCharacterEncoding("UTF-8");
//        ActionKosta action = null;
//        if(cmd.equals("listCustomerM2.do")){
//            action = new ListCustomerAction();
//        } else if (cmd.equals("insertCustomerM2.do")) {
//            action = new InsertCustomerAction();
//        } else if (cmd.equals("insertCustomerOKM2.do")) {
//        } else if (cmd.equals("detailCustomerM2.do")) {
//        }else if (cmd.equals("updateCustomerM2.do")) {
//        }else if (cmd.equals("updateCustomerOKM2.do")) {
//        }else if (cmd.equals("deleteCustomerM2.do")) {
//        }
//        String viewPath  = action.pro(request,response);
//        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
//        dispatcher.forward(request,response);
//        System.out.println("cmd:  "+cmd);
//    }
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("doget"+req.getContextPath());
//        pro(req, resp);
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("doPost"+req.getContextPath());
//        pro(req, resp);
//
//
//    }
//}