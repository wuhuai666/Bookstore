package com.atwuhuai.test;

import com.atwuhuai.dao.OrderItemDao;
import com.atwuhuai.dao.OrderDao;
import com.atwuhuai.dao.impl.OrderDaoImpl;
import com.atwuhuai.dao.impl.OrderItemDaoImpl;
import com.atwuhuai.pojo.Cart;
import com.atwuhuai.pojo.CartItem;
import com.atwuhuai.pojo.Order;
import com.atwuhuai.pojo.OrderItem;
import com.atwuhuai.service.OrderService;
import com.atwuhuai.service.impl.OrderServiceImpl;
import com.atwuhuai.utils.JdbcUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *    private String order_id;   //订单号
 *     private Date   create_time; //订单时间
 *     private BigDecimal price; //订单价格
 *     //0表示未发货,1已发货,2表示已签收
 *     private  Integer status=0;//订单状态
 *     private Integer user_id;//用户编号
 */
public class OrderItemImplTest {
    private  OrderDao orderDao=new OrderDaoImpl();
 @Test
    public void test1(){
     Order order=new Order("111111",new Date(),new BigDecimal(100),0,1);
     OrderDao orderDao=new OrderDaoImpl();
     orderDao.savaOrder(order);
 }

    /**
     *   private Integer id;
     *     private String name;
     *     private Integer count;
     *     private BigDecimal price;
     *     private BigDecimal total_price;
     *     private String order_id;
     */
    @Test
    public void test2(){
        OrderItem orderItem=new OrderItem(null,"java",1,new BigDecimal(111),new BigDecimal(111),"111111");
        OrderItemDao orderItemDao=new OrderItemDaoImpl();
        orderItemDao.savaOrderItem(orderItem);
    }
    @Test
    public void test3(){
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"java",1,new BigDecimal(111),new BigDecimal(111)));
        OrderService orderService=new OrderServiceImpl();
        String order = orderService.createOrder(cart, 1);
        System.out.println(order);
    }
    @Test
    public  void test4(){
         List<Order> orders = orderDao.queryOrderByUserId(6);
        for (Order order:orders){
            System.out.println(order);
        }
    }
    @Test
    public  void test5(){
        List<OrderItem> orderItems = orderDao.queryOrderItemByOrderId("16272825597816");
        System.out.println(orderItems);
    }
    @Test
    public  void test6(){
        int i = orderDao.updateOrderStatus(2, "16273006190446");
    }
    @Test
    public  void test7(){
        List<Order> orders = orderDao.queryAllOrders();
        System.out.println(orders);
    }
}