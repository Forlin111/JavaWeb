package com_lin.test;

import com_lin.dao.impl.orderDaoImpl;
import com_lin.dao.orderDao;
import com_lin.pojo.order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

public class orderDaoTest {

    @Test
    public void saveOrder() {
        orderDao orderDao=new orderDaoImpl();
        orderDao.saveOrder(new order("123456",new Date(),new BigDecimal(99.0),0,1));
    }
}