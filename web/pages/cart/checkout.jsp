<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>结算页面</title>
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
			<span class="wel_word">结算</span>
		<%@include file="/pages/common/login_success.jsp"%>
	</div>
	
	<div id="main">
		<c:if test="${empty sessionScope.orderId}">
			<h1>你的订单由于网络原因,未结算成功!,请稍后再试!<a href="pages/cart/cart.jsp">返回购物车</a></h1>
		</c:if>
		<c:if test="${not empty sessionScope.orderId}">
		<h1>你的订单已结算，订单号为${sessionScope.orderId}</h1>
		</c:if>
	</div>

	<%@include file="/pages/common/footer.jsp"%>
</body>
</html>