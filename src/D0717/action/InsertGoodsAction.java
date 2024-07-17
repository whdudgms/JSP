package D0717.action;

import D0717.dao.GoodsDAO;
import D0717.vo.GoodsVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InsertGoodsAction implements KostaAction{
    @Override
    public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        return request.getContextPath()+"/D0717/"+"insertGoods.jsp";
    }
}
