package D0716.action;

import D0716.dao.BoardDAO;
import D0716.vo.BoardVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

public class UpdateBoardOKAction implements KostaAction{
    @Override
    public String pro(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        String path = request.getServletContext().getRealPath("upload");
        MultipartRequest multi = new MultipartRequest(request, path,
                1024*1024*1024*5, "UTF-8"
                ,new DefaultFileRenamePolicy());



        BoardDAO dao = new BoardDAO();
        int no =  Integer.parseInt(multi.getParameter("no"));
        String title = multi.getParameter("title");
        String pwd = multi.getParameter("pwd");
        String content = multi.getParameter("content");
        String oldFname = multi.getParameter("fname");
        int oldFsize =Integer.parseInt( multi.getParameter("fsize"));



        BoardVO b = new BoardVO();
        b.setTitle(title);
        b.setNo(no);
        b.setPwd(pwd);
        b.setContent(content);
        b.setFname(oldFname);
        b.setFsize(oldFsize);


        String fname =multi.getOriginalFileName("uploadFile");


        if (fname != null){
            File file = new File(path+"/"+fname);
            int fsize = (int) file.length();
            b.setFname(fname);
            b.setFsize(fsize);
        }



        int re = dao.update(b);

        // 게시물 수정에 성공했고 파일도 수정했다면 원래의 파일을 삭제 합니다.
        if(re > 0 && fname != null){
            File file = new File(path+"/"+oldFname);
            file.delete();
        }


        request.setAttribute("re",re);
        return request.getContextPath()+"/D0716/"+"updateBoardOK.jsp";
    }
}
