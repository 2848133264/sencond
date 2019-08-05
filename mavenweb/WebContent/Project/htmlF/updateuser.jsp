<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户密码修改</title>


<style type="text/css">
	
	/*  编写出div的背景样式（图片，或者是其他的）  */
	#updatauser{

		width: 100%;
		height: 600px;
		background-repeat:no-repeat;
		/* background-color:olive; */
		margin-left: 0px;
		position: relative;
	}
	#second{
		position: absolute;
		margin-top:7%;
		margin-left: 29%;	 
		
	}
	#tableid{
		width: 314px;
		height: 157pxx;
		
	}
	th{
		width: 60px;
		height: 30px;
	}
	.bu{
	font-family: 楷体;
	}
	a{
		text-decoration: none;
	}
	.word{
		font-family: 楷体;
	}
</style>

</head>
<body>
	<!-- 该界面是一个用户修改密码 -->
	<!-- 要求，显示这个用户名，原密码 -->
	<br>
	<br>
	<div id="updatauser">
		<div id="second">

		    	
		    	<h2 style="font-size: 25px; margin-left: 103px;color:red;font-family: 楷体;">密&nbsp;码&nbsp;修&nbsp;改</h2>
		    <hr>
		    <form action="/mavenweb/updataUser.do" method="post">
			   <table align="center"  id="tableid">
			 	 
					<tr>
						<th class="word">您的用户名：<%=request.getSession().getAttribute("username") %></th><br>
					</tr>
					<tr></tr>
					<tr>
						<th class="word">原密码：<input type="text" name="oldPassword" placeholder="原密码"/></th>
					</tr>
					<tr>
						<th class="word">新密码：<input type="text" name="newPassword"  placeholder="新密码"/></th>
					 </tr>
					 <tr>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="submit" name="submit" value="更改" class="bu" onclick="confirm('确定修改吗?')" >
					<!-- 	<span class="bu"><a href="/mavenweb/updataUser.do">修改</a></span> -->
						
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						
						<input type="reset" name="reset" value="重置" class="bu">
					 </tr>
			    </table>
		   </form>
		  
		</div>
		 <div  style=" margin-top:-35px; color: white;" ><a href="/mavenweb/Project/home.jsp">返回上一层</a></div>
	</div>

</body>
</html>