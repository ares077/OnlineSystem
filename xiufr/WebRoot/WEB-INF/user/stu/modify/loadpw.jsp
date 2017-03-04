<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

		<title>XiangLi在线考试系统</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<link rel="stylesheet" href="css/global.css" type="text/css"></link>
		<link rel="stylesheet" href="css/user/user.css" type="text/css"></link>
	<script type="text/javascript" src="javascript/modifypw/pw.js"></script>
	</head>

	<body>
		<div style="margin-top: 100">
			<form action="modify2/pw.xiu" method="post" id="form1">
			<input name="studentid" value="<%=session.getAttribute("studentid").toString() %>" type="hidden"/>
				<fieldset>
					<legend>
						<span style="font-size: 30">Modifier le mot de passe</span>
					</legend>
					<table align="center" cellpadding="5" cellspacing="0" border="2">
					<tr>
					<td width="150">code d'origine：</td>
					<td width="200"><input name="oldpw" maxlength="20" id="oldpw" type="password" onblur="checkoldpw();"></td>
					<td width="150"><span style="color: red" id="oldpw_msg"></span></td>
					</tr>
					<tr>
					<td>nouveau code：</td>
					<td><input name="newpw" id="newpw" maxlength="20" type="password" onblur="checkpw();"/></td>
					<td><span style="color: red" id="newpw_msg"></span></td>
					</tr>
					<tr>
					<td>confirmer code：</td>
					<td><input name="newpw2" id="newpw2" maxlength="20" type="password" onblur="checkpw2();"/></td>
					<td><span style="color: red" id="newpw2_msg"></span></td>
					</tr>
					<tr>
					<td><span style="color: red" id="form1_msg"></span></td>
					<td><span style="color: red">${modifypw_msg}</span></td>
					<td><input type="button" value="valider" onclick="form1();"/></td>
					</tr>
					</table>
				</fieldset>
			</form>
		</div>
		<div style="margin-top: 100">
		<input type="button" value="fermer" onclick="ccc();"/>
		
		</div>
	</body>
</html>
