<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>erreur！</title>
    
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
   erreur,&nbsp;<span id="seconds">5</span>&nbsp;seconds retourner au page Login, cliquer pour retourner maintenant&nbsp;
   <a href="javascript:resetTimer();">Retourner</a>
   </h1>
  </body>
</html>
