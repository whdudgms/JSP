package D0716.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public interface KostaAction {
    public String pro(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException;

}
