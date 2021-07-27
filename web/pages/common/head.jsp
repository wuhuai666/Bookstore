<%--
  Created by IntelliJ IDEA.
  User: 吴淮
  Date: 2021/7/14
  Time: 13:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String name=request.getScheme()   //协议
            +"://"
            +request.getServerName()        //ip地址
            +":"
            +request.getServerPort()       //端口号
            +request.getContextPath()     //工程路径
            +"/";
    pageContext.setAttribute("basePath",name);
%>
<base href="<%=name%>">
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<script type="text/javascript " src="static/script/jQuery.js"></script>
