package lin.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*请求转发演示*/
        //在servlet1中获取参数
        String username = req.getParameter("username");
        System.out.println("servlet1参数:"+username);
        //设置一个值,传递到servlet2去查看
        req.setAttribute("key","servlet1_value");
        //传入请求转发的接收地址
        /* 以/开头解析地址 映射到web目录 */
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/servlet2");
        //传递到servlet2
        requestDispatcher.forward(req,resp);
    }
}
