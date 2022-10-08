package com_lin.web;

import com.google.gson.Gson;
import com_lin.pojo.book;
import com_lin.pojo.cart;
import com_lin.pojo.cartItem;
import com_lin.service.bookService;
import com_lin.service.impl.bookServiceImpl;
import com_lin.utils.webUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class cartServlet extends baseServlet {
    private bookService bookService = new bookServiceImpl();

    /**
     * 加入购物车功能
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = webUtils.parseInt(req.getParameter("id"), 0);
        book book = bookService.queryBookById(id);
        cartItem cartItem = new cartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
        cart cart = (cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new cart();
            req.getSession().setAttribute("cart", cart);
        }
        cart.addItem(cartItem);
//        Map<Integer, com_lin.pojo.cartItem> items = cart.getItems();
//        for (Map.Entry<Integer,cartItem> entry:items.entrySet()){
//            System.out.println(entry);
//        }
        resp.sendRedirect(req.getHeader("Referer"));
        req.getSession().setAttribute("lastName", cartItem.getName());
    }

    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = webUtils.parseInt(req.getParameter("id"), 0);
        cart cart = (cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            cart.deleteItem(id);
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        cart cart = (cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            cart.clear();
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    protected void updateCount1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = webUtils.parseInt(req.getParameter("id"), 0);
        int count = webUtils.parseInt(req.getParameter("count"), 1);
        cart cart = (com_lin.pojo.cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            cart.updateCount(id, count);
            resp.sendRedirect(req.getHeader("Referer"));
            System.out.println(req.getHeader("Referer"));
        }
    }

    protected void ajaxAddItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = webUtils.parseInt(req.getParameter("id"), 0);
        book book = bookService.queryBookById(id);
        cartItem cartItem = new cartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
        cart cart = (cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new cart();
            req.getSession().setAttribute("cart", cart);
        }
        cart.addItem(cartItem);
        req.getSession().setAttribute("lastName", cartItem.getName());
        Map<String,Object> map=new HashMap<>();
        map.put("totalCount",cart.getTotalCount());
        map.put("lastName",cartItem.getName());
        Gson gson = new Gson();
        String s = gson.toJson(map);
        resp.getWriter().write(s);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
