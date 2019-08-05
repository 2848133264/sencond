<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>初始界面</title>
<style type="text/css">

	body{
		background-image: url("../img/b2.jpg");
		background-repeat: no-repeat;
		background-size: 100% 100%;
	}
	#main{
		width: 100%;
		height: 132%;
		margin-top: 10px;
		
	}
	#formid{
		width: 400px;
		height: 373px;
		background-color: #ffff000a;
		margin-left: -59px;
	}
	/* 按钮的设置  */
	.but{
		border-radius: 2px;
		border: white;
		width: 55px;
		font-family:"SimSun";
		font-size: 18px;
		background-color: aquamarine
	}
		tr{
			font-family:"Hiragino Sans GB";
		}
	  .td_left{
            width: 100px;
            text-align: right;
            height: 50px;
            padding-left: 10px;
            font-size: 20px;
            font-family: 楷体;
        }
        .td_right{
            padding-left: 20PX;
        }
        #titleid{
         width: 367px;
         height: 61px;
        }
        #biaoti{
         font-family: 楷体;
         margin-left: -10px;

        font-size: 30px;
        }
</style>
</head>
<body>
<br>
<br>
<div id="main" align="center">
	<!--  标题 显示-->
	<div id="titleid">
		<span id ="biaoti">电&nbsp;子&nbsp;病&nbsp;历&nbsp;系&nbsp;统&nbsp;登&nbsp;入</span>
	</div>
	<div id="formid">
			<form action="${pageContext.servletContext.contextPath }/login.do"  method="post" >
				 	<table align="center">
				 		 <tr>
                        <td class="td_left">账号：</td>
                        <td class="td_right"><input type="text" name="username" required = "required" placeholder="在此输入账号" id="username" ></td>
                    </tr>
                    <tr>
                        <td class="td_left">密码：</td>
                        <td class="td_right"><input type="password" name="password" value="" required ="required" placeholder="在此输入密码" id="password"></td>
                    </tr>
                   
                    <tr>
                        <td colspan="2" align="center"><input type="submit" name="submit" value="登 入" class="but"></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center"><font color="red" size="5px">${error}</font></td>
                    </tr>
				 	</table>
			</form>
	</div>
</div>
<script type="text/javascript">
	function regester() {
		window.location.href="regester.jsp";
	}
</script>
</body>
</html>