<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	//Session验证
	Object studentid = session.getAttribute("studentid");
   String stuname="";
	if (studentid == null) {
		response.sendRedirect("tologin.xiu");
		return;
	}else{
		 stuname = session.getAttribute("stuname").toString();
	}
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
    	<div class="div1"><%@include file="../main/div5.html"%></div>
		<div class="div2">
		<div style="margin-top: 300">
		<h1><%=stuname %>,Soyez bienvenu au système d'examen en ligne (Xiang LI)</h1>
		<h1><a href='lexique/lexiquemain.xiu'>Le Lexique</a></h1>
		</div>	
		</div>
		<div class="div3"><%@include file="../main/div4.html"%></div>
  </body>  
</html>
