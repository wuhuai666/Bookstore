package com.atwuhuai.web;
import com.atwuhuai.pojo.Book;
import com.atwuhuai.utils.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
public abstract class BaseServlet extends HttpServlet {
   protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

       doPost(request,response);
   }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.setCharacterEncoding("UTF-8");
       String action = request.getParameter("action");
//        System.out.println("1111"+action);
        try {
            //利用反射调用相关的请求
            Method declaredMethod = this.getClass().getDeclaredMethod(action,HttpServletRequest.class, HttpServletResponse.class);
            //执行方法      当前的对象实例
            declaredMethod.invoke(this,request,response);
        } catch (Exception e) {
           throw new RuntimeException(e);//抛出异常给ThreadLocalfilter过滤器
        }
    }
}
