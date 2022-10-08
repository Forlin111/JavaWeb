package com_lin.test;

import com_lin.pojo.user;
import com_lin.service.impl.userServiceImpl;
import com_lin.service.userService;
import org.junit.Test;

import static org.junit.Assert.*;

public class userServiceTest {
    userService userService=new userServiceImpl();

    @Test
    public void registerUser() {
        userService.registerUser(new user(null,"hhj123","123456","tzk@lin.com"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new user(null,"hhj123","123456",null)));
    }

    @Test
    public void existUsername() {
        if (userService.existUsername("hhj123")) {
            System.out.println("存在");
        }else {
            System.out.println("不存在");
        }
    }
}