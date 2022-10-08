package com_lin.test;

import com_lin.pojo.cart;
import com_lin.pojo.cartItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class cartTest {

    @Test
    public void addItem() {
        cart cart = new cart();
        cart.addItem(new cartItem(1,"lin",1,new BigDecimal(99.0),new BigDecimal(999)));
        cart.addItem(new cartItem(1,"lin",1,new BigDecimal(99.0),new BigDecimal(999)));
        cart.addItem(new cartItem(2,"lin2 ",1,new BigDecimal(99.0),new BigDecimal(999)));
        System.out.println(cart);
    }

    @Test
    public void deleteItem() {
        cart cart = new cart();
        cart.addItem(new cartItem(1,"lin",1,new BigDecimal(99.0),new BigDecimal(999)));
        cart.addItem(new cartItem(1,"lin",1,new BigDecimal(99.0),new BigDecimal(999)));
        cart.addItem(new cartItem(2,"lin2 ",1,new BigDecimal(99.0),new BigDecimal(999)));
        cart.deleteItem(1);
        System.out.println(cart);
    }

    @Test
    public void clear() {
        cart cart = new cart();
        cart.addItem(new cartItem(1,"lin",1,new BigDecimal(99.0),new BigDecimal(999)));
        cart.addItem(new cartItem(1,"lin",1,new BigDecimal(99.0),new BigDecimal(999)));
        cart.addItem(new cartItem(2,"lin2 ",1,new BigDecimal(99.0),new BigDecimal(999)));
        cart.deleteItem(1);
        cart.clear();
        System.out.println(cart);
    }

    @Test
    public void updateCount() {
        cart cart = new cart();
        cart.addItem(new cartItem(1,"lin",1,new BigDecimal(99.0),new BigDecimal(999)));
        cart.addItem(new cartItem(1,"lin",1,new BigDecimal(99.0),new BigDecimal(999)));
        cart.addItem(new cartItem(2,"lin2 ",1,new BigDecimal(99.0),new BigDecimal(999)));
        cart.updateCount(2,4);
        System.out.println(cart);
    }
}