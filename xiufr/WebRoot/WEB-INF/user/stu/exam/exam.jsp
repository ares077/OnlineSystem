<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<script type="text/javascript" src="javascript/jquery-1.4.3.js">
</script>
		<script type="text/javascript" src="javascript/exam/Ajax.js">
</script>
	</head>

	<body>
		<div class="div1"><%@include file="../../main/div5.html"%></div>
		<div class="div2">
			<div style="margin-top: 150">
				<form action="exam/exam.xiu" method="post" id="form1">
				<fieldset>
							<legend>
								<span style="font-size: 30">Choisir un examen</span>
							</legend>
							<input type="hidden" name="studentid" id="studentid" value="<%=session.getAttribute("studentid").toString() %>"/>
							<br/><br/><br/>
					<table align="center" cellpadding="5" cellspacing="0" border="2">
						<tr>
							<td width="150">
								<select name="courseid" id="courseid"
									onchange="showName();showPid();">
									<option value="nul">
										choisir ID
									</option>
									<c:forEach var="co" items="${courses}">
										<option value="${co.courseid}">
											${co.courseid}
										</option>
									</c:forEach>
								</select>
							</td>
							<td width="200">
								<input readonly="readonly" id="cname" style="color: gray" />
							</td>
						</tr>
						<tr>
							<td>
								<select name="paperid" id="paperid" onchange="showpName();">
								</select>
							</td>
							<td>
								<input readonly="readonly" id="pname" style="color: gray" />
							</td>
						</tr>
						<tr>
						<td><span style="color: red" id="msg">${exam_msg}</span></td>
						<td><input type="button" onclick="sub();" value="valider"/></td>
						</tr>
					</table>
					<br/><br/><br/>
					</fieldset>
				</form>
			</div>
		</div>
		<div class="div3"><%@include file="../../main/div4.html"%></div>
	</body>
</html>
