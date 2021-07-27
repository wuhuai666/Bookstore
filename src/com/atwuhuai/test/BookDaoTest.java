package com.atwuhuai.test;

import com.atwuhuai.dao.BookDao;
import com.atwuhuai.dao.impl.BookDaoimpl;
import com.atwuhuai.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookDaoTest {
private BookDao bookDao=new BookDaoimpl();
    @Test
    public void addBook() {
        Book book = new Book(null, "高等数学一", "菜市场老师", new BigDecimal(23.6), 56, 23, null);
        //返回影响的行数
        int i = bookDao.addBook(book);
        System.out.println(i);
    }

    @Test
    public void deleteBookById() {
       //删除id为23的图书信息.
        int i = bookDao.deleteBookById(21);
        System.out.println(i);
    }

    @Test
    //修改图书信息.
    public void updateBook() {
        bookDao.updateBook(new Book(20,"星月神话","国哥",new BigDecimal(20.33),12,20,null));
    }

    @Test
    //通过id查询一条图书信息
    public void queryBookById() {
        Book book = bookDao.queryBookById(20);
        System.out.println(book.toString());
    }

    @Test
    public void queryAllBooks() {
        List<Book> books = bookDao.queryAllBooks();
        System.out.println(books);
    }
    @Test
    public void count() {
        System.out.println(bookDao.queryForCount());
    }
    @Test
   public void items(){
        List<Book> books = bookDao.queryForItems(0, 4);
        System.out.println(books);
    }
}