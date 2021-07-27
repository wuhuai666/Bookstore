package com.atwuhuai.service;

import com.atwuhuai.pojo.Cart;
import com.atwuhuai.pojo.Order;
import com.atwuhuai.pojo.OrderItem;

import java.util.List;

public interface OrderService {
    //生成订单
    public String createOrder(Cart cart,Integer userId);
    //用户查看订单
    public List<Order> showMyOrder(Integer userId);
    //根据订单号查询订单详情
    public List<OrderItem> showMyOrderDetails(String orderId);
     public int signForOrder(int status,String orderId);

     public List<Order> showAllOrders();
//发货
     public int sendOrder(String orderId);
}
