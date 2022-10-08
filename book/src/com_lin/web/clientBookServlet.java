package com_lin.web;

import com_lin.pojo.book;
import com_lin.pojo.page;
import com_lin.service.bookService;
import com_lin.service.impl.bookServiceImpl;
import com_lin.utils.webUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class clientBookServlet extends baseServlet{

    private bookService bookService=new bookServiceImpl();

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("client");
        int pageNo = webUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize =page.PAGE_SIZE;
        page<book> page= bookService.page(pageNo,pageSize);
        page.setUrl("client/bookServlet?action=page");
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/client/index1.jsp").forward(req,resp);
    }

    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("client");
        int pageNo = webUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize =webUtils.parseInt(req.getParameter("pageSize"),page.PAGE_SIZE);
        int min=webUtils.parseInt(req.getParameter("min"),0);
        int max=webUtils.parseInt(req.getParameter("max"),Integer.MAX_VALUE);
        page<book> page= bookService.pageByPrice(pageNo,pageSize,min,max);

        StringBuilder sb = new StringBuilder("client/bookServlet?action=pageByPrice");
        //如果有最小价格的参数,追加到分页条的地址中
        if (req.getParameter("min") != null) {
            sb.append("&min=").append(req.getParameter("min"));
        }
        //如果有最小价格的参数,追加到分页条的地址中
        if (req.getParameter("max") != null) {
            sb.append("&max=").append(req.getParameter("max"));
        }
        page.setUrl(sb.toString());
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/client/index1.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
