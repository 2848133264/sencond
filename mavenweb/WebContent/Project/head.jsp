<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
		/* request.setAttribute("time", timeReal); */
		/* System.out.print(timeReal);*/
		
	%>
	<div id="id1">
			<!-- 这个div 是实现这个标题的 -->
			<span class="userM"><a href="/mavenweb/deleteself.do">注销用户</a></span> <span class="userMa">|</span><span class="userM"><a href="/mavenweb/loginout.do">退出系统</a></span>
			<p class="usernameShow" align="right">当前用户：<%=request.getSession().getAttribute("username") %></p>
			<h2 align="center" >电子病历系统</h2>
			<h3><%=timeReal %></h3>
		</div>
</body>
</html>