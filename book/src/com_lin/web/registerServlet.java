package com_lin.web;

import com_lin.pojo.user;
import com_lin.service.impl.userServiceImpl;
import com_lin.service.userService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class registerServlet extends HttpServlet {
    private userService userService = new userServiceImpl();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取发送过来的请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        System.out.println(username+""+password+""+email+""+code);

        //验证验证码是否正确,先写死了
        if ("6n6np".equalsIgnoreCase(code)) {
            /*
                正确:检查用户名是否可用

             */
            if (userService.existUsername(username)) {
                //已存在
                req.setAttribute("msg","用户名已存在!");
                req.setAttribute("username",username);
                req.setAttribute("email",email);
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } else {
                //未存在 可用
                //调用service保存到数据库里
                userService.registerUser(new user(null, username, password, email));
                //跳转到成功页面
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }
        } else {
            /*
            不正确 跳回注册页面
             */
            //错误信息回显
            req.setAttribute("msg","验证码错误!!");
            req.setAttribute("username",username);
            req.setAttribute("email",email);
            req.setAttribute("code",code);
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }
}
