package com.atwuhuai.web;

import com.atwuhuai.pojo.Book;
import com.atwuhuai.pojo.Page;
import com.atwuhuai.service.BookServce;
import com.atwuhuai.service.impl.BookServiceImpl;
import com.atwuhuai.utils.web;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
public class BookServlet extends BaseServlet{
    //实例化业务对象
    private  BookServce bookServce=new BookServiceImpl();
    //添加图书信息
    protected void addBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //获取当前页码,溢出加1
        int pageNo = web.strToInt(request.getParameter("PageNo"), 0)+1;
        //添加图书信息
        bookServce.addBook( web.paramToBean(request.getParameterMap(), new Book()));
//        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request,response);
        //使用请求重定向防止表单重复提交
        response.sendRedirect(request.getContextPath()+"/manager/bookServlet?action=Page&PageNo="+pageNo);
    }
    //修改图书信息
    protected void updateBookInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取当前页码
        int pageNo = web.strToInt(request.getParameter("PageNo"), 1);
        //得到传过来的信息
        Book book = web.paramToBean(request.getParameterMap(), new Book());
        //调用service层的业务方法update
        bookServce.update(book);
        //请求重定向 查询所有图书信息
        response.sendRedirect(request.getContextPath()+"/manager/bookServlet?action=Page&PageNo="+pageNo);
    }
    //先将要修改的图书信息传递给BookServlet,
    protected void queryOneBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取当前页码
        int pageNo = web.strToInt(request.getParameter("PageNo"), 0);
        int id = web.strToInt(request.getParameter("id"),1);
        //通过id查找相应的图书信息
        Book book = bookServce.queryOneBookById(id);
        //保存到域中
        request.setAttribute("book",book);
        //请求转发
        request.getRequestDispatcher("/pages/manager/book_edit.jsp?PageNo="+pageNo).forward(request,response);
    }
    //通过id删除图书
    protected void deleteBookById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
               //得到图书编号
        Integer id = web.strToInt(request.getParameter("id"),1);
        int pageNo = web.strToInt(request.getParameter("PageNo"), 1);
        //调用deleteById的方法
        bookServce.deleteByid(id);
          //请求重定向
        response.sendRedirect(request.getContextPath()+"/manager/bookServlet?action=Page&PageNo="+pageNo);
    }
    //查询图书信息
    protected void queryBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取全部的图书信息
        List<Book> books = bookServce.queryAllBook();
        //将图书信息放入到域中
        request.setAttribute("books",books);
        //跳转至图书管理界面
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request,response);
    }
    //分页查询模块
    protected void Page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //获取PageNo(当前页码)和PageSize(当前页数据) 获取PageSize,当前页数据数
        int pageNo = web.strToInt(request.getParameter("PageNo"), 1);
        int pageSize = web.strToInt(request.getParameter("PageSize"), Page.PAGE_SIZI);
        //调用BookService.Page(PageNo,PageSize);方法
        Page page = bookServce.Page(pageNo, pageSize);
        //设置请求地址
        page.setUrl("manager/bookServlet?action=Page");
        //将Page对象放入Request域中
        request.setAttribute("Page",page);
        //请求转发至/pages/manager/book_manager.jsp界面
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request,response);
//        //获取指定页的数值
//        String pn = request.getParameter("pn");
//        int current_page = web.strToInt(pn, 1);
    }
}
