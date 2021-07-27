package com.atwuhuai.service.impl;

import com.atwuhuai.dao.BookDao;
import com.atwuhuai.dao.OrderDao;
import com.atwuhuai.dao.OrderItemDao;
import com.atwuhuai.dao.impl.BookDaoimpl;
import com.atwuhuai.dao.impl.OrderDaoImpl;
import com.atwuhuai.dao.impl.OrderItemDaoImpl;
import com.atwuhuai.pojo.*;
import com.atwuhuai.service.BookServce;
import com.atwuhuai.service.OrderService;

import java.util.Date;
import java.util.List;
import java.util.Map;


public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao=new OrderDaoImpl();
    private  OrderItemDao orderItemDao=new OrderItemDaoImpl();
    private BookDao bookDao=new BookDaoimpl();
    @Override
    public String createOrder(Cart cart,Integer userId) {
        //时间戳:系统时间+用户id
        String orderId=System.currentTimeMillis()+""+userId;
        Order order = new Order(orderId,new Date(),cart.getTotalPrice(),0,userId);
        //保存订单信息
        orderDao.savaOrder(order);
        //遍历cartItem对象中的属性,转换为OrderItem对象
//        int i=0;
//         i=i/0;
        for (Map.Entry<Integer, CartItem> entry:cart.getCartItem().entrySet()){
            CartItem cartItem=entry.getValue();
            //转化CartItem成OrderItem
            OrderItem orderItem=new OrderItem(null,cartItem.getName(),cartItem.getCount(),cartItem.getPrice(),cartItem.getTotalPrice(),orderId);
            //保存订单项
            orderItemDao.savaOrderItem(orderItem);
            //订单结算后,图书的库存和销量要改变
            Book book = bookDao.queryBookById(cartItem.getId());
            book.setSales(book.getSales()+cartItem.getCount());
            book.setStock(book.getStock()-cartItem.getCount());
            bookDao.updateBook(book);
        }
        //结算之后清空购物车
        cart.clearCart();
        return orderId;
    }

    @Override
    public List<Order> showMyOrder(Integer userId) {
        return orderDao.queryOrderByUserId(userId);
    }

    @Override
    public List<OrderItem> showMyOrderDetails(String orderId) {
        return orderDao.queryOrderItemByOrderId(orderId);
    }

    @Override
    public int signForOrder(int status,String orderId) {
         return  orderDao.updateOrderStatus(status,orderId);
    }

    @Override
    public List<Order> showAllOrders() {
        return orderDao.queryAllOrders();
    }

    @Override
    public int sendOrder(String orderId) {
        orderDao.updateOrderStatus(1,orderId);
        return 1;
    }
}
