package com_lin.service.impl;

import com_lin.dao.impl.userDaoImpl;
import com_lin.pojo.user;
import com_lin.service.userService;

public class userServiceImpl implements userService {
    /**
     * 因为要操作数据库,所以引入Dao操作
     */
    private userDaoImpl userDao = new userDaoImpl();


    @Override
    public void registerUser(user user) {
        if (existUsername(user.getUsername()) == false) {
            userDao.saveUser(user);
        }
    }

    @Override
    public user login(user user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existUsername(String username) {
        if (userDao.queryUserByUsername(username) == null) {
            //说明用户名可用
            return false;
        }
        return true;
    }
}
