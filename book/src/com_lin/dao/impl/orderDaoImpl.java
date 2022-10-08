package com_lin.dao.impl;

import com_lin.dao.orderDao;
import com_lin.pojo.order;

public class orderDaoImpl extends BaseDao implements orderDao {
    @Override
    public int saveOrder(order order) {
        String sql="insert into t_order(`order_id`,`create_time`,`price`,`status`,`user_id`) values(?,?,?,?,?)";
        return update(sql,order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId());
    }
}
