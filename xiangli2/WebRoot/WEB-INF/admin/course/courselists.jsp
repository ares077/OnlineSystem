<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
String message="";
if(session.getAttribute("mcname")!=null){message=session.getAttribute("mcname").toString();session.removeAttribute("mcname");}
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
  <script type="text/javascript" src="javascript/admin/courselists/courseAjax.js"></script>
  </head>
  
  <body>
    	<div class="div1"><%@include file="../../main/div1.html"%></div>
		<div class="div5">
			<div class="div2"><%@include file="../../main/div2.html"%></div>		
			<div class="div3">
			
			<div style="margin-top: 30">
			<select id="s1" onchange="showID();">
			<option value="默认">请选择课程名</option>
			<s:iterator value="courses">
			<option value="<s:property value="coursename"/>"><s:property value="coursename"/></option>
			</s:iterator>
			</select>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			课程id：
			<select id="s1t1">
			</select>
			</div>
			
			<div style="margin-top: 300">
			<form action="course/modify" method="post" id="form1">
			<select name="courseid" id="courseid" onchange="showName();">
			<option value="默认">请选择课编号</option>
			<s:iterator value="courses">
			<option value="<s:property value="courseid"/>"><s:property value="courseid"/></option>
			</s:iterator>
			</select>
			<span style="color:blue">课程名：</span>
			<input name="coursename" id="coursename"/>
			<input type="button" value="修改" onclick="form1();"/>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="javascript:deletec()" onclick="return confirm('是否确认删除此课程?');" style="color:red">删除</a>
		<!--  <input type="button" value="删除" onclick="return confirm('是否确认删除此课程?');deletec()"> -->	
			<br/><br/><br/>
			<span style="color:red"><s:property value="mcname_msg"/>!!<%=message %></span>
			</form>
			</div>
			
			</div>		
		</div>
		<div class="div4"><%@include file="../../main/div4.html"%></div>
  </body>
</html>
