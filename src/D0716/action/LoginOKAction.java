package D0716.action;

import D0716.dao.MemberDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginOKAction implements KostaAction{
    @Override
    public String pro(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


        MemberDAO dao = new MemberDAO();
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");
        int re = dao.isMember(id,pwd);
        if(re ==1){
            HttpSession session = request.getSession();
            session.setAttribute("userId",id);
        }
        request.setAttribute("re",re);

        System.out.println(request.getContextPath()+"/D0716/"+"loginOK.jsp");
        return request.getContextPath()+"/D0716/"+"loginOK.jsp";


    }
}