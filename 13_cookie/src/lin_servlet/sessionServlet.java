package lin_servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class sessionServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建和获取session
        HttpSession session = req.getSession();
        //判断当前session是否为新true为新
        boolean aNew = session.isNew();
        if (aNew) {
            System.out.println("新");
        }else {
            System.out.println("旧");
        }
        //获取session会话的唯一标识id
        String id = session.getId();
        System.out.println(id);

        ///设置session域的数据
        session.setAttribute("key1","value1");
        //获取session域数据
        String attribute = (String) session.getAttribute("key1");
        resp.getWriter().write(attribute);

        //获取session的默认超时时长 默认为30分钟
        System.out.println(req.getSession().getMaxInactiveInterval());
        //设置个别的session的超时时长
        session.setMaxInactiveInterval(1200);
        //设置session马上超时
        session.invalidate();
    }
}
