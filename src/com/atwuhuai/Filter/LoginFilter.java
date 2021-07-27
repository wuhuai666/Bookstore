package com.atwuhuai.Filter;

import com.atwuhuai.pojo.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
       HttpServletRequest servletRequest= (HttpServletRequest) req;
        //得到session域中的user对象
        User user = (User) servletRequest.getSession().getAttribute("user");
        if (user==null){
            //为空,则表示用户还没有登录,跳转至登录界面
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }else{
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
