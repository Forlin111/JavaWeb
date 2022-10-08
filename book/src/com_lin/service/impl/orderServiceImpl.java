package com_lin.service.impl;

import com_lin.dao.bookDao;
import com_lin.dao.impl.bookDaoImpl;
import com_lin.dao.impl.orderDaoImpl;
import com_lin.dao.impl.orderItemDaoImpl;
import com_lin.dao.orderDao;
import com_lin.dao.orderItemDao;
import com_lin.pojo.*;
import com_lin.service.orderService;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

public class orderServiceImpl implements orderService {
    private orderDao orderDao = new orderDaoImpl();
    private orderItemDao orderItemDao = new orderItemDaoImpl();
    private bookDao bookDao=new bookDaoImpl();

    @Override
    public String createOrder(cart cart, Integer userId) {
        //订单号 保证唯一
        String orderId = System.currentTimeMillis() + "" + userId;
        order order = new order(orderId, new Date(), cart.getTotalPrice(), 0, userId);
        orderDao.saveOrder(order);
        //遍历每一个商品项保存为订单项保存到数据库
        for (Map.Entry<Integer, cartItem> entry : cart.getItems().entrySet()) {
            //获取购物车每一个商品项
            cartItem cartItem = entry.getValue();
            //转换为订单项
            orderItem orderItem = new orderItem(null, cartItem.getName(), cartItem.getCount(), cartItem.getPrice(), cartItem.getTotalPrice(), orderId);
            //保存到数据库
            orderItemDao.orderItem(orderItem);
            //更新库存和销量
            book book = bookDao.queryBookById(cartItem.getId());
            book.setSales(book.getSales()+cartItem.getCount());
            book.setStock(book.getStock()-cartItem.getCount());
            bookDao.updateBook(book);
        }
        cart.clear();
        return orderId;
    }
}
