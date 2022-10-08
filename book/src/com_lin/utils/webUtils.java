package com_lin.utils;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class webUtils {
    public static <T> T copyParamToBean(T bean, Map value) {
        try {
            //把所有请求参数一次性的注入javaBean里
            //这里的注入是跟user的setxxx方法有关
            //把map的值注入到user中

            BeanUtils.populate(bean, value);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    /**
     * 将字符串转换为int类型
     *
     * @param strInt
     * @param defaultValue
     * @return
     */
    public static int parseInt(String strInt, int defaultValue) {
        try {
            return Integer.parseInt(strInt);
        } catch (NumberFormatException e) {
//            e.printStackTrace();
        }
        return defaultValue;
    }
}
