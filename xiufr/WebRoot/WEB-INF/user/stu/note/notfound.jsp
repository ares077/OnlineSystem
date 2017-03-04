<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
  </head>
  
  <body>
    	<div class="div1"><%@include file="../../main/div5.html"%></div>
		<div class="div2">
		<div style="text-align: right">
				<form action="note/notelist2.xiu" method="post">
					<select name="courseid" id="courseid">
					<option value="默认">Choisir papier ID</option>
						<c:forEach var="co" items="${courses}">
						<option value="${co.courseid}">${co.courseid}</option>
						</c:forEach>
					</select>
					<input type="submit" value="valider"/>
				</form>
			</div>
		<div style="margin-top: 300">
		<h1>Désolé, il n'y pas de records</h1>
		</div>	
		</div>
		<div class="div3"><%@include file="../../main/div4.html"%></div>
  </body>  
</html>
