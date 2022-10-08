package com_lin.service;

import com_lin.pojo.user;

public interface userService {

    /**
     * 注册用户
     * @param user
     */
    public void registerUser(user user);
    /**
     * 登录
     * @param user
     * @return
     */
    public user login(user user);
    /**
     * 检查用户名是否可用
     * @return true为用户名不可用.false为可用;
     */
    public boolean existUsername(String username);
}
