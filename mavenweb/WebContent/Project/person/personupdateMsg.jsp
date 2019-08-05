<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>病历修改</title>
<style type="text/css" src="../jquery/jquery-3.3.1.js"></style>
<style type="text/css">

	#picture{
		width:301;
		height:218px;
		margin-left: 410px;	
	}
	#titleid{
		
		margin-left: 60px;
	}
	#ti{
		width: 1000px;  
		height: 60px;
	}
	.l{
		text-align: center;
	}
	
	#main{
	
		width: 800px;
		height: 100%;
		/* background-color: red; */
		margin-left: 207px;
	}
	#table1{
	 width: 636px;
	 height: 100%;
	}
	#titles{
		font-size: 24px;
		font-family: 宋体;
	}
	td{
		width: 20px;
	}
</style>
</head>
<body >
	<!--  修改病历，能修改什么样的属性？ -->
	<!--   诊断结果-->
	<div id="ti"><span id="titleid"><h1 class="l" id="titles">门&nbsp;&nbsp;（&nbsp;急 &nbsp;）&nbsp;诊&nbsp;&nbsp; 病&nbsp;&nbsp; 历&nbsp;&nbsp; 修&nbsp;&nbsp; 改</h1></span></div>
	<br><br>
	<div id="picture">
		<img alt="十字架" src="../img/image002.gif" style="width: 166px;height: 146px;">
	</div>
	<div id="main">
		<form action="${pageContext.servletContext.contextPath }/personupdata.do" method="post">
			<table id="table1">
				<tr>
					<td >病&nbsp;&nbsp;历&nbsp;&nbsp;号：</td><!-- 根据病历号进行数据查询是否能修改 -->
					<td><input type="text" name="id" ></td>	
					<td>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:</td><td><input type="text" name="name"></td>
					</tr>
					<tr>
					<td>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:</td>
					<td>
						<select name="sex">
							<option  value="男">男</option>
							<option  value="女">女</option>
						</select>
					</td>
					<td>婚&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;否：</td>
					<td>
						<select name="isMarry">
							<option  value="是">是</option>
							<option  value="否">否</option>
						</select>
					</td>	
				</tr>
				<tr>
					<td>电话号码：</td><td><input type="text" name ="phone"></td>
					<td>身份证号码：</td><td><input type="text" name ="idCard" ></td>			
				</tr>	
			</table>
			
			现状：<br><textarea rows="3" cols="90" name="xianzhuang"></textarea><br><br>
			诊断结果：<br><textarea rows="3" cols="90" name="result"></textarea>
			<br>
			<br>
				<button style="width: 124px;height: 40px;margin-left: 418px;border-radius: 6px;" onclick="confirm('确定修改吗？')" >修改</button>
		</form>
				<button  style="width: 124px;height: 40px;margin-top: -40px;margin-left: 31px;border-radius: 6px;" onclick="back1()">返回</button>
			
	</div>

<script type="text/javascript">
	function back1() {
		window.history.back();
	}

</script>
</body>
</html>