package com.atwuhuai.web;

import com.atwuhuai.pojo.Page;
import com.atwuhuai.service.BookServce;
import com.atwuhuai.service.impl.BookServiceImpl;
import com.atwuhuai.utils.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientServlet extends BaseServlet {
    private BookServce bookServce=new BookServiceImpl();
    protected void Page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取PageNo(当前页码)和PageSize(当前页数据)
        int pageNo = web.strToInt(request.getParameter("PageNo"), 1);
        int pageSize = web.strToInt(request.getParameter("PageSize"), Page.PAGE_SIZI);
        //调用BookService.Page(PageNo,PageSize);方法
        Page page = bookServce.Page(pageNo, pageSize);
        page.setUrl("client/bookServlet?action=Page");
        //将Page对象放入Request域中
        request.setAttribute("Page",page);
        //请求转发至/pages/manager/index.jsp界面
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request,response);
    }
    //价格区间查询
    protected void PageByPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取PageNo(当前页码)和PageSize(当前页数据)
        int pageNo = web.strToInt(request.getParameter("PageNo"), 1);
        int pageSize = web.strToInt(request.getParameter("PageSize"), Page.PAGE_SIZI);
        //获取最小价格和最大价格区间
        int min = web.strToInt(request.getParameter("min"), 0);
        int max = web.strToInt(request.getParameter("max"), Integer.MAX_VALUE);//默认最大值
//调用BookService.Page(PageNo,PageSize);方法
        Page page = bookServce.PageByPrice(pageNo, pageSize,min,max);
        //Builder为线程不安全的,在PageByPrice这种单线程的方法中使用效率更高
        StringBuilder sb=new StringBuilder("client/bookServlet?action=PageByPrice");
        //若最小值不为空,则追加至请求地址的后面
        if (request.getParameter("min")!=null){
            sb.append("&min=").append(request.getParameter("min"));
        }
        //若最大值不为空,则追加至请求地址的后面
        if (request.getParameter("max")!=null){
            sb.append("&max=").append(request.getParameter("max"));
        }
        page.setUrl(sb.toString());
        //将Page对象放入Request域中
        request.setAttribute("Page",page);
        //请求转发至/pages/manager/index.jsp界面
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request,response);
    }
}
