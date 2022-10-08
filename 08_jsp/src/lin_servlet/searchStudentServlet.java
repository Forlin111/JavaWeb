package lin_servlet;

import pojo.student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class searchStudentServlet extends HttpServlet {
    //请求转发的使用说明
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数
        //使用for循环模拟sql查询到的数据
        int id = 0;
        String name = "lisa";
        List<student> students = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            students.add(new student(id + i, name + String.valueOf(i), 17 + i, String.valueOf(123456780 + i)));
        }
        //保存数据到request域中
        req.setAttribute("stuList",students);
        //请求转发数据到showStudent.jsp中
        req.getRequestDispatcher("/test/showStudent.jsp").forward(req,resp);
    }
}
