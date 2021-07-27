package com.atwuhuai.web;
import com.atwuhuai.pojo.User;
import com.atwuhuai.service.UserService;
import com.atwuhuai.service.impl.UserServiceimpl;
import com.atwuhuai.utils.web;
import com.google.gson.Gson;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

//主要写业务逻辑代码,dopost函数在Baseservlet中调用此类里面的业务
public class UserServlet extends BaseServlet {
    private UserService userService=new UserServiceimpl();
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //执行登录业务
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userService.login(new User(null, username, password, null,null));
        //为null，则表示无该用户,跳转回登录界面
            if (userService.login(user) == null) {
                request.setAttribute("msg", "用户不存在或密码错误");
                request.setAttribute("username", username);
                request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
            } else {
                //保存到session域中,用于显示用户的信息
                request.getSession().setAttribute("user",user);
                request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request, response);
            }
    }
    protected void regist(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
//执行注册业务
        //得到session域中的验证码
        String sCode = (String) request.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        //马上删除session的验证码,防止用户再次提交
        request.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        //得到表单提交的参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String  email = request.getParameter("email");
        //用户提交的验证码
        String code=request.getParameter("code");
        User user = web.paramToBean(request.getParameterMap(), new User());

        //得到注册信息保存至session域中
        request.getSession().setAttribute("user",user);
        if (sCode!=null&&sCode.equalsIgnoreCase(code)) {
            if (userService.existsUsername(username)) {
                //若用户名存在,则返回注册界面
                request.setAttribute("msg1","用户名已经存在!");
                request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
            } else {
                //如果用户名不存在,则可以注册用户
                userService.registUser(user);
//              resp.sendRedirect();
                request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request, response);
            }
        }else {
            //验证码不正确，返回注册界面
            request.setAttribute("msg1","验证码不正确");
            request.setAttribute("username",username);
            request.setAttribute("password",password);
            request.setAttribute("repassword",password);
            request.setAttribute("email",email);
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
        }
    }
    protected void logOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //用户注销登录,删除session,用来删除用户的登录信息.
        request.getSession().invalidate();
        //请求重定向至登录界面
        response.sendRedirect(request.getContextPath());
//        request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
    }
    protected void ajaxExistUserName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //获取请求的参数
        String username = request.getParameter("username");
        //调用service层的方法
        boolean existUsername = userService.existsUsername(username);
        //保存到Map中并转换为json对象
        Map<String,Object> map=new HashMap<String, Object>();
         map.put("existUsername",existUsername);
        Gson gson=new Gson();
        String s = gson.toJson(map);
        //返回给客户端
        response.getWriter().write(s);
    }
    }

