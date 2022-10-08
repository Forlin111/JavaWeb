package com_lin.dao.impl;

import com_lin.dao.userDao;
import com_lin.pojo.user;

public class userDaoImpl extends BaseDao implements userDao {
    @Override
    public user queryUserByUsername(String username) {
        String sql = "select `id`,`username`,`password`,`email` from t_user where username = ?";
        return queryForOne(user.class, sql, username);
    }

    @Override
    public user queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select `id`,`username`,`password`,`email` from t_user where username = ? and password = ?";
        return queryForOne(user.class, sql, username, password);
    }

    @Override
    public int saveUser(user user) {
        String sql = "insert into t_user(`username`,`password`,`email`) values(?,?,?)";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }


}
