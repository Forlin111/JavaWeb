package ServletTest;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletContext extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        javax.servlet.ServletContext servletContext = getServletConfig().getServletContext();
        /*1,获取web.xml中的配置的上下文参数context-param;*/
        String username = servletContext.getInitParameter("username");
        System.out.println(username);
        /*获取当前工程的路径*/
        System.out.println(servletContext.getContextPath());
        /*  /  被服务器解析地址为:   https://ip:port/工程名/   映射到idea目录里的web目录*/
        /*获取部署在服务器硬盘上的绝对路径*/
        System.out.println(servletContext.getRealPath(""));
        /*获取工程下css目录下的绝对路径*/
        System.out.println(servletContext.getRealPath("css"));
    }

}
