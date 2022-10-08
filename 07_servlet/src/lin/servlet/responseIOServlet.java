package lin.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class responseIOServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置服务器编码
        resp.setCharacterEncoding("UTF-8");
        //设置浏览器编码
        resp.setHeader("Content-Type","text/html;charset=UTF-8");
        //给客户端回传字符串数据
        PrintWriter writer = resp.getWriter();
        writer.write("黄慧静!!!!");
    }
}
