package D0716.action;

import D0716.dao.MemberDAO;
import D0716.vo.MemberVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JoinAction implements KostaAction {



    @Override
    public String pro(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


        return request.getContextPath()+"/D0716/"+"join.jsp";
    }
}
