package D0717.action;

import D0717.dao.GoodsDAO;
import D0717.vo.GoodsVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DetailGoodsAction implements KostaAction{

    @Override
    public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int no = Integer.parseInt(request.getParameter("no"));
        System.out.println(no);
        GoodsVO g = new GoodsDAO().findByNo(no);
        request.setAttribute("g",g);
        System.out.println(g.getNo());
        System.out.println(g.getItem());

        return request.getContextPath()+"/D0717/"+"detailGoods.jsp";
    }
}
