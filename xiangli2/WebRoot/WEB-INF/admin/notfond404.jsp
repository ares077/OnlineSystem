<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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

  </head>
  
  <body>
    <div class="div1"><%@include file="../main/div1.html" %></div>
		
		<div class="div5">
		<div class="div2"><%@include file="../main/div2.html" %></div>
		<div class="div3">
		<div class="tdiv">
		<h1>对不起，没有找到相关信息，请确认信息正确</h1>
		</div>
		</div>
		</div>
		
		<div class="div4"><%@include file="../main/div4.html" %></div>
  </body>
</html>
