
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登入界面</title>
<style type="text/css">
*{
	padding: 0px;
	
}
	button{
		width: 60px;
		height: 33px;
		border-radius:2px;
		background-color: white;
	}
	tr{
		width: 20px;
		height: 49px;
	}
	.text1{
		width: 129px;
		height: 23px;
	}
	.text2{
		font-family:"SimSun"; 
		font-size: 20px;
	}
	#kk{
		width:100%;
		height: 600px;
	}
	#main{
		margin-left: 30%;
		margin-top:34%;
		width: 422px;
		height: 170px;
	    background-color: ;
	}
	body{
	 	width:100%;
	 	height:100%;
		background-image: url("../img/login3.jpg");
		background-repeat: no-repeat;
		background-size: 100% 100%;
	}
	
</style>
</head>
<body>
<div id="kk">
	<div id="main"  align="center">
		<form action="${pageContext.servletContext.contextPath }/login.do" method="post">
			<table>
				<tr>
					<td class="text2">用户名：</td><td><input type="text" name="username" placeholder="请输入用户名" class="text1"></td>
				</tr>
				
				<tr>
					<td class="text2">密&nbsp;码：</td><td><input type="password" name="password" placeholder="请输入密码" class="text1"></td>
				</tr>
				<tr>
					<td>
					<button>登入</button>
					<!-- <input type="submit" name="submit" value="登入" style="margin-top: 20px;"></td> -->
				</tr>	
			</table>			
	 	</form>
			<button  style="margin-top: -44px;margin-left: 153px;" onclick="regester()">注册</button>
	</div>
</div>	
<script type="text/javascript">
	function regester() {
		window.location.href="regester.jsp";
	}
</script>
</body>
</html>