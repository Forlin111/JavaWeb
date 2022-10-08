package com_lin.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class userServletTest {
    /*
    通过反射来得到对应的方法
     */
    public void login(){
        System.out.println("login");
    }
    public void regist(){
        System.out.println("regist");
    }

    public static void main(String[] args) {
        String action="login";
        try {
            //方法反射对象
            Method method = userServletTest.class.getDeclaredMethod(action);
            //调用目标方法
            method.invoke(new userServletTest());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
