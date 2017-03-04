<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>XiangLi</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<link rel="stylesheet" href="css/global.css" type="text/css"></link>
	<link rel="stylesheet" href="css/login.css" type="text/css"></link>
	
	<script type="text/javascript" src="javascript/jquery-1.4.3.js"></script>
	<script type="text/javascript" src="javascript/login/login.js"></script>
	</head>
	<body >
		<div>
			<form action="login/login.xiu" method="post" id="form1">
				<table>
					<tr>
						<td width="100">
							帐号/学号：
						</td>
						<td width="50">
							<input name="adminid" maxlength="20"
								value="" />
						</td>
						<td width="100">
							<span id="adminid_msg"></span>
						</td>
					</tr>
					<tr>
						<td>
							密码：
						</td>
						<td>
							<input name="adminpw" maxlength="20" type="password"
								value="" />
						</td>
						<td>
							<span id="adminpw_msg"></span>
						</td>
					</tr>
					<tr style="color:blue; ">
						<td colspan="3">
						<a href="http://localhost:8080/xiangli2" style="color: red">管理员登录</a>	
							<input type="radio" name="statu" checked="checked" value="1" id="radio2" />
							<a href="javascript:changeState2();">学生</a>	
							<input type="radio" name="statu" value="3" id="radio3"/>
							<a href="javascript:changeState3();">游客</a>	
						</td>
					</tr>
					<tr>
						<td>
							<img src="login/createImage.xiu" alt="验证码" title="点击更换"
								onclick="change(this);">
						</td>
						<td>
							<input name="vcode" id="vcode" maxlength="4" size="5" onblur="checkCode();"/>
						</td>
						<td>
							<span id="vcode_msg"></span>
						</td>
					</tr>
					<tr>
						<td>
							<span id="login_msg"></span>
						</td>
						<td>
							<input type="reset" value="重置" />
						</td>
						<td>
							<input type="submit" value="登录"   />
						</td>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>
