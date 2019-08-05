<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎使用电子病历管理系统</title>
<style type="text/css">
*{
	margin: 0px;
	padding: 0px;
	font-family: 楷体;


}
	#outid{  
	   height: 800px;
	   width: 1140px;
	   margin-left: 130px;
	 
	}
	#id1{
		width:100%;
		height: 100px;
		background-color: yellow;
		background-repeat:no-repeat;
		background-size: 100%;
		background-image: url("img/03.png");
		
	}
	.usernameShow{
		position: relative;
	 	margin-right: 20px;
	 	margin-top: 5px;
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
		color: #4064ce;
	}
	
	#id2{
		/* 设置它的大小*/
		width: 186px;
		height: 730px;
		background-color: white;
	   	background-image: url("img/04.png")
	}
	#id3{
	    padding:0px;
	    margin:0px;
		width: 954px;
		height: 730px;
		background-image: url("img/center.jpg");
		background-size: 101% 101%;
	}
	#id4{
	
		width: 100%;
		height: 100px;
		background-color: #22132D;
		font-size: 13px;
		color:white;
	}
	#outid div{
		float: left;
	}
	#id2_1{
		width:149px;
		height: 389px;
		margin-left: 2px;
		margin-top: 0px;
	
	}
	/*  列表信息  */
	#id2_1 ul li{
		width: 101px;
		height: 22px;
		margin-top:10px;
		margin-left:40px;
		text-align: center;
		color: white;
		border: 1px;
		border-style: solid;
		border-radius:10px;
		background-color: gray;
	}
	#id2_1 ul{
		list-style: none;	
	}
	#id2_1>p{
		color: blue;
		border: 1px;
		
	}
.copyrights {
    color: #a5a2a7;
    padding: 20px 0;
    line-height: 22px;
}
.mainWrap {
    width: 1000px;
    margin: auto;
    min-width: 320px;
    
}
.copyrights .info {
    float: left;
    margin-left: 80px;
}
.copyrights .icp {
    float: right;
    
}
a{
	list-style: none;
	text-decoration: none;
	color: white;
}
a:HOVER {
	color:blue;
	
}
#id1 span{
	float: left;
	margin-top: 72px;
	margin-left: 10px;
}


</style>
<script type="text/javascript" src="jquery/jquery-3.3.1.js"></script>
</head>
<body>
	<!-- 这个首页是为了对登入界面的用户进行管理的 -->
	<!-- 	<a href="${pageContext.servletContext.contextPath }/Project/htmlF/updateuser.jsp">修改密码</a>   -->
	
	<%
		//格式化时间的
	
		Date weekDate =new Date();
		int num = weekDate.getDay();//星期天返回的时间为 0，
		/* System.out.print(num); */
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
	<div id="outid">
		<div id="id1">
			<!-- 这个div 是实现这个标题的 -->
			<span class="userM"><a href="/mavenweb/deleteself.do">注销用户</a></span> <span class="userMa">|</span><span class="userM"><a href="/mavenweb/loginout.do">退出系统</a></span>
			<p class="usernameShow" align="right">当前用户：<%=request.getSession().getAttribute("username") %></p>
			<h2 align="center" >电&nbsp;子&nbsp;病&nbsp;历&nbsp;管&nbsp;理&nbsp;系&nbsp;统</h2>
			<h3><%=timeReal %></h3>
		</div>
		
		<div id="id2">
			<!-- 用作封装功能目录的 -->
			<div id="id2_1">
			<p>业务办理:</p>
			<hr>
				<ul>
					<li><a href="${pageContext.servletContext.contextPath }/Project/person/personInsert.jsp">病人登记</a></li>
					<li><a href="${pageContext.servletContext.contextPath }/Project/person/personcure.jsp">病人就诊</a></li>
					<li><a href="/mavenweb/queryAllP.do">查询病历</a></li>
					<li><a href="${pageContext.servletContext.contextPath }/Project/person/personupdateMsg.jsp">修改病历</a></li>
					<li><a href="/mavenweb/persondelete.do">删除病历</a></li>

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
<script type="text/javascript">
	function a() {
		
		var temp = document.getElementById("aid").value;
		alert(temp);
		window.location.href ="${pageContext.servletContext.contextPath }/showUserMasg.do?id="+temp;
		
	}
	
</script>	

		<div id="id3"  >
			<!-- <input name="butt" value="统计" type="button" id="change" οnclick="change()" /> -->
			<!-- 测试功能为局部显示 ,js 和jframe 标签一起使用 -->
			<!-- 可以使用这个登记 -->
		<!-- 	<iframe id="id3show" src="/mavenweb/showUser.do" frameBorder="0" width="100%" scrolling="yes" height="100%"></iframe>基本信息
			
			 -->
			 
			<div id="id3_1"></div>		
		</div>
		<div id="id4">
			<!-- 底部相关相关信息：1.版权 2.地址 3.联系方式 -->
			<section class="copyrights">
				<section class="mainWrap">
				<span class="info">
					<span>地址：XXX省XXX市XXX县XXX镇XXX村</span>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<span>联系电话：0100101 40046644611(XX)</span>
				</span>
				<span class="icp">京ICP备XXXXXX</span>
				<span class="info">
					
					<span>版权所有 © XXXX学院 </span>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;                         
					<span>技术支持：XXXXXX</span>
				
				</span>
				<span class="icp">京公网安备 XXXXXXXX号</span>
				</section>
				</span></section>

		</div>
		</div>
	</div>
	
</body>
</html>