<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
String message="";
if(session.getAttribute("mpa")!=null){message=session.getAttribute("mpa").toString();session.removeAttribute("mpa");}
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
  <script type="text/javascript" src="javascript/admin/paperlists/loadAjax.js"></script>
  </head>
  
  <body>
    		<div class="div1"><%@include file="../../main/div1.html"%></div>
		<div class="div5">
			<div class="div2"><%@include file="../../main/div2.html"%></div>
			<div class="div3">
			
			<div style="margin-top: 50">
			<select id="pname" onchange="showID();">
			<option value="默认">请选择试卷名字</option>
				<s:iterator value="papers">
			<option value="<s:property value="papername"/>"><s:property value="papername"/></option>
			</s:iterator>
			</select>
			试卷ID：<input id="pid" readonly="readonly" style="color: gray">
			课程ID：<input id="cid" readonly="readonly" style="color: gray">
			</div>
			<div style="margin-top: 200">
			<form action="paper/modify" method="post" id="form1">
			<select id="paperid" name="paperid" onchange="showname();">
			<option value="默认">请选择试卷ID</option>
			<s:iterator value="papers">
			<option value="<s:property value="paperid"/>"><s:property value="paperid"/></option>
			</s:iterator>
			</select>
			试卷名称：<input id="papername" name="papername" value=""/>
			课程ID：<input id="courseid" readonly="readonly" style="color: gray">
			<input type="button" onclick="form1();" value="修改">
			<a href="javascript:deletep()" onclick="return confirm('是否确认删除此试卷?');" style="color:red">删除</a>
			<br/><br/>
			<span style="color:red"><s:property value="mpaper_msg"/>!!<%=message %></span>
			</form>
			</div>
			
			
			
			</div>
		</div>
		<div class="div4"><%@include file="../../main/div4.html"%></div>
  </body>
</html>
