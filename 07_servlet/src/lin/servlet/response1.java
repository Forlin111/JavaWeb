package lin.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class response1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*System.out.println("response1");
        //设置响应状态码 表示重定向(已搬迁)
        resp.setStatus(302);
        //设置响应头,说明新的地址在哪
        resp.setHeader("location","http://localhost:8082/07_servlet/response2");
        //请求重定向可以访问工程外的资源
        //resp.setHeader("location","http://www.baidu.com");*/

        //第二种方案(推荐) 传入地址
        resp.sendRedirect("http://localhost:8082/07_servlet/response2");

    }
}
