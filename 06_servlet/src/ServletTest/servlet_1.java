package ServletTest;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class servlet_1 implements Servlet {
    public servlet_1() {
        System.out.println("构造器方法");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("初始化方法");

        //获取servlet程序的servlet-name的值;
        System.out.println("servlet程序的别名servlet-name:"+servletConfig.getServletName());
        //获取自己在web.xml中配置的init-param初始化参数
        System.out.println("初始化参数username的值为:" + servletConfig.getInitParameter("username"));
        System.out.println("初始化参数url的值为:" + servletConfig.getInitParameter("url"));
        //获取ServletContext方法
        //System.out.println(servletConfig.getServletContext());
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        /*获取from提交方式是get还是post*/
        HttpServletRequest servletRequest1 = (HttpServletRequest) servletRequest;
        String method = servletRequest1.getMethod();
        if ("GET".equals(method)) {
            System.out.println("GET请求");
        } else if ("POST".equals(method)){
            System.out.println("POST请求");
        }
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("销毁方法");
    }
}
