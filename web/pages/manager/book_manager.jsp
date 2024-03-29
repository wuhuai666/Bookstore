<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书管理</title>
	<%@include file="/pages/common/head.jsp"%>

	<script type="text/javascript">
<%--		在页面加载完之后--%>
		$(function () {
			//为删除按钮添加点击事件
           $("a.delete").click(function () {
            //返回值为false,则阻止表单提交
           	return confirm("确认删除《"+$(this).parent().parent().find("td:first").text()+"》吗?");
		   });
		});
	</script>
</head>
<body>
	<div id="header">
			<img class="logo_img" alt="" src="static/img/pic.jpg" >
			<span class="wel_word">图书管理系统</span>
		<%@include file="/pages/common/func.jsp"%>
	</div>
	<div id="main">>
		<table>
			<tr>
				<td>名称</td>
				<td>价格</td>
				<td>作者</td>
				<td>销量</td>
				<td>库存</td>
				<td colspan="2">操作</td>
			</tr>
			<c:forEach items="${requestScope.Page.pageItems}" var="book">
				<tr>
					<td>${book.name}</td>
					<td>${book.price}</td>
					<td>${book.author}</td>
					<td>${book.sales}</td>
					<td>${book.stock}</td>
					<td><a  href="manager/bookServlet?action=queryOneBook&id=${book.id}&PageNo=${requestScope.Page.pageNo}">修改</a></td>
					<td><a class="delete" href="manager/bookServlet?action=deleteBookById&id=${book.id}&PageNo=${requestScope.Page.pageNo}">删除</a></td>
				</tr>
			</c:forEach>>
		</table>
	</div>
<%@include file="/pages/common/page_nav.jsp"%>
	<table>
	<tr>
		<td><a href="pages/manager/Book_add.jsp?PageNo=${requestScope.Page.pageTotal}" style="margin-left: 1400px">添加图书</a></td>
	</tr>
	</table>
	<%@include file="/pages/common/footer.jsp"%>
</body>
</html>