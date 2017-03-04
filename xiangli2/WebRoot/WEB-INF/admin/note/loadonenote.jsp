<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
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
		<link rel="stylesheet" href="css/admin/admin.css"type="text/css"></link>
  <link rel="stylesheet" href="css/admin/loadonestudent.css" type="text/css"></link>
  <script type="text/javascript" src="javascript/addLoadEvent.js"></script>
  <script type="text/javascript" src="javascript/jquery-1.4.3.js"></script>
  <script type="text/javascript" src="javascript/admin/questionlists/loadonequestion.js"></script>
  </head>
  
  <body>
    	<div class="div1"><%@include file="../../main/div1.html"%></div>
		<div class="div5">
			<div class="div2"><%@include file="../../main/div2.html"%></div>
			
			<div class="div3">
			<div>
			 <form action="note/modify" method="post" id="form1">
			 <fieldset>
			 	<legend>	<span style="font-size: 30">成绩信息</span></legend>
			 	<table align="center" cellpadding="5" cellspacing="0" border="1" width="80%" class="t1">
			 	<tr>
			 	 <td>
			 	   <span>成绩编号：</span>
			 	 </td>
			 	 <td>
			 	  <input value="<s:property value="noteid"/>" name="noteid" readonly="readonly"/>
			 	 </td>
			 	</tr>
			 	<tr>
			 	 <td>
			 	   <span>学生号：</span>
			 	 </td>
			 	 <td>
			 	  <input value="<s:property value="note.studentid"/>" name="studentid" readonly="readonly"/>
			 	 </td>
			 	</tr>
			 	<tr>
			 	 <td>
			 	   <span>课程号：</span>
			 	 </td>
			 	 <td>
			 	  <input value="<s:property value="note.courseid"/>" name="courseid" readonly="readonly"/>
			 	 </td>
			 	</tr>
			 	<tr>
			 	 <td>
			 	   <span class="span1">单选分数</span>
			 	 </td>
			 	 <td>
			 	  <input value="<s:property value="note.singlecho"/>" name="singlecho" id="singlecho" maxlength="3"/>
			 	 </td>
			 	</tr>
			 	<tr>
			 	 <td>
			 	   <span class="span1">多选分数</span>
			 	 </td>
			 	 <td>
			 	  <input value="<s:property value="note.multicho"/>" name="multicho" id="multicho" maxlength="3"/>
			 	 </td>
			 	</tr>
			 	<tr>
			 	 <td>
			 	   <span>日期：</span>
			 	 </td>
			 	 <td>
			 	  <input value="<s:property value="note.adddate"/>" name="adddate" readonly="readonly"/>
			 	 </td>
			 	</tr>
			 	<tr>
			 	<td>
			 	<input type="button" value="返回成绩列表" onclick="location.href='note/notelists'"/>
			 	</td>
			 	<td>
			 	<input type="button" value="确认修改" onclick="checkScore();"/>
			 	<span style="color:red" id="mnote_msg"><s:property value="mnote_msg"/></span>
			 	</td>
			 	</tr>
			 	</table>
			 </fieldset>
			 </form>
			
			
			
			
			
			</div>
			
			
			</div>
			
		</div>
		<div class="div4"><%@include file="../../main/div4.html"%></div>
  </body>
</html>
