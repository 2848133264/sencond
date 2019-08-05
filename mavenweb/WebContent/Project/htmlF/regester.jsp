<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册界面</title>
</head>
<body>
<br>
<br>
	<form action="${pageContext.servletContext.contextPath }/regester.do" method="post" >
	 	<table align="center">
	 	<caption>用户注册</caption>
	 		<tr>
	 			<th>用户名：</th><td><input type="text" name="username" placeholder="请输入用户名"/></td>
	 		</tr>
	 		<tr>
	 			<th>密 &nbsp;&nbsp;码：</th><td><input type="password" name="password" placeholder="请输入密码"/></td>
	 		</tr> 
	 		<tr><th><input type="submit" name="submit" value="注册"></th>
	 			<td><input type="reset" name="reset" value="重置"></td>
	 		</tr>
	 	</table>
	 </form>
</body>
</html>