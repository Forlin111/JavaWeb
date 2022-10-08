package lin.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestServletAPI extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的资源路径
        System.out.println(req.getRequestURI());
        //获取资源的绝对路径
        System.out.println(req.getRequestURL());
        //获取客户端的IP地址
        System.out.println(req.getRemoteHost());
        //获取请求头
        System.out.println(req.getHeader("User-Agent"));
    }
}
