<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>病历登记</title>
<style type="text/css">
*{
	font-family: 楷体;
	font-size: 19px;
}
	#picture{
		width:279px;
		height:218px;
		margin-left: 374px;	
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
		font-size: 32px;
		font-family: 楷体;
	}
	#mainid{
		margin-left: 205px;
	}
</style>
</head>
<body>
	<div id="ti"><span id="titleid"><h2 class="l">门&nbsp;&nbsp;（&nbsp;急 &nbsp;）&nbsp;诊&nbsp; 病&nbsp; 历&nbsp; 登&nbsp; 记</h2></span></div>
	<br><br>
	<div id="picture">
		<img alt="十字架" src="../img/image002.gif" style="width: 225px;height: 160px;">
	</div>
	<div id="mainid">
		<form action="${pageContext.servletContext.contextPath }/personadd.do" method="post">
			<table>
				<tr>
					<td>病历号:</td><td><input type="text" name="id" placeholder="1**"></td>
				</tr>
				<tr>
					<td>姓&nbsp;&nbsp;&nbsp;&nbsp;名：</td><td><input type="text" name="personname" /></td>
					<td>年&nbsp;&nbsp;&nbsp;&nbsp;龄: </td><td><input type="text" name="age" /></td>
				</tr>
				<tr>
					<td>性&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
					<td>
						<select name="sex">
							<option  value="男" selected="selected">男</option>
							<option  value="女">女</option>
						</select>
					</td>
					
					<td>婚&nbsp;&nbsp;&nbsp;&nbsp;否：</td>
					<td>
						<select name="isMarry">
							<option  value="是" selected="selected">是</option>
							<option  value="否">否</option>
						</select>
					</td>
				</tr>
				
				<tr>
					<td>就诊时间：</td><td><input type="date" name="inDate"></td>
					<td>出生日期：</td><td><input type="date" name="birthday"></td>
				</tr>
				<tr>
					<td>电&nbsp;&nbsp;&nbsp;&nbsp;话：</td><td><input type="text" name="phone"></td>
					<td>单&nbsp;&nbsp;&nbsp;&nbsp;位：</td><td><input type="text" name="company"></td>
				</tr>
				<tr>
					<td>身份证号：</td><td><input type="text" name="idCard" placeholder="7为数，不能0开头"></td>
					<td>联系地址：</td><td><input type="text" name="address"></td>
				</tr>
				
			</table>
			<br>
			<span style="margin-left: 234px;"><input type="submit" name="submit" value="保存" onclick="confirm('确定保存?')"></span>
		</form>
	</div>
</body>
</html>