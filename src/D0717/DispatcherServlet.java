package D0717;

import D0717.action.KostaAction;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;


@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {

    HashMap<String, KostaAction>  map= null;

//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        map =new HashMap<String,KostaAction>();
//
//        String path = config.getServletContext().getRealPath("WEB-INF");
//        try{
//            Reader reader = new FileReader(path+"/kosta.properties");
//            Properties prop = new Properties();
//            prop.load(reader);
//            Iterator iter = prop.keySet().iterator();
//            while(iter.hasNext()){
//                String key = (String)iter.next();
//                System.out.println("key 입력될 : "+key);
//                String clsName = prop.getProperty(key);
//                Object obj = Class.forName(clsName).getNestHost();
//                map.put(key,(KostaAction) obj);
//            }
//            reader.close();
//        }catch (Exception e){
//
//        }
//        super.init();
//    }
@Override
public void init(ServletConfig config) throws ServletException {
    super.init();

    map = new HashMap<String, KostaAction>();
//        map.put("join.do",new JoinAction());
//        map.put("joinOK.do",new JoinOKAction());
//        map.put("login.do",new LoginAction());
//        map.put("loginOK.do",new LoginOKAction());

    String path = config.getServletContext().getRealPath("/WEB-INF");
    try {
        Reader reader = new FileReader(path+"/kosta.properties");

        Properties prop = new Properties();

        prop.load(reader);

        Set keys = prop.keySet();

        // key의 수 만큼 반복실행한다.
        Iterator iter = keys.iterator();

        // key를 갖고 있는 set를 반복시키기 위한 iterator에 데이터가 있는 만큼 반복실행한다.
        while(iter.hasNext()){
            String key = (String)iter.next();
            String className = prop.getProperty(key);

            Object obj =   Class.forName(className).newInstance();

            map.put(key,(KostaAction) obj);
        }

    } catch (FileNotFoundException e) {
        System.out.println(e.getMessage());
    } catch (IOException e) {
        throw new RuntimeException(e);
    } catch (ClassNotFoundException e) {
        throw new RuntimeException(e);
    } catch (InstantiationException e) {
        throw new RuntimeException(e);
    } catch (IllegalAccessException e) {
        throw new RuntimeException(e);
    }

}

    public void pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        System.out.println("uri = " + uri);
        // /day0717/insertGoods.do 일경우  insertGoods.do
        String cmd = uri.substring(uri.lastIndexOf("/")+1);
        System.out.println("cmd = "  + cmd);

        KostaAction action= null;
        action = map.get(cmd);

        String viewPage = action.pro(request,response);


        if (viewPage.endsWith(".do")){
            response.sendRedirect("viewPage");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
        dispatcher.forward(request,response);


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        pro(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        pro(req, resp);
    }
}