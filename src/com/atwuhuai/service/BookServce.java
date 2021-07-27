package com.atwuhuai.service;

import com.atwuhuai.pojo.Book;
import com.atwuhuai.pojo.Page;

import java.util.List;

public interface BookServce {
    public void addBook(Book book);
    public void deleteByid(Integer id);
    public  void update(Book book);
    public Book queryOneBookById(Integer id);
    public List<Book> queryAllBook();
    public Page Page(int pageNo, int pageSize);
    public Page PageByPrice(int pageNo, int pageSize, int min, int max);
}
