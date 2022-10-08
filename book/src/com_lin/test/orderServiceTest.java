package com_lin.test;

import com_lin.pojo.cart;
import com_lin.pojo.cartItem;
import com_lin.service.impl.orderServiceImpl;
import com_lin.service.orderService;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class orderServiceTest {

    @Test
    public void createOrder() {
        cart cart = new cart();
        cart.addItem(new cartItem(1,"lin",1,new BigDecimal(99.0),new BigDecimal(999)));
        cart.addItem(new cartItem(1,"lin",1,new BigDecimal(99.0),new BigDecimal(999)));
        cart.addItem(new cartItem(2,"lin2 ",1,new BigDecimal(99.0),new BigDecimal(999)));
        orderService orderService=new orderServiceImpl();
        System.out.println(orderService.createOrder(cart, 1));
    }
}