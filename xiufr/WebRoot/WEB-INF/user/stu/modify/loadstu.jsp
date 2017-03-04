<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
String mes="";
if(session.getAttribute("modify_msg")!=null){
	mes=session.getAttribute("modify_msg").toString();
	session.removeAttribute("modify_msg");
}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>XiangLi在线考试系统</title>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
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
	<link rel="stylesheet" href="css/user/loadstu.css" type="text/css"></link>
	<script type="text/javascript" src="javascript/addLoadEvent.js"></script>
	<script type="text/javascript" src="javascript/jquery-1.4.3.js"></script>
	<script type="text/javascript" src="javascript/modifystu/loadstu.js"></script>
	</head>

	<body>
		<div class="div1"><%@include file="../../main/div5.html"%></div>
		<div class="div2">
				<div style="margin-top: 100">
					<form action="modify/modify.xiu" method="post" id="form1">
						<fieldset>
							<legend>
								<span style="font-size: 30">Votre infos</span>
							</legend>
							<table align="center" cellpadding="5" cellspacing="0" border="2">
							<tr >
							  <td width="100"><span class="span1">Numéro d'étudiant：</span></td>
							  <td colspan="2" width="400" style="text-align: left">&nbsp;&nbsp;&nbsp;<input readonly="readonly" value="${student.studentid }" name="studentid"/></td>
							  <td width="200"><span class="span1">nom et prénom：</span></td>
							  <td colspan="2" width="400" style="text-align: left">&nbsp;&nbsp;&nbsp;<input readonly="readonly" value="${student.name }" name="name"/></td>
						
							</tr>
							<tr>
							  <td><span class="span2">sex：</span></td>
							  <td style="text-align: left">&nbsp;&nbsp;&nbsp;<select name="sex">
							  <option value="${student.sex }">${student.sex }</option>
							  <option value="男">Monsieur</option>
							  <option value="女">Madame</option>
							  </select></td>
							  <td><a href="modify2/load.xiu" target="_blank" style="color: red">Modifier le mot de passe</a></td>
							  <td><span class="span2">ID chinois：</span></td>
							  <td><input value="${student.idnumber}" name="idnumber" id="idnumber" onblur="checkidnumber();" maxlength="18"/></td>
							  <td><span id="idnumber_msg" class="span3"></span></td>
							</tr>
							<tr>
							  <td><span class="span2">No de Mobile：</span></td>
							  <td width="200"><input value="${student.phonum }" name="phonum" onblur="checkphonum();" id="phonum" maxlength="11"/></td>
							  <td width="200"><span id="phonum_msg" class="span3"></span></td>
							  <td width="200"><span class="span2">E-Mail：</span></td>
							  <td width="200"><input value="${student.email}" name="email" id="email" onblur="checkemail();"/></td>
							  <td><span id="email_msg" class="span3"></span></td>
							</tr>
							<tr>
							  <td><span class="span1">UFR：</span></td>
							  <td><input value="${student.department }" readonly="readonly" name="department"/></td>
							  <td><span class="span1">Spécialité：</span></td>
							  <td><input value="${student.major}" readonly="readonly" name="major"/></td>
							  <td><span class="span1">Classe：</span></td>
							  <td><input value="${student.classinfo }" readonly="readonly" name="classinfo"/></td>
							</tr>
							<tr>
							  <td><span class="span2">Questions：</span></td>
							  <td colspan="4"><textarea name="notice" id="notice" onblur="checknotice();" rows="2" cols="130" style="color: blue">${student.notice }</textarea></td>
							  <td><span id="notice_msg" class="span3"></span></td>
							</tr>
							<tr>
							  <td><span class="span2">Réponses：</span></td>
							  <td colspan="4"><textarea name="answer" onblur="checkanswer();" id="answer" rows="2" cols="130" style="color: blue">${student.answer }</textarea></td>
							  <td><span id="answer_msg" class="span3"></span></td>
							</tr>
							<tr>
							<td colspan="5"><span class="span3"><%=mes %></span></td>
							<td><input type="button" onclick="form1();" value="valider"/></td>
							</tr>
							</table>
						</fieldset>
					</form>
				</div>
			</div>
		<div class="div3"><%@include file="../../main/div4.html"%></div>
	</body>
</html>
