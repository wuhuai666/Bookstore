<%--
  Created by IntelliJ IDEA.
  User: 吴淮
  Date: 2021/7/14
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临指南书城</span>
    <a href="userservlet?action=logOut">注销</a>&nbsp;&nbsp;
    <a href="index.jsp">返回</a>
</div>

