<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
String message="";
if(session.getAttribute("add_msg")!=null){message=session.getAttribute("add_msg").toString();session.removeAttribute("add_msg");}
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>XiangLi后台</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

		<link rel="stylesheet" href="css/global.css" type="text/css"></link>
		<link rel="stylesheet" href="css/admin/admin.css" type="text/css"></link>

	<script type="text/javascript" src="javascript/jquery-1.4.3.js"></script>
	<script type="text/javascript" src="javascript/admin/addstudent/addstudentAjax.js"></script>
	<script type="text/javascript" src="javascript/admin/addstudent/loadmajorAjax.js"></script>
	</head>

	<body>
		<div class="div1"><%@include file="../../main/div1.html"%></div>
		<div class="div5">
			<div class="div2"><%@include file="../../main/div2.html"%></div>

			<div class="div3">
				<form action="student/add" method="post">
					<fieldset>
						<legend>
							<span style="font-size: 30">添加学生</span>
						</legend>
						<table align="center" cellpadding="5" cellspacing="0">
							<tr height="50">
								<td>
									学号：
								</td>
								<td>
									<input name="studentid" id="studentid" maxlength="11" onblur="checkStudentid();" value="<s:property value="studentid"/>" />
								</td>
								<td width="100">
								   <span id="studentid_msg" style="color:red"></span>
								</td>
							</tr>
							<tr height="50">
								<td>
									密码：
								</td>
								<td>
									<input name="studentpw" id="studentpw" maxlength="20" onblur="checkStudentpw();" value="<s:property value="studentpw"/>" />
								</td>
								<td width="100"> 
								<span id="studentpw_msg" style="color:red"></span>
								</td>
							</tr>
							<tr height="50">
								<td>
									姓名：
								</td>
								<td>
									<input name="name" maxlength="20" value="<s:property value="name"/>" />
								</td>
							</tr>
							<tr height="50">
								<td>
									院系：
								</td>
								<td>
								<select name="department" id="department" onchange="loadmajor();">
								<option value="默认">请选择院系</option>
								<s:iterator value="departments">
								<option value="<s:property value="department"/>"><s:property value="department"/></option>
								</s:iterator>
								</select>
								</td>
							</tr>
							<tr height="50">
								<td>
									专业：
								</td>
								<td>
									<select name="major" id="major">			
											<option value="默认">请选择专业</option>							
									</select>
								</td>
							</tr>
							<tr height="50">
								<td>
									班级：
								</td>
								<td>
									<input name="classinfo" maxlength="6" />
								</td>
							</tr>
							<tr height="50">
								<td>
									<input type="reset" value="清空所有" />
								</td>
								<td align="center">
									<input type="submit" value="添加" />
								</td>
							</tr>
						</table>
					</fieldset>
				</form>
				<div>
				<h3><s:property value="add_msg"/>!!<%=message %></h3>
				</div>
			</div>

		</div>
		<div class="div4"><%@include file="../../main/div4.html"%></div>
	</body>
</html>
