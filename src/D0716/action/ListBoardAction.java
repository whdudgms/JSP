package D0716.action;

import D0716.dao.BoardDAO;
import D0716.vo.BoardVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ListBoardAction implements KostaAction{


    @Override
    public String pro(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        BoardDAO dao = new BoardDAO();
        request.setAttribute("list", dao.findAll());
        return request.getContextPath()+"/D0716/"+"listBoard.jsp";
    }


}
