package com_lin.dao.impl;

import com_lin.utils.jdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {
    //使用DBUtils操作数据库
    private QueryRunner queryRunner=new QueryRunner();

    /**
     * 更新语句
     * @param sql
     * @param args  参数值
     * @return
     */
    public int update(String sql,Object ... args){
        Connection conn = jdbcUtils.getConnection();
        try {
            return queryRunner.update(conn,sql,args);//返回影响的行数
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //用完记得关闭连接,不然会出问题,因为配置文件里只允许10条
            jdbcUtils.close(conn);
        }
        return -1;
    }

    /**
     * 查询返回一个JavaBean的sql语句
     * @param type 返回的对象类型
     * @param sql
     * @param args  sql对应的参数值
     * @param <T>   返回类型的泛型
     * @return
     */
    public <T> T queryForOne(Class<T> type,String sql,Object ... args){
        Connection conn = jdbcUtils.getConnection();
        try {
            return queryRunner.query(conn,sql,new BeanHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbcUtils.close(conn);
        }
        return null;
    }

    /**
     * 查询返回多个javaBean的sql语句
     * @param type
     * @param sql
     * @param args
     * @param <T>
     * @return
     */
    public <T>List<T> queryForList(Class<T> type,String sql,Object ... args){
        Connection conn = jdbcUtils.getConnection();
        try {
            return queryRunner.query(conn,sql,new BeanListHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbcUtils.close(conn);
        }
        return null;
    }

    /**
     * 执行返回一行一列的的sql语句
     * @param sql
     * @param args
     * @return
     */
    public Object queryForSingleValue(String sql,Object ... args){
        Connection conn = jdbcUtils.getConnection();
        try {
            return queryRunner.query(conn,sql,new ScalarHandler(),args);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {

        }
        return null;
    }
}
