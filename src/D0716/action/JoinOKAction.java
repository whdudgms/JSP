package D0716.action;

import D0716.dao.MemberDAO;
import D0716.vo.MemberVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JoinOKAction implements KostaAction{
    @Override
    public String pro(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        MemberDAO dao = new MemberDAO();
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");
        String name = request.getParameter("name");

        MemberVO m = new MemberVO(id,pwd,name);
        int re = dao.insert(m);
        request.setAttribute("re",re);

        return request.getContextPath()+"/D0716/"+"joinOK.jsp";
    }
}
