package com.atwuhuai.dao;

import com.atwuhuai.pojo.Book;

import java.util.List;

public interface BookDao {
    public  int addBook(Book book);  //添加图书
    public  int deleteBookById(Integer id); //删除图书
    public  int updateBook(Book book); //更新图书
    public Book queryBookById(Integer id); //通过id查询图书
    public List<Book> queryAllBooks(); //通过集合返回所有图书信息.

     public Integer queryForCount();//求数据的数量

     public List<Book> queryForItems(int begin,int pageSize); //返回数据

    int queryForCountByPrice(int min, int max);

     public List<Book> queryForItemsByPrice(int begin, int pageSize, int min, int max);
}
