package D0715_mvc3;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ActionKosta {
    public String pro(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException;
}
