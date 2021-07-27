package com.atwuhuai.dao;

import com.atwuhuai.pojo.OrderItem;

public interface OrderItemDao {
    //保存订单项.
    public int savaOrderItem(OrderItem orderItem);
}
