<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>订单详情</title>
	<%@include file="/pages/common/head.jsp"%>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
</style>
</head>
<body>
	<div id="header">
			<img class="logo_img" alt="" src="static/img/pic.jpg" >
		<c:if test="${sessionScope.user.level=='0'}">
			<span class="wel_word">我的订单</span>
		</c:if>
		<c:if test="${sessionScope.user.level=='1'}">
			<span class="wel_word">订单详情</span>
		</c:if>
		<%@include file="/pages/common/login_success.jsp"%>
	</div>
	<div id="main">
		<table>
			<tr>
				<td>书名</td>
				<td>数量</td>
				<td>单价</td>
				<td>总价</td>
			</tr>
			<c:forEach items="${requestScope.orderItem}" var="Item">
			<tr>
				<td>${Item.name}</td>
				<td>${Item.count}</td>
				<td>${Item.price}</td>
				<td>${Item.total_price}</td>
			</tr>
			</c:forEach>
		</table>
	</div>
	<span class="cart_span" style="margin-left: 1200px" >
		<c:if test="${sessionScope.user.level=='0'}">
			<a href="orderServlet?action=showMyOrder&userId=${sessionScope.user.id}">返回&nbsp;&nbsp;</a>
		</c:if>
		<c:if test="${sessionScope.user.level=='1'}">
			<a href="orderServlet?action=showAllOrder">返回&nbsp;&nbsp;</a>
		</c:if>
		<c:choose>
			<c:when test="${requestScope.status==0}">
<%--				当订单未发货时,只有管理员才能发货--%>
				<c:if test="${sessionScope.user.level=='1'}">
					<a href="orderServlet?action=sendOrder&orderId=${requestScope.orderId}">发货</a>
				</c:if>
			</c:when>
			<c:when test="${requestScope.status==1}">
<%--				当订单发货后,用户可以签收,管理员显示已发货--%>
				<c:if test="${sessionScope.user.level=='0'}">
					<a href="orderServlet?action=signForOrder&orderId=${requestScope.orderId}" class="signIn" >签收</a>
				</c:if>
				<c:if test="${sessionScope.user.level=='1'}">
					<span >&nbsp;已发货</span>
				</c:if>
			</c:when>
			<c:when test="${requestScope.status==2}">
<%--				当订单签收后,用户和管理员都显示已签收--%>
				<span >&nbsp;已签收</span>
			</c:when>
		</c:choose>
	</span>
	<%@include file="/pages/common/footer.jsp"%>
</body>
</html>