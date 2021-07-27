package com.atwuhuai.pojo;

import java.math.BigDecimal;

/**
 * create table t_order_item(
 * id int primary key auto_increment,
 * name varchar(100),
 * count int,
 * price decimal(11,2),
 * total_price decimal(11,2),
 * order_id varchar(50),
 * foreign key(order_id) references  t_order(order_id)
 * );
 */
public class OrderItem {
    private Integer id;
    private String name;
    private Integer count;
    private BigDecimal price;
    private BigDecimal total_price;
    private String order_id;

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", total_price=" + total_price +
                ", order_id='" + order_id + '\'' +
                '}';
    }
    public OrderItem() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotal_price() {
        return total_price;
    }

    public void setTotal_price(BigDecimal total_price) {
        this.total_price = total_price;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public OrderItem(Integer id, String name, Integer count, BigDecimal price, BigDecimal total_price, String order_id) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.price = price;
        this.total_price = total_price;
        this.order_id = order_id;
    }
}
