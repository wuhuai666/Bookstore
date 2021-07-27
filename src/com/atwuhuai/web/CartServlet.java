package com.atwuhuai.web;

import com.atwuhuai.pojo.Book;
import com.atwuhuai.pojo.Cart;
import com.atwuhuai.pojo.CartItem;
import com.atwuhuai.service.BookServce;
import com.atwuhuai.service.impl.BookServiceImpl;
import com.atwuhuai.utils.web;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CartServlet extends BaseServlet {
   private BookServce bookServce=new BookServiceImpl();
    //添加到购物车
    protected void addItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取商品的id
        int id = web.strToInt(request.getParameter("id"), 0);
        //使用bookService.query
        Book book = bookServce.queryOneBookById(id);
        //整合到CartItem中  id,  name, count,  price,  totalPrice
        CartItem cartItem=new CartItem(book.getId(),book.getName(),1,book.getPrice(),book.getPrice());
        //调用cart中的addItem方法
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart==null){
            cart =new Cart();
            //将cart对象保存至session中
            request.getSession().setAttribute("cart",cart);
        }
        cart.addItem(cartItem);
        //得到用户提交时的页面
        String referer = request.getHeader("Referer");
        //重定向到商品列表界面
        response.sendRedirect(referer);
        request.getSession().setAttribute("lastname",cartItem.getName());

    }
    protected void deleteItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = web.strToInt(request.getParameter("id"), 1);
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        //调用Cart对象的deleteById方法
        if (cart!=null){
            cart.deleteById(id);
        }
        //请求重定向到当前界面
        response.sendRedirect(request.getHeader("Referer"));
    }
    protected void clear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
       if (cart!=null){
           //调用cart中的clear
           cart.clearCart();
           //请求重定向到当前界面
           response.sendRedirect(request.getHeader("Referer"));
       }
    }
    protected void updateCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = web.strToInt(request.getParameter("id"), 0);
        int count = web.strToInt(request.getParameter("count"), 1);
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart!=null){
            cart.modifyCount(id,count);
            response.sendRedirect(request.getHeader("Referer"));
        }
    }
    protected void ajaxAddItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setContentType("text/html;charset=UTF-8");
        //获取商品的id
        int id = web.strToInt(request.getParameter("id"), 0);
        //使用bookService.query
        Book book = bookServce.queryOneBookById(id);
        //整合到CartItem中  id,  name, count,  price,  totalPrice
        CartItem cartItem=new CartItem(book.getId(),book.getName(),1,book.getPrice(),book.getPrice());
        //调用cart中的addItem方法
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart==null){
            cart =new Cart();
            //将cart对象保存至session中
            request.getSession().setAttribute("cart",cart);
        }
        cart.addItem(cartItem);
   //设置购物车商品数量和最后一件商品到json中
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("totalCount",cart.getTotalCount());
        map.put("lastName",cartItem.getName());
        Gson gson=new Gson();
        response.getWriter().write(gson.toJson(map));
    }
}
