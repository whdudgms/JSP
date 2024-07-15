package D0715_mvc3;

import D0715_mvc.dao.CustomerDAO;
import D0715_mvc.vo.CustomerVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InsertCustomerAction implements ActionKosta{

    @Override
    public String pro(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String viewPath="";

        CustomerDAO dao = new CustomerDAO();
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
        if(re>0){
            request.setAttribute("msg","고객등록 성공");
        }else{
            request.setAttribute("msg","고객등록 실패");
        }
        viewPath = request.getContextPath()+"/day0715_mvc2/"+ "insertCustomerOK.jsp";
        return viewPath;
    }
}
