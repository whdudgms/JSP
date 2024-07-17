package D0717.action;

import D0717.dao.GoodsDAO;
import D0717.vo.GoodsVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InsertGoodsOKAction implements KostaAction{
    @Override
    public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String path = request.getServletContext().getRealPath("images");
        MultipartRequest multi =
                new MultipartRequest(request,path,1024*1024*1024*5,"UTF-8",new DefaultFileRenamePolicy());
        GoodsVO g = new GoodsVO();
        g.setItem(multi.getParameter("item"));
        g.setPrice(Integer.parseInt(multi.getParameter("price")));
        g.setQty(Integer.parseInt(multi.getParameter("qty")));
        g.setFname(multi.getOriginalFileName("uploadFile"));
        GoodsDAO dao = new GoodsDAO();
        int re =  dao.insert(g);
        request.setAttribute("re",re);
        return request.getContextPath()+"/D0717/"+"insertGoodsOK.jsp";
    }

}
