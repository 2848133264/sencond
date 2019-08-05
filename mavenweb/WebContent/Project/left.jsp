<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="all.css" type="text/css">
</head>
<body>
		<div id="id2">
			<!-- 用作封装功能目录的 -->
			<div id="id2_1">
			<p>业务办理:</p>
			<hr>
				<ul>
					<li>查看XXX信息</li>
					<li>选择模块</li>
					<li>选择模块</li>
					<li>选择模块</li>
					<li>选择模块</li>
					<li>选择模块</li>
				</ul>
				<!-- 用户的基本操作功能(1.查看自己的基本信息，2.修改密码   3.登出功能） -->
				<br>
				<p id="userOperaction">用户管理:</p>
				<hr>
			
					<ul>
					<!-- <li><a onclick="a()" id="aid" value="aidvalue">基本信息</a></li> -->
					<li><a href="/mavenweb/showUser.do">基本信息</a></li>
					<li><a href="${pageContext.servletContext.contextPath }/Project/htmlF/updateuser.jsp">修改密码</a></li>
					<li><a href="/mavenweb/loginout.do">登出功能</a></li>
				    </ul>			
			</div>
				
		</div>
</body>
</html>