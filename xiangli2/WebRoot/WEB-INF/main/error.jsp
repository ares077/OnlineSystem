<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>遇到错误啦！</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
<script type="text/javascript" src="javascript/addLoadEvent.js"></script>
<script type="text/javascript" src="javascript/error.js"></script>
</head>
 <body>
   <h1>
   遇到错误,&nbsp;<span id="seconds">5</span>&nbsp;秒后将自动跳转，立即跳转请点击&nbsp;
   <a href="javascript:resetTimer();">返回</a>
   </h1>
  </body>
</html>
