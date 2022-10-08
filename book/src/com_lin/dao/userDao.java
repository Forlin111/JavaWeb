package com_lin.dao;

import com_lin.pojo.user;

public interface userDao {

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return 如果返回null则没有此用户;
     */
    public user queryUserByUsername(String username);

    /**
     * 根据用户名及密码查询用户信息
     * @param username
     * @param password
     * @return 如果返回null则说明用户名或者密码错误;
     */
    public user queryUserByUsernameAndPassword(String username, String password);

    /**
     * 保存用户信息
     * @return
     */
    public int saveUser(user user);


}
