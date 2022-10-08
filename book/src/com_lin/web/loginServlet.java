package com_lin.web;

import com_lin.pojo.user;
import com_lin.service.impl.userServiceImpl;
import com_lin.service.userService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class loginServlet extends HttpServlet {

    private userService userService=new userServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //调用方法处理业务
        user loginUser = userService.login(new user(null, username, password, null));
        if (loginUser == null) {
            //说明登录失败
            //错误信息回显
            req.setAttribute("msg","用户名或密码错误!!");
            req.setAttribute("username",username);
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }else {
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);

        }
    }
}
