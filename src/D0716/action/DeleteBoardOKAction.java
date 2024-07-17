package D0716.action;

import D0716.dao.BoardDAO;
import D0716.vo.BoardVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

public class DeleteBoardOKAction implements KostaAction {


    @Override
    public String pro(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String path = request.getServletContext().getRealPath("upload");

        String viewPath ="";
        int no = Integer.parseInt(request.getParameter("no"));
        String pwd = request.getParameter("pwd");
        BoardDAO dao = new BoardDAO();
        BoardVO b     =   new BoardVO();
        String fname = dao.findByNo(no).getFname();
        b.setNo(no);
        b.setPwd(pwd);
        int re = dao.delete(b);

        if(re >0){
            if(fname != null){
                File file = new File(path+"/"+fname);
                file.delete();
            }
            viewPath = request.getContextPath()+"/D0716/"+"deleteBoardOK.jsp";
        }else{
            viewPath = request.getContextPath()+"/D0716/"+"error.jsp";
        }




        return viewPath;
    }
}
