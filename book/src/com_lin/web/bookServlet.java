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
import java.util.List;

public class bookServlet extends baseServlet {
    private bookService bookService = new bookServiceImpl();

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        book book = webUtils.copyParamToBean(new book(), req.getParameterMap());
        bookService.addBook(book);
        //使用重定向
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page");
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = webUtils.parseInt(req.getParameter("id"), 0);
        bookService.deleteBookById(id);
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page");
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        book book = webUtils.copyParamToBean(new book(), req.getParameterMap());
        bookService.updateBook(book);
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page");
    }

    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = webUtils.parseInt(req.getParameter("id"), 0);
        book book = bookService.queryBookById(id);
        req.setAttribute("book", book);
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req, resp);
    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
        通过bookService查询所有的图书
        把全部图书保存到域中
        请求转发到/pages/manager/book_manager/jsp下
         */
        List<book> books = bookService.queryBooks();
        req.setAttribute("books", books);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
        return;
    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
//    }

    /**
     * 处理分页功能
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = webUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize =page.PAGE_SIZE;
        System.out.println(pageNo+"11"+pageSize);
        page<book> page=bookService.page(pageNo,pageSize);
        page.setUrl("manager/bookServlet?action=page");
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp?pageNo=1").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
