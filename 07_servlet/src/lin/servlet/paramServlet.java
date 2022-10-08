package lin.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class paramServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("--------doget--------");
        String username = req.getParameter("username");
        System.out.println(username);
        String password = req.getParameter("password");
        System.out.println(password);
        String hobby = req.getParameter("hobby");
        System.out.println(hobby);
        //当提交多个值时
        String[] hobbies = req.getParameterValues("hobby");
        System.out.println(Arrays.asList(hobbies));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("--------dopost--------");
        /*post请求传递中文时会出现乱码,要设置编码格式*/
        //必须在获取请求参数之前调用才行
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        System.out.println(username);
        String password = req.getParameter("password");
        System.out.println(password);
        String hobby = req.getParameter("hobby");
        System.out.println(hobby);
        //当提交多个值时
        String[] hobbies = req.getParameterValues("hobby");
        System.out.println(Arrays.asList(hobbies));
    }
}
