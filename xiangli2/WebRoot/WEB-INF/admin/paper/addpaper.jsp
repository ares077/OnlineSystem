<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
String message="";
if(session.getAttribute("apa")!=null){message=session.getAttribute("apa").toString();session.removeAttribute("apa");}
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
  <script type="text/javascript" src="javascript/admin/addpaper/addpaperAjax.js"></script>
  </head>
  
  <body>
    	<div class="div1"><%@include file="../../main/div1.html"%></div>
		<div class="div5">
			<div class="div2"><%@include file="../../main/div2.html"%></div>
			<div class="div3">
			
			<div style="margin-top: 50">
			<form action="paper/add" method="post" id="form2">
			请输入试卷ID：<input name="paperid" id="paperid" onblur="checkid();"><br/>
			<span style="color:red" id="pid_msg"></span>
			<br/><br/>
			请输入试卷名称：<input name="papername" id="papername" onblur="checkname();"><br/>
			<span style="color:red" id="pname_msg"></span>
			<br/><br/>
			<select name="courseid">
			<option value="<s:property value="courseid"/> "><s:property value="courseid"/> </option>
			<s:iterator value="courses">
			<option value="<s:property value="courseid"/>"><s:property value="courseid"/></option>
			</s:iterator>
			</select>
			<br/><br/><br/><br/>
			<input type="button" onclick="addaction();" value="确认添加"><br/>
			<span style="color:red" id="msg"><s:property value="paper_msg"/>!!<%=message %></span>
			<br/><br/><br/>
			提示： 添加的试卷ID 最好包含 课程ID  如:  试卷ID（java01A） 课程id：（java01）
			</form>
			</div>
			
			
			
			</div>	
		</div>
		<div class="div4"><%@include file="../../main/div4.html"%></div>
  </body>
</html>
