package ServletTest;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletContext_1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        //像map一样存取数据  ServletContext随着web工程部署而创建,停止而销毁;
        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("key1","value1");
        System.out.println(servletContext.getAttribute("key1"));
        /*因为一个web工程只有一个ServletContext实例,
        * 所以保存过后的context对象,从其他类可以获取到值,
        * 且web工程存在,值一直存在;*/
    }
}
