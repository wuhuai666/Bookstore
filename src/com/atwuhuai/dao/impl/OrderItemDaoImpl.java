package com.atwuhuai.dao.impl;

import com.atwuhuai.dao.OrderItemDao;
import com.atwuhuai.pojo.OrderItem;

public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    @Override
    //保存订单项信息
    /**
     * id int primary key auto_increment,
     * name varchar(100),
     * count int,
     * price decimal(11,2),
     * total_price decimal(11,2),
     * order_id varchar(50),
     */
    public int savaOrderItem(OrderItem orderItem) {
        String sql="insert into t_order_item(name,count,price,total_price,order_id) values(?,?,?,?,?)";
        return update(sql,orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotal_price(),orderItem.getOrder_id());
    }
}
