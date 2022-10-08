package lin_servlet;

import util.getCookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class cookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决响应乱码
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        //创建cookie对象
        Cookie cookie = new Cookie("key1", "value1");
        //停止客户端保存cookie
        resp.addCookie(cookie);

        resp.getWriter().write("cookie创建成功");
        System.out.println("cookie创建成功");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            resp.getWriter().write("cookie[" + cookie.getName() + "=" + cookie.getValue() + "]");
        }
        //修改cookie值  一
        //创建一个同名cookie赋予新的值
        Cookie cookie = new Cookie("key1", "newValue1");
        resp.addCookie(cookie);

        //二 先找到要修改的cookie,在调用方法修改value值
        Cookie cookies1 = getCookie.getCookies("key1", req.getCookies());
        if (cookies1 != null) {
            cookies1.setValue("newValue2");
            resp.addCookie(cookies1);
        }

//        cookie的生命周期
        Cookie cookie1 = new Cookie("delLife","delLife1");
        cookie1.setMaxAge(-1);
        resp.addCookie(cookie1);

        //设置指定的cookie声明周期
        Cookie cookies2 = getCookie.getCookies("key1",req.getCookies());
        if (cookies2 != null) {
            cookies2.setMaxAge(0);
            resp.addCookie(cookies2);
        }

        //设置cookie的path路径
        Cookie cookie3 = new Cookie("key3", "value3");
        cookie3.setPath(req.getContextPath()+"/abc");
        resp.addCookie(cookie3);
        resp.getWriter().write("设置path");
    }
}

