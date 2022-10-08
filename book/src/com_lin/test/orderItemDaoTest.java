package com_lin.test;

import com_lin.dao.impl.orderItemDaoImpl;
import com_lin.dao.orderItemDao;
import com_lin.pojo.orderItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class orderItemDaoTest {

    @Test
    public void orderItem() {
        orderItemDao orderItemDao=new orderItemDaoImpl();
        orderItemDao.orderItem(new orderItem(null,"java",1,new BigDecimal(99.0),new BigDecimal(999.0),"123456"));
    }
}