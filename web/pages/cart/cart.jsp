<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
<%@include file="/pages/common/head.jsp"%>
	<script type="text/javascript">
		$(function () {
			$(".delete").click(function () {
				return confirm("确定要从你的购物车中删除《"+$(this).parent().parent().find("td:first").text()+"》吗？");
			})
			$(".deleteAll").click(function () {
				return confirm("真的要清空购物车吗?")
			})
			//修改数量
			$(".count").change(function () {
				var id=  $(this).attr("bookId");
				if (confirm("确定修改《"+$(this).parent().parent().find("td:first").text()+"》的数量为"+this.value+"吗？")){
					location.href="http://localhost:8081/Bookstore/cartServlet?action=updateCount&id="+id+"&count="+this.value;
				}else{
					this.value=this.defaultValue;
				}

			})
		})
	</script>
</head>
<body>
	<div id="header">
			<img class="logo_img" alt="" src="static/img/pic.jpg" >
			<span class="wel_word">购物车</span>
		<%@include file="/pages/common/login_success.jsp"%>
	</div>
	<div id="main">
		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>
			  <c:if test="${ empty sessionScope.cart.cartItem}">
				<tr>
					<td colspan="5"> <a href="index.jsp">亲,你购物车还是空的呢,先去浏览商品吧!</a></td>
				</tr>
			  </c:if>
            <c:forEach items="${sessionScope.cart.cartItem}" var="cartItem">
			   <tr>
				<td>${cartItem.value.name}</td>
				<td><input type="text"  class="count" bookId="${cartItem.value.id}" value="${cartItem.value.count}"  style="width: 30px "/> </td>
				<td>${cartItem.value.price}</td>
				<td>${cartItem.value.totalPrice}</td>
				<td><a class="delete" href="cartServlet?action=deleteItem&id=${cartItem.value.id}">删除</a></td>
			   </tr>
			</c:forEach>
		  </table>
	</div>
	<c:if test="${ not empty sessionScope.cart.cartItem}">
	<div class="cart_info" style="margin-left: 750px ">
		<span class="cart_span">购物车中共有<span class="b_count">${ sessionScope.cart.totalCount}</span>件商品</span>
		<span class="cart_span">总金额<span class="b_price">${ sessionScope.cart.totalPrice}</span>元</span>
		<span class="cart_span"><a class="deleteAll" href="cartServlet?action=clear">清空购物车 </a>&nbsp;|</span>
		<span class="cart_span"><a href="orderServlet?action=createOrder&userId=${sessionScope.user.id}">去结账</a></span>
	</div>
	</c:if>
<%@include file="/pages/common/footer.jsp"%>
</body>
</html>