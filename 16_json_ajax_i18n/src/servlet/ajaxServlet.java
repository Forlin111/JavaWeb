package servlet;

import com.google.gson.Gson;
import pojo.person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ajaxServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("ajax");
//    }
//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("ajax");
//        resp.setContentType("text/html;charset=UTF-8");
//        person person = new person(1,"黄慧静");
//        Gson gson = new Gson();
//        String json = gson.toJson(person);
//        resp.getWriter().write(json);
//    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        person person = new person(1,"黄慧静");
        Gson gson = new Gson();
        String json = gson.toJson(person);
        resp.getWriter().write(json);
        System.out.println("1111");
    }
}
