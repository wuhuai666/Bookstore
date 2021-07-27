package com.atwuhuai.dao;

import com.atwuhuai.pojo.Order;
import com.atwuhuai.pojo.OrderItem;

import java.util.List;

public interface OrderDao {
    //保存订单信息
    public int savaOrder(Order order);
    //根据用户id查询订单
    public List<Order> queryOrderByUserId(Integer userId);
    //根据订单号查看订单详情
    public List<OrderItem> queryOrderItemByOrderId(String orderId);
//更新订单状态
     public int updateOrderStatus(int status,String order_id);

     public  List<Order> queryAllOrders();
}
