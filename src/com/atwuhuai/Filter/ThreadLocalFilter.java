package com.atwuhuai.Filter;

import com.atwuhuai.utils.JdbcUtils;

import javax.servlet.*;
import java.io.IOException;

public class ThreadLocalFilter implements Filter {
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        try {
            chain.doFilter(req, resp);
            //后置代码
            JdbcUtils.commitAndClose();//提交事务
        } catch (Exception e) {
            JdbcUtils.rollbackAndClose();//回滚事务
//            req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req,resp);
            throw new RuntimeException(e);//将错误信息抛出给Tomcat服务器统一管理
        }
    }
}
