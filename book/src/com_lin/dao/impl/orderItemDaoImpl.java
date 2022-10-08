package com_lin.dao.impl;

import com_lin.dao.orderItemDao;
import com_lin.pojo.orderItem;

public class orderItemDaoImpl extends BaseDao implements orderItemDao {
    @Override
    public int orderItem(orderItem orderItem) {
        String sql="insert into t_order_item(`name`,`count`,`price`,`total_price`,`order_id`) values(?,?,?,?,?)";
        return update(sql,orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotalPrice(),orderItem.getOrderId());
    }
}
