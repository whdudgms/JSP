package D0716.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class InsertBoardAction implements KostaAction{
    @Override
    public String pro(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession session =request.getSession();
        if(session.getAttribute("userId")==null){
             return "login.do";
        }
        return request.getContextPath()+"/D0716/"+"insertBoard.jsp";
    }
}
