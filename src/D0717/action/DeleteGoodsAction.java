package D0717.action;

import D0717.dao.GoodsDAO;
import D0717.vo.GoodsVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

public class DeleteGoodsAction implements KostaAction {
    @Override
    public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int no = Integer.parseInt(request.getParameter("no"));
        GoodsDAO dao = new GoodsDAO();
        GoodsVO g = new GoodsVO();
        String fname = dao.findByNo(no).getFname();
        g.setNo(no);
        int re  = dao.delete(dao.findByNo(no));
        String viewPage = "";

        if(re>0){
            viewPage = "listGoods.do";
            String path = request.getServletContext().getRealPath("images");
            File file = new File(path+"/"+fname);
        }else{
            request.setAttribute("msg","상품삭제에 실패하였습니다.");
            viewPage = "error.jsp";
        }
        return viewPage;
    }
}
