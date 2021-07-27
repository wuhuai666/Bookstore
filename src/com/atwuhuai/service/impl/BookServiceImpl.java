package com.atwuhuai.service.impl;

import com.atwuhuai.dao.BookDao;
import com.atwuhuai.dao.impl.BookDaoimpl;
import com.atwuhuai.pojo.Book;
import com.atwuhuai.pojo.Page;
import com.atwuhuai.service.BookServce;

import java.util.List;

public class BookServiceImpl implements BookServce {
private BookDao bookDao=new BookDaoimpl();
    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteByid(Integer id) {
           bookDao.deleteBookById(id);
    }

    @Override
    public void update(Book book) {
           bookDao.updateBook(book);
    }

    @Override
    public Book queryOneBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryAllBook() {
        return bookDao.queryAllBooks();
    }

    @Override
    public Page Page(int pageNo, int pageSize) {
        Page<Book> page=new Page<Book>();
        //总记录数,调用Dao层的queryForCount();
        int count = bookDao.queryForCount();
        page.setPageTotalCount(count);
        //总页码数=总数据数/每页的数据量
        Integer pageCount=count/pageSize;
        //如果总数量和每页数据量取余不等于0,则页码数加1
        if (count%pageSize>0) pageCount++;
        page.setPageTotal(pageCount);
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        //当前页的数据,调用dao层的queryForItems()
        int begin=(page.getPageNo()-1)*pageSize;
        List<Book> books = bookDao.queryForItems(begin,pageSize);
        page.setPageItems(books);
        return page;
    }

    @Override
    public Page PageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<Book> page=new Page<Book>();
        //总记录数,调用Dao层的queryForCount();
        int count = bookDao.queryForCountByPrice(min,max);
        page.setPageTotalCount(count);
        //总页码数=总数据数/每页的数据量
        Integer pageCount=count/pageSize;
        //如果总数量和每页数据量取余不等于0,则页码数加1
        if (count%pageSize>0) pageCount++;
        page.setPageTotal(pageCount);
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        //当前页的数据,调用dao层的queryForItemsByPrice()
        int begin=(page.getPageNo()-1)*pageSize;
        List<Book> books = bookDao.queryForItemsByPrice(begin,pageSize,min,max);
        page.setPageItems(books);
        return page;
    }
}
