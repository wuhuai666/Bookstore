package com.atwuhuai.pojo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * create table t_order(
 * order_id varchar(50) primary key,
 * create_time datetime,
 * price decimal(11,2),
 * status int,
 * user_id int,
 * foreign key(user_id) references t_users(id)
 * );
 */
public class Order {
    private String order_id;   //订单号
    private Date   create_time; //订单时间
    private BigDecimal price; //订单价格
    //0表示未发货,1已发货,2表示已签收
    private  Integer status=0;//订单状态
    private Integer user_id;//用户编号
    public Order() {
    }
    public Order(String order_id, Date create_time, BigDecimal price, Integer status, Integer user_id) {
        this.order_id = order_id;
        this.create_time = create_time;
        this.price = price;
        this.status = status;
        this.user_id = user_id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id='" + order_id + '\'' +
                ", create_time=" + create_time +
                ", price=" + price +
                ", status=" + status +
                ", user_id=" + user_id +
                '}';
    }
}
