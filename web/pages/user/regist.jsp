<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员注册页面</title>
	<%@include file="/pages/common/head.jsp"%>
<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}
</style>
	<script type="text/javascript" src="static/script/jQuery.js"></script>
	<script type="text/javascript">
		$(function () {
			$("#username").blur(function () {
				$.getJSON("http://localhost:8081/Bookstore/userservlet","action=ajaxExistUserName&username="+this.value,function (data) {
					if (data.existUsername){
						$("span.errorMsg").text("用户名已经存在");
					}else{
						$("span.errorMsg").text("");
					}
				});
			});
			//1.用户名由5-12位的数字，字母，下划线组成
			//获取提交表单的监听
			$("#sub_btn").click(function () {
				//获得用户名
                var name = $("#username").val();
                var patt=/^\w{5,12}$/;
                if (!patt.test(name)){
                	$("span.errorMsg").text("用户名输入不合法");
					return false
				}
				//2.用户密码由5-12位的数字，字母，下划线组成
					//获得用户密码
					var password = $("#password").val();
                //正则表达式
					var patt1=/^\w{5,12}$/;
					if (!patt1.test(password)){
						$("span.errorMsg").text("用户密码输入不合法");
						return false
					}
				var password1 = $("#repwd").val();
					if (password!=password1){
						$("span.errorMsg").text("用户密码输入不一致");
						return false
					}
				var email = $("#email").val();
				var patt2=/^[a-zA-Z0-9]+([-_.][a-zA-Z0-9]+)*@[a-zA-Z0-9]+([-_.][a-zA-Z0-9]+)*\.[a-z]{2,}$/;
				if (!patt2.test(email)){
					$("span.errorMsg").text("用户邮箱输入不合法");
					return false
				}
				var code=$("#code").val();
				//去掉空格
				 var c=$.trim(code)
	            if (c==null || c==""){
					$("span.errorMsg").text("请输入验证码");
					return false
				}
				$("span.errorMsg").text(" ");
			})
			//点击切换验证码
			$("#imgCode").click(function () {
				$("#imgCode").attr("src", "Kaptcha.jpg")
			})

		})
	</script>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/pic.jpg" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册尚硅谷会员</h1>
								<span class="errorMsg">
									<%=request.getAttribute("msg1")==null?"":request.getAttribute("msg1")%>
								</span>
							</div>
							<div class="form">
								<form action="userservlet" method="post">
									<input name="action" type="hidden" value="regist">
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" id="username"
									value="${requestScope.username}"/>
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" id="password"
										   value="${requestScope.password}"/>
									<input type="hidden" name="level" value="0">
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1" name="repwd" id="repwd"
										   value="${requestScope.password}"/>
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1" name="email" id="email"
										   value="${requestScope.email}"/>
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" style="width: 150px;" name="code" id="code"/>
									<img alt="" src="Kaptcha.jpg" style="float: right; margin-right: 10px;width: 111px;height: 40px" id="imgCode">
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
									
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		<%@include file="/pages/common/footer.jsp"%>
</body>
</html>