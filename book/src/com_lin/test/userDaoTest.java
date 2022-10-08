package com_lin.test;

import com_lin.dao.impl.userDaoImpl;
import com_lin.dao.userDao;
import com_lin.pojo.user;
import org.junit.Test;

import static org.junit.Assert.*;

public class userDaoTest {
    userDao userDao = new userDaoImpl();

    @Test
    public void queryUserByUsername() {
        if (userDao.queryUserByUsername("admin1234") == null) {
            System.out.println("用户名可用！");
        } else {
            System.out.println("用户名已存在！");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        if (userDao.queryUserByUsernameAndPassword("admin", "admin1234") == null) {
            System.out.println("用户名或密码错误，登录失败");
        } else {
            System.out.println("查询成功");
        }
    }

    @Test
    public void saveUser() {
        System.out.println(userDao.saveUser(new user(null, "hhj123", "123456", "hhj@lin.com")));
    }
}