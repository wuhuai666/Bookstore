<%--
  Created by IntelliJ IDEA.
  User: 吴淮
  Date: 2021/7/16
  Time: 8:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>添加图书</title>
    <%@include file="/pages/common/head.jsp"%>
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }

        h1 a {
            color:red;
        }

        input {
            text-align: center;
        }
    </style>
</head>
<body>
<div id="header">
    <img class="logo_img" alt="" src="static/img/pic.jpg" >
    <span class="wel_word">添加图书</span>
    <%@include file="/pages/common/func.jsp"%>
</div>

<div id="main">
    <form action="manager/bookServlet" method="post">
        <table>
            <tr>
                <td>名称</td>
                <td>价格</td>
                <td>作者</td>
                <td>销量</td>
                <td>库存</td>
                <td colspan="2">操作</td>
            </tr>
            <tr>
                <input type="hidden" name="PageNo" value="${param.PageNo}"/>
                <td><input name="name" type="text" /></td>
                <td><input name="price" type="text" /></td>
                <td><input name="author" type="text" /></td>
                <td><input name="sales" type="text" /></td>
                <td><input name="stock" type="text" /></td>
                <input  type="hidden" name="action" value="addBook"/>
                <td><input type="submit" value="添加"/></td>
            </tr>
        </table>
    </form>


</div>

<%@include file="/pages/common/footer.jsp"%>
</body>
</html>