package com.atwuhuai.dao.impl;

import com.atwuhuai.dao.OrderDao;
import com.atwuhuai.pojo.Order;
import com.atwuhuai.pojo.OrderItem;

import java.util.List;

public class OrderDaoImpl extends BaseDao implements OrderDao {
    /**
     * order_id varchar(50) primary key,
     * create_time datetime,
     * price decimal(11,2),
     * status int,
     * user_id int,
     * @param order
     * @return
     */
    @Override
    //保存订单信息
    public int savaOrder(Order order) {
        String sql="insert into t_order(order_id,create_time,price,status,user_id) values(?,?,?,?,?)";
        return   update(sql,order.getOrder_id(),order.getCreate_time(),order.getPrice(),order.getStatus(),order.getUser_id());

    }
    //根据用户id查询订单
    @Override
    public List<Order> queryOrderByUserId(Integer userId) {
            String sql="select order_id,create_time,price,status,user_id from t_order where user_id=?";
            return queryList(Order.class,sql,userId);

    }

    @Override
    //根据订单号查询订单详情
    /**
     *  private Integer id;
     *     private String name;
     *     private Integer count;
     *     private BigDecimal price;
     *     private BigDecimal total_price;
     *     private String order_id;
     */
    public List<OrderItem> queryOrderItemByOrderId(String orderId) {
        String sql="select name,count,price,total_price from t_order_item where order_id=?";
        return queryList(OrderItem.class,sql,orderId);
    }

    @Override
    public int updateOrderStatus(int status,String order_id) {
//        "update t_book set `name`=? , `author`=? , `price`=? , `sales`=? , `stock`=? , `img_path`=? where id=?";
        String sql="update t_order set `status`=? where order_id=?";
        return update(sql,status,order_id);
    }

    @Override
    public List<Order> queryAllOrders() {
        String sql="select order_id,create_time,price,status,user_id from t_order";
        return queryList(Order.class,sql);
    }

}
