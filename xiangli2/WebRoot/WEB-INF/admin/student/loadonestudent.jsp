<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
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

		<title>XiangLi后台</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<link rel="stylesheet" href="css/global.css" type="text/css"></link>
		<link rel="stylesheet" href="css/admin/admin.css" type="text/css"></link>
      <script type="text/javascript" src="javascript/addLoadEvent.js"></script>
		<script type="text/javascript" src="javascript/jquery-1.4.3.js"></script>
	<script type="text/javascript" src="javascript/admin/studentlists/loadonestudent.js"></script>
	<link rel="stylesheet" href="css/admin/loadonestudent.css" type="text/css"></link>
	<script type="text/javascript" src="javascript/admin/addstudent/loadmajorAjax.js"></script>
	</head>

	<body>
		<div class="div1"><%@include file="../../main/div1.html"%></div>

		<div class="div5">
			<div class="div2"><%@include file="../../main/div2.html"%></div>
			<div class="div3">

				<div>
					<form action="student/modify" method="post" id="form1">
						<fieldset>
							<legend>
								<span style="font-size: 30">学生信息</span>
							</legend>
							<table align="center" cellpadding="5" cellspacing="0" border="2">
								<tr>
									<td>
										<span>学号：</span>
									</td>
									<td>
										<input size="10" name="studentid" readonly="readonly"
											value="<s:property value="student.studentid"/>" />
									</td>
									<td>
										<span class="span1">密码：</span>
									</td>
									<td>
										<input size="17" maxlength="20" name="studentpw"
											id="studentpw" onblur="checkStudentpw();"
											value="<s:property value="student.studentpw"/>" />
									</td>
									<td width="100">
										<span id="studentpw_msg" style="color: red"></span>
									</td>
								</tr>

								<tr>
									<td>
										<span class="span1">姓名：</span>
									</td>
									<td>
										<input size="10" name="name"
											value="<s:property value="student.name"/>" />
									</td>
									<td>
										<span class="span1">性别：</span>
									</td>
									<td>
										<select name="sex">
											<option value="<s:property value="student.sex"/>">
												<s:property value="student.sex" />
											</option>
											<option value="男">
												男
											</option>
											<option value="女">
												女
											</option>
										</select>
									</td>
									<td>

									</td>
								</tr>

								<tr>
									<td>
										<span>身份证号：</span>
									</td>
									<td>
										<input size="15" name="idnumber" readonly="readonly"
											value="<s:property value="student.idnumber"/>" />
									</td>
									<td>
										<span>手机号：</span>
									</td>
									<td>
										<input size="10" name="phonum" readonly="readonly"
											value="<s:property value="student.phonum"/>" />
									</td>
									<td>

									</td>
								</tr>

								<tr>
									<td>
										<span>电子邮箱：</span>
									</td>
									<td>
										<input size="15" name="email" readonly="readonly"
											value="<s:property value="student.email"/>" />
									</td>
									<td>
										<span class="span1">院系：</span>
									</td>
									<td>
										<select name="department" onchange="loadmajor();" id="department">
											<option value="<s:property value="student.department"/>">
												<s:property value="student.department" />
											</option>
											
												<s:iterator value="departments">
								<option value="<s:property value="department"/>"><s:property value="department"/></option>
								</s:iterator>
										</select>
									</td>
									<td>

									</td>
								</tr>

								<tr>
									<td>
										<span class="span1">专业：</span>
									</td>
									<td>
										<select name="major" id="major">
												<option value="<s:property value="student.major"/>">
													<s:property value="student.major" />
												</option>				
										</select>
									</td>
									<td>
										<span class="span1">班级：</span>
									</td>
									<td>
										<input name="classinfo" maxlength="6"
											onblur="checkStudentclass();" size="5" id="classinfo"
											value="<s:property value="student.classinfo"/>" />
									</td>
									<td>
										<span id="classinfo_msg" style="color: red"></span>
									</td>
								</tr>

								<tr>
									<td>
										<span>提示问题：</span>
									</td>
									<td>
										<textarea rows="7" cols="20" readonly="readonly" name="notice">
											<s:property value="student.notice" />
										</textarea>
									</td>
									<td>
										<span>问题答案：</span>
									</td>
									<td>
										<textarea rows="7" cols="20" readonly="readonly" name="answer">
											<s:property value="student.answer" />
										</textarea>
									</td>
									<td>
									</td>
								</tr>

								<tr>
									<td>
										<span>状态：</span>
									</td>
									<td colspan="3">
										<input size="11" name="states" readonly="readonly"
											value="<s:property value="states"/>" id="states" />
									</td>
									<td>

									</td>
								</tr>

								<tr>
									<td>
										<span id="modify_msg" style="color: red"><s:property
												value="modify_msg" /> </span>
									</td>
									<td>
									<s:if test="states=='正常用户'"><a href="student/delete?studentid=<s:property value="student.studentid"/>"
										onclick="return confirm('是否确认删除  <s:property value="student.name"/>  的所有信息?');">删除</a></s:if>
									</td>
									<td colspan="2">
									<input type="button" value="返回学生列表" onclick="location.href='student/studentlists'"/>
									</td>
									<td>
										 <s:if test="states=='正常用户'">	<input type="submit" value="修改"></s:if>
									</td>
								</tr>

							</table>
						</fieldset>
					</form>
				</div>

			</div>
		</div>

		<div class="div4"><%@include file="../../main/div4.html"%></div>
	</body>
</html>
