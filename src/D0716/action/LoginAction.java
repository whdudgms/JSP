package D0716.action;

import D0716.dao.MemberDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginAction implements KostaAction {
    @Override
    public String pro(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


        return request.getContextPath()+"/D0716/"+"login.jsp";

    }
}
