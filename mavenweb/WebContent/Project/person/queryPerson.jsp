<%@page import="EntityP.person.person"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>病历查询</title>
<style type="text/css">

*{
	margin: 0px;
	padding: 0px;

}
	#outid{  
	   height: 800px;
	   width: 1140px;
	  /*  background-color: red; */
	   margin-left: 130px;
	 
	}
	
	#id1{
		width:100%;
		height: 100px;
		background-color: yellow;
		background-repeat:no-repeat;
		background-size: 100%;
		background-image: url("../img/03.png");
		
	}
	.usernameShow{
		position: relative;
	 	margin-right: 20px;
	 	margin-top: 0px;
	 	font-style: italic;
	}
	h2{
		font-size: 26px;
		font-style: italic;
		
	}
	#id1>h3{
		font-size: 14px;
		text-align: right;
		margin-right: 20px;
		font-style: italic;
		color: green;
	}
	#down{
	   height:600px;
	   width: 1140px;
	}
	#down div{
		float: left;
	}
	#showname_id{
		
		width: 251px;
		height: 500px;
		/* background-color: yellow;  */
		/* background-image:url("../img/05.png"); */
		position: relative;
		
	}
	#showname_id_table{
		width: 193px;
		height: 400px;
		margin-left: 60px;
	}
	#table1{
		margin-top:8px;	
		text-align: center;
		width: 185px;
		/* //background-color:green; */	
	}
	#searchPerson{
		width: 850px;
		height: 128px;
		/* background-color: red; */
	}
	#searchPersonform{
		text-align: center;
		margin-top: 50px;
	}
	#showsearch_msg{
		width: 400px;
		height: 362px;
		background-color: ;
		margin-left: 220px;
		
	}
	a{
		text-decoration: none;
	}
</style>
</head>
<body>
<%
		//格式化时间的
	
		Date weekDate =new Date();

		int num = weekDate.getDay();//星期天返回的时间为 0，
		System.out.print(num);
		SimpleDateFormat slFormat =new SimpleDateFormat("YYYY/MM/dd hh:mm:ss");	
		
		//将这个num转成相应的中文形式
		String [] weekStrings={"星期一","星期二","星期三","星期四","星期五","星期六","星期日"};
		//时间的判断有问，
		String weektime=null;
		if(num ==0){
			//直接让他是星期日，
			weektime =weekStrings[weekStrings.length-1];
		}else{
			weektime=weekStrings[num-1];
		}
		
		String timeReal =slFormat.format(weekDate)+" "+weektime; //时间跟星期是一起的
		
	%>
	<div id="id1">
			<!-- 这个div 是实现这个标题的 -->
	
			<p class="usernameShow" align="right">当前用户：<%=request.getSession().getAttribute("username") %></p>
			<h2 align="center" style="font-family: 楷体;margin-top: 10px;" >电&nbsp;子&nbsp;病&nbsp;历&nbsp;系&nbsp;统</h2>
			<h3><%=timeReal %></h3>
	</div>
	<div id="down">
	<div id="showname_id">
		<!-- 以超链接的方式 -->
		<div id="showname_id_table">
		<br>
		<span style="color:blue;">快速查询</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style="color:blue;"><a href="/mavenweb/Project/home.jsp" style="color:blue;">返回上一层</a></span>
			<table border="1" id="table1">
				<tr style="background-color: gray; color: white;">
					<td>病历号</td>
					<td>姓名</td>
				</tr>
				<c:forEach items="${personlist }" var="person">
				<tr>				
					<td>
						<a href="/mavenweb/search_id.do?id=${person.getId() }"> <c:out value="${person.getId() }"></c:out></a>
					</td>
					<td><c:out value="${person.getName() }"></c:out></td>
				</tr>
					</c:forEach>
			</table>
		</div>
		
	</div>	
		<!-- 查询具体的人 -->
	<div id="searchPerson">	  
		<form action="${pageContext.servletContext.contextPath }/searchR.do" method="post" id="searchPersonform">
		<span style="margin-left:-79px;">${errorMsg}</span><br>  
			<input style="width: 420px;height: 36px;" type="text" name="searchid_card" placeholder="请输入您要查询病人的病历号 or身份证号" id="sid">
			<input style="width: 69px;height: 39px;font: 60px;" type="submit" value="确定">
		</form>	
		       
	</div>
	<div id="showsearch_msg">
		<c:forEach items="${searchResult }" var="person">
		
		  病&nbsp;&nbsp;历&nbsp;&nbsp;号：<c:out value="${person.getId() }"></c:out><br>
		  姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：<c:out value="${person.getName() }"></c:out><br>
		  年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄：<c:out value="${person.getAge() }"></c:out><br>
		  身份证号：<c:out value="${person.getIdCard() }"></c:out><br>
		  家庭住址：<c:out value="${person.getAddress() }"></c:out> <br>	
		  电话号码：<c:out value="${person.getPhone() }"></c:out><br>
		  就诊时间：<c:out value="${person.getInDate() }"></c:out> <br>
		  病&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;史：<c:out value="${person.getBingshi() }"></c:out><br>
		  病&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;状：<c:out value="${person.getXianzhuang() }"></c:out><br>
		  就诊结果：<c:out value="${person.getResult() }"></c:out><br>
		
		<br>
		<br>
		<button id ="result2" onclick="printrecord()" value="${person }" >打印病历</button>
		</c:forEach>
	</div>
</div>

<script type="text/javascript">
	function printrecord() {
		var person =document.getElementById("result2").value;
		var t =confirm("确定打印病历单吗?");
		if(t ==true){
			//如果是这个确定，则进行IO流的操作
			window.location.href="/mavenweb/printrecord.do?id="+person;
		}
	}
</script>








</body>
</html>