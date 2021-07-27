package com.atwuhuai.web;

import com.atwuhuai.pojo.Cart;
import com.atwuhuai.pojo.Order;
import com.atwuhuai.pojo.OrderItem;
import com.atwuhuai.pojo.User;
import com.atwuhuai.service.OrderService;
import com.atwuhuai.service.impl.OrderServiceImpl;
import com.atwuhuai.utils.JdbcUtils;
import com.atwuhuai.utils.web;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderServlet extends BaseServlet {
   private OrderService orderService=new OrderServiceImpl();
    protected void createOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //得到session域中的cart对象
        Cart cart = (Cart) request.getSession().getAttribute("cart");
       //得到用户id
        int userId = web.strToInt(request.getParameter("userId"), 1);
        if (cart!=null){
            //已添加的订单,返回订单号
            String order = orderService.createOrder(cart, userId);
            //保存订单号到session域中.
            request.getSession().setAttribute("orderId",order);
            response.sendRedirect(request.getContextPath()+"/pages/cart/checkout.jsp");
        }
    }
    //用户查询订单
    protected void showMyOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //得到用户id
        int userId = web.strToInt(request.getParameter("userId"), 1);
        //调用orderService的方法,
        List<Order> orders = orderService.showMyOrder(userId);
        request.setAttribute("Order",orders);
        request.getRequestDispatcher("/pages/order/order.jsp").forward(request,response);
    }
    protected void orderDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //得到用户id
        String orderId = request.getParameter("orderId");
        //得到状态
        String status = request.getParameter("status");
        //调用orderService的方法,
        List<OrderItem> orderItems = orderService.showMyOrderDetails(orderId);
         //放入orderItem域中
        request.setAttribute("orderItem",orderItems);
        request.setAttribute("orderId",orderId);
        request.setAttribute("status",status);
        request.getRequestDispatcher("/pages/order/orderDetails.jsp").forward(request,response);
    }
    //用户签收订单
    protected void signForOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //得到订单号
        String orderId = request.getParameter("orderId");
        List<OrderItem> orderItems = orderService.showMyOrderDetails(orderId);
        //调用orderService层的signForOrder();方法
        int status=2;
        orderService.signForOrder(status, orderId);
//        request.setAttribute("status",2);
//        request.setAttribute("orderItem",orderItems);
//        request.getRequestDispatcher("/pages/order/orderDetails.jsp").forward(request,response);
        response.sendRedirect(request.getContextPath()+"/orderServlet?action=orderDetails&orderId="+orderId+"&status="+status);
    }
    //管理员查看所有订单
    protected void showAllOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //调用orderService层的showAllOrders方法.
        List<Order> orders = orderService.showAllOrders();
       //将orders集合放入request域中.
        request.setAttribute("orders",orders);
        request.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(request,response);
    }
    //管理员发货
    protected void sendOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取当前订单号
        String orderId = request.getParameter("orderId");
        //调用orderService层的sendOrder方法.
        int status = orderService.sendOrder(orderId);
        List<OrderItem> orderItems = orderService.showMyOrderDetails(orderId);
//        //将状态放入request域中
//        request.setAttribute("status",1);
//        request.setAttribute("orderItem",orderItems);
//        response.sendRedirect(request.getContextPath()+"/pages/order/orderDetails.jsp");
        response.sendRedirect(request.getContextPath()+"/orderServlet?action=orderDetails&orderId="+orderId+"&status="+status);
    }
}
