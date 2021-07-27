<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>书城首页</title>
	<%@include file="/pages/common/head.jsp"%>
	<script type="text/javascript">
		$(function () {
			 $("button.addToCart").click(function (){
				 <c:if test="${ not empty sessionScope.user.username}">
				 var bookId=$(this).attr("bookId");
				 // location.href="http://localhost:8081/Bookstore/cartServlet?action=addItem&id="+bookId;
				 $.getJSON("http://localhost:8081/Bookstore/cartServlet","action=ajaxAddItem&id="+bookId,function (data) {
				 	        $("#totalCount").text("您的购物车中有"+data.totalCount+"件商品")
                             $("#lastName").text("您刚刚将《"+data.lastName+"》加入到了购物车中")
				 })
				 </c:if>
				 <c:if test="${ empty sessionScope.user.username}">
				   if (confirm("检测您还未登录,是否立即登录?")) {
					   location.href="http://localhost:8081/Bookstore/pages/user/login.jsp"
				   }
				 </c:if>
			})
		})

	</script>
</head>
<body>
	<div id="header">
		<img class="logo_img" alt="" src="static/img/pic.jpg" >
		<div>
			<c:if test="${empty sessionScope.user.username}">
				<a href="pages/user/login.jsp">登录</a> |
				<a href="pages/user/regist.jsp">注册</a> &nbsp;&nbsp;


			</c:if>
			<c:if test="${not empty sessionScope.user.username}">
			<a href="userservlet?action=logOut">注销</a>&nbsp;&nbsp;
						</c:if>
<%--				<span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临指南书城</span>--%>
			<c:if test="${sessionScope.user.level=='0'}">
			<a href="orderServlet?action=showMyOrder&userId=${sessionScope.user.id}">我的订单</a>
			<a href="pages/cart/cart.jsp">购物车</a>
			</c:if>
			<c:if test="${sessionScope.user.level=='1'}">
				<a href="pages/manager/manager.jsp">后台管理</a>
			</c:if>
	     </div>
	</div>
	<div id="main">
		<div id="book">
			<div class="book_cond">
				<form action="client/bookServlet" method="get">
					    <input  type="hidden" name="action" value="PageByPrice"/>
					价格：<input id="min" type="text" name="min" value="${param.min}"/> 元 -
						<input id="max" type="text" name="max" value="${param.max}"/> 元
						<input type="submit" value="查询" />
				</form>
			</div>
			<div style="text-align: center" class="display">
				      <span id="totalCount" ></span>
				      <div id="lastName"></div>
			</div>
			<c:forEach items="${requestScope.Page.pageItems}" var="book">
			 <div class="b_list">
				<div class="img_div">
					<img class="book_img" alt="" src="${book.img_path}" />
				</div>
				<div class="book_info">
					<div class="book_name">
						<span class="sp1">书名:</span>
						<span class="sp2">${book.name}</span>
					</div>
					<div class="book_author">
						<span class="sp1">作者:</span>
						<span class="sp2">${book.author}</span>
					</div>
					<div class="book_price">
						<span class="sp1">价格:</span>
						<span class="sp2">￥${book.price}</span>
					</div>
					<div class="book_sales">
						<span class="sp1">销量:</span>
						<span class="sp2">${book.sales}</span>
					</div>
					<div class="book_amount">
						<span class="sp1">库存:</span>
						<span class="sp2">${book.stock}</span>
					</div>
					<div class="book_add">
						<c:if test="${sessionScope.user.level=='0'}">
						<button bookId="${book.id}" class="addToCart">加入购物车</button>
						</c:if>
					</div>
				</div>
			</div>
			</c:forEach>
		</div>
		<%@include file="/pages/common/page_nav.jsp"%>
	</div>
		<%@include file="/pages/common/footer.jsp"%>
</body>
</html>