<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    	<br/><br/><br/>
    	<span style="font-size: 30">votre note：</span><span style="font-size: 30;color: red">    ${score}</span>
    	<br/>
    	<input type="button" onclick="window.close()" value="fermer"/>
  </body>  
</html>
