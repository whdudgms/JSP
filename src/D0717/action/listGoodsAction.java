package D0717.action;

import D0717.action.KostaAction;
import D0717.dao.GoodsDAO;
import D0717.vo.GoodsVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class listGoodsAction implements KostaAction {


    @Override
    public String pro(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ArrayList<GoodsVO> list = new GoodsDAO().findAll();
        request.setAttribute("list",list);
        return request.getContextPath()+"/D0717/"+"listGoods.jsp";

    }
}
