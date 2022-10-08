package com_lin.test;

import com_lin.utils.jdbcUtils;
import org.junit.Test;

import java.sql.Connection;

public class jdbcUtilsTest {
    @Test
    public void test(){
        for (int i = 0; i < 100; i++) {
            Connection connection = jdbcUtils.getConnection();
            System.out.println(connection);
            jdbcUtils.close(connection);
        }
    }
}
