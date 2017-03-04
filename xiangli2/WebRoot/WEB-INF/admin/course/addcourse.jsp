<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
String message="";
if(session.getAttribute("addc")!=null){message=session.getAttribute("addc").toString();session.removeAttribute("addc");}
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
		<link rel="stylesheet" href="css/admin/admin.css"type="text/css"></link>

  <script type="text/javascript" src="javascript/jquery-1.4.3.js"></script>
  <script type="text/javascript" src="javascript/admin/addcourse/addcourse.js"></script>
  </head>
  
  <body>
    	<div class="div1"><%@include file="../../main/div1.html"%></div>
		<div class="div5">
			<div class="div2"><%@include file="../../main/div2.html"%></div>
			<div class="div3">
			
			<div style="margin-top: 50">
			<form action="course/add" method="post" id="form2">
			课程ID：<input name="courseid" id="courseid" onblur="checkcid();" value="<s:property value="courseid"/>"/> 
			<br/>
			<span style="color:red" id="checkcid"></span>
			<br/><br/>
			课程名：<input name="coursename" id="coursename" value="<s:property value="coursename"/>"/>
			<br/><br/>
			<input type="button" value="确认添加" onclick="form2();">
			<br/>
			<span style="color: red" id="addcourse_msg"><s:property value="addcourse_msg"/>!!<%=message %> </span>
			<br/><br/><br/>
			提示： 添加的课程名最好包含课程ID  如： ID（java01）    名（java基础）
			</form>
			</div>
			
			</div>
		</div>
		<div class="div4"><%@include file="../../main/div4.html"%></div>
  </body>
</html>
