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

public class InsertBoardOKAction implements KostaAction{
    @Override
    public String pro(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        BoardDAO dao = new BoardDAO();
        request.setCharacterEncoding("UTF-8");

        //파일업로드
        //MultipartRequest 객체를 이용합니다.
        //MultipartRequest 객체 생성시에 파일을 업로드할 경로를 지정해야 합니다
        //

        //업로드할 폴더(upload)의 실 경로를 알아 옵니다.
        String path = request.getServletContext().getRealPath("upload");
        System.out.println("path ::"+path);

        // MultipartRequest 객체를 생성하는 순간 파일은 서버에 지정한 경로가 업로드(복사)가 되고
        //나머지 사용자가 입력한 정보를

        MultipartRequest multi = new MultipartRequest(request,
                path,
                1024*1024*1024*5,
                "UTF-8",
                new DefaultFileRenamePolicy()
        );


        String fname = multi.getOriginalFileName("uploadFile");
        File file = new File(path+"/"+fname);
        int fsize = (int)file.length();
        String title =  multi.getParameter("title");
        String writer = multi.getParameter("writer");
        String pwd = multi.getParameter("pwd");
        String content = multi.getParameter("content");
        BoardVO b = new BoardVO();
        b.setTitle(title);
        b.setWriter(writer);
        b.setPwd(pwd);
        b.setContent(content);
        b.setFname(fname);
        b.setFsize(fsize);
        int re =  dao.insert(b);
        System.out.println("re   "+re );
        request.setAttribute("re",re);
        return request.getContextPath()+"/D0716/"+"insertBoardOK.jsp";
    }
}
