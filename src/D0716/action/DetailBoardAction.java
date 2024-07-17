package D0716.action;


import D0716.dao.BoardDAO;
import D0716.vo.BoardVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DetailBoardAction implements KostaAction {


    @Override
    public String pro(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        BoardDAO dao = new BoardDAO();
        int no = Integer.parseInt(request.getParameter("no"));
        BoardVO b = dao.findByNo(no);
        String ext ="";
        if( !("".equals(b.getFname())) && b.getFname() != null) {
            ext = b.getFname().split("\\.")[1];
        }
        System.out.println("ext"+ext);
        String isImg = "no";
        if(ext.equals("png") || ext.equals("jpg") || ext.equals("gif")){
            isImg = "yes";
        }
        request.setAttribute("b", dao.findByNo(no));
        request.setAttribute("isImg", isImg);

        return request.getContextPath()+"/D0716/"+"detailBoard.jsp";
    }


}