<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="all.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<style type="text/css">

</style>
</head>
<frameset rows="15%,*,8%" frameborder="no" border="0" framespacing="0" >
	<frame src="${pageContext.servletContext.contextPath }/Project/head.jsp" name="top1" scrolling="No" noresize="noresize">
	<frameset cols="16%,*" frameborder="no" border="0" framespacing="0">
		<frame src="${pageContext.servletContext.contextPath }/Project/left.jsp" name="left1" scrolling="No" noresize="noresize">
		<frame src="${pageContext.servletContext.contextPath }/Project/right.jsp" name="mainFrame" id="mainFrame" title="mainFrame" scrolling="yes" noresize="noresize">
	</frameset> 
	<frame src="${pageContext.servletContext.contextPath }/Project/foot.jsp" name="foot" scrolling="no" noresize="noresize">
</frameset>




<body>
</body>
</html>