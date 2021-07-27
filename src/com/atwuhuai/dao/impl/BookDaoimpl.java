package com.atwuhuai.dao.impl;

import com.atwuhuai.dao.BookDao;
import com.atwuhuai.pojo.Book;
import com.atwuhuai.pojo.Page;

import java.util.List;

public class BookDaoimpl  extends BaseDao implements BookDao {
    //添加图书
    @Override
    public int addBook(Book book) {
        String sql="insert into t_book(`name` , `author` , `price` , `sales` , `stock` , `img_path`) values(?,?,?,?,?,?) ";
        return update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImg_path());

    }
    @Override
    public int deleteBookById(Integer id) {
        String sql="delete from t_book where id=? ";
        return update(sql,id);
    }
    @Override
    public int updateBook(Book book) {
        String sql="update t_book set `name`=? , `author`=? , `price`=? , `sales`=? , `stock`=? , `img_path`=? where id=?";
        return update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImg_path(),book.getId());
    }
    @Override
    public Book queryBookById(Integer id) {
        String sql="select id,name, author, price, sales, stock, img_path from t_book where id=?";
        return queryForOne(Book.class,sql,id);
    }
    @Override
    public List<Book> queryAllBooks() {
        String sql="select id,name, author, price, sales, stock, img_path  from t_book ";
        return queryList(Book.class,sql);
    }

    @Override
    public Integer queryForCount() {
        String sql="select count(*) from t_book";
        Number count = (Number) querySingleValue(sql);
        return count.intValue();
    }

    @Override
    public List<Book> queryForItems(int begin,int pageSize) {
        String sql="select id,name, author, price, sales, stock, img_path from t_book limit ?,? ";
        return queryList(Book.class,sql,begin,pageSize);
    }

    @Override
    public int queryForCountByPrice(int min, int max) {
        String sql="select count(*) from t_book where price between ? and ?";
        Number count = (Number) querySingleValue(sql,min,max);
        return count.intValue();
    }

    @Override
    public List<Book> queryForItemsByPrice(int begin, int pageSize, int min, int max) {
        String sql="select id,name, author, price, sales, stock, img_path from t_book where price between ? and ? order by price limit ?,? ";
        return queryList(Book.class,sql,min,max,begin,pageSize);
    }
}
