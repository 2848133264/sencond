<%@page import="EntityP.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户基本信息</title>

<style type="text/css">
	a{
		text-decoration: none;
	}
	#back{	
		width: 100px;
		height: 20px;
	}

	table {
		width: 600px;	
		text-align: center;
	}
	.tr1{
		background-color: grey;
		color: white;
	}
	

</style>
</head>
<body>
	<!-- 主要是显示用户的基本信息 -->
	<%
		//我们采用的是后台返回的一个user 类型的list集合
		//发送请求的时候就跳转到这个显示界面中展示
		List<User> list =  (List<User>)request.getAttribute("userList");
		
	%>
	
	<br><br>
	<form action="">

	<table border="1" align="center">
		<caption style="font-size: 35px;font-style:oblique;color: red;">用户信息</caption>
		<tr>
			<td class="tr1">用户id</td>
			<td class="tr1">用户名</td>
			<td class="tr1">密&nbsp;&nbsp;码</td>
			<td class="tr1">操作</td>
		</tr>
			
			<% if(list!=null && list.size() >0){
				for(User user1:list){
					request.setAttribute("user1", user1);	
			%>
		<tr>
			<td><%=user1.getId() %></td>
			<td><%=user1.getUsername() %></td>
			<td><%=user1.getPassword() %></td>
		    
			<td><a href="/mavenweb/delectUser.do?id=${user1}" >删除</a>
			<!-- 不能把自己删除，或者说删除了自己的时候，就直接退出系统 -->
			</td>
		</tr>	
				<%
			
				}%> 
				<tr><td>共计人数：</td><td colspan="3"><%=list.size() %>人</td></tr>	
		  	<%}%>
		
		</table>
	</form>
	<br>
	<div id="back" align="center" style="margin-left: 300px;">  <a href="/mavenweb/Project/home.jsp">返回上一层</a></div>

</body>
</html>