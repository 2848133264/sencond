<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>病历删除</title>
<style type="text/css">

	td{
	width: 100px;
	text-align: center;
	}
	h3{
	  	font-family: 楷体;
	  	font-size: 25px;
	}
</style>
</head>
<body>
	<!-- 当我们访问这个页面的时候，就应获取到所有的病历单，并且添加出删除按钮 
		 删除成功后接着回到这个此页面，可以同时访问这个删除的 servlet，实现数据的更新 
	-->
	<br><br>
	<form action="" method="post">
		<!-- 显示多少天记录是个问题： -->
		<!-- 显示：id号，姓名，年龄，是否已婚，电话，地址  ，诊断结果-->
		<table border="1" align="center">
			<caption><h3>病&nbsp;人&nbsp;基&nbsp;本&nbsp;信&nbsp;息&nbsp;表</h3></caption>
			<tr style="background-color:red; color: white; width: 40px;">
				<!-- 表的行信息 -->
				<td ">病历号</td><td>姓名</td><td>年龄</td><td>婚否</td><td>电话</td><td>地址 </td><td>病因</td><td>诊断结果</td><td>操作</td>
			</tr>
			<!-- 输出结果 ,一个请求的的东西  <a href="/mavenweb/search_id.do?id=${person.getId() }">   -->
			<c:forEach items="${personlist }" var="person">
				<tr>				
					<td>
						 <c:out value="${person.getId() }"></c:out>
					</td>
					<td>
					     <c:out value="${person.getName() }"></c:out>
					</td>
					<td>
						 <c:out value="${person.getAge() }"></c:out>
					</td>
					<td>
					     <c:out value="${person.getIsMarry() }"></c:out>
					</td>
					<td>
						 <c:out value="${person.getPhone() }"></c:out>
					</td>
					<td>
					     <c:out value="${person.getAddress() }"></c:out>
					</td>
					<td>
						 <c:out value="${person.getXianzhuang() }"></c:out>
					</td>
					<td>
					     <c:out value="${person.getResult() }"></c:out>
					</td>
					<td><a href="/mavenweb/delete.do?id=${person.getId() }">删除</a>
				</tr>
			</c:forEach>
		</table>
		<!--  -->
	</form>
		<button  style="width: 56px;height: 35px;margin-top: -109px;margin-left: 29px;" onclick="back1()">返回</button>
		
<script type="text/javascript">
	function back1() {
		window.history.back();
	}
</script>
</body>
</html>