package com.atwuhuai.pojo;

import java.math.BigDecimal;

public class Book {
    /**
     create table t_book(
     `id` int(11) primary key auto_increment, 	## 主键
     `name` varchar(50) not null,				## 书名
     `author` varchar(50) not null,				## 作者
     `price` decimal(11,2) not null,				## 价格
     `sales` int(11) not null,					## 销量
     `stock` int(11) not null,					## 库存
     `img_path` varchar(200) not null			## 书的图片路径
     );
     */
    private Integer id;
    private String name;
    private String author;
     private BigDecimal price;
    private Integer  sales;
    private Integer stock;
    private String img_path="static/img/default.jpg";
    public Book(){

    }
    public Book(Integer id, String name, String author, BigDecimal price, Integer sales, Integer stock, String img_path) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        this.sales = sales;
        this.stock = stock;
        if(img_path!=null&& !"".equals(img_path))
        this.img_path = img_path;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getImg_path() {
        return img_path;
    }

    public void setImg_path(String img_path) {
        if(img_path!=null&& !"".equals(img_path))
        this.img_path = img_path;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", sales=" + sales +
                ", stock=" + stock +
                ", img_path='" + img_path + '\'' +
                '}';
    }
}
