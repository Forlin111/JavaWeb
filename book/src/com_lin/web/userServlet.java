package com_lin.web;

import com.google.gson.Gson;
import com_lin.pojo.user;
import com_lin.service.impl.userServiceImpl;
import com_lin.service.userService;
import com_lin.test.userServletTest;
import com_lin.utils.webUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class userServlet extends baseServlet {
    private com_lin.service.userService userService = new userServiceImpl();

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //这里处理登录功能
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //调用方法处理业务
        user loginUser = userService.login(new user(null, username, password, null));
        if (loginUser == null) {
            //说明登录失败
            //错误信息回显
            req.setAttribute("msg", "用户名或密码错误!!");
            req.setAttribute("username", username);
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        } else {
            //登录成功保存信息
            req.getSession().setAttribute("user", loginUser);
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }
    }

    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //这里处理注册功能
        //获取发送过来的请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        System.out.println(username + "" + password + "" + email + "" + code);

        user user = webUtils.copyParamToBean(new user(), req.getParameterMap());
        System.out.println(user);

        //验证验证码是否正确,先写死了
        if (token.equalsIgnoreCase(code)&&token!=null) {
            /*
                正确:检查用户名是否可用
             */
            if (userService.existUsername(username)) {
                //已存在
                req.setAttribute("msg", "用户名已存在!");
                req.setAttribute("username", username);
                req.setAttribute("email", email);
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
            req.setAttribute("msg", "验证码错误!!");
            req.setAttribute("username", username);
            req.setAttribute("email", email);
            req.setAttribute("code", code);
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }

    //        if ("login".equals(action)) {
//            login(req,resp);
//        } else if ("regist".equals(action)) {
//            regist(req, resp);
//        }
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //销毁session
        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath());
    }

    protected void ajaxExistUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String username = req.getParameter("username");
        boolean existUsername = userService.existUsername(username);
        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("existUsername",existUsername);

        Gson gson = new Gson();
        String json = gson.toJson(resultMap);
        resp.getWriter().write(json);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
