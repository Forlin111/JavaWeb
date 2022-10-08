package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if ("hhj".equals(username) && "12345".equals(password)) {
            req.setAttribute("user",username);
            resp.getWriter().write("登录成功");
        }else {
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }
}
