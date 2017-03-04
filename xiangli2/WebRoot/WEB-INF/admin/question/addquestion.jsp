<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
String message="";
if(session.getAttribute("addq_msg")!=null){message=session.getAttribute("addq_msg").toString();session.removeAttribute("addq_msg");}
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
  </head>
  
  <body>
   		<div class="div1"><%@include file="../../main/div1.html"%></div>
		<div class="div5">
			<div class="div2"><%@include file="../../main/div2.html"%></div>
			
			<div class="div3">
			<div>
				 <form action="question/addquestion" method="post" id="form1">
			 <fieldset>
			 	<legend>	<span style="font-size: 30">添加题目</span></legend>
			 	<table align="center" cellpadding="5" cellspacing="0" border="1" width="80%" class="t1">
			 	<tr>
			 	  <td width="15%"><span>注意：</span></td>
			 	  <td>
			 	  	多选题答案请用逗号连接如 A,B
			 	  </td>
			 	  <td width="200">
			 	  <span class="span1">类型：</span>
			 	  <select name="type">
			 	  <option value="<s:property value="question.type"/>"><s:property value="question.type"/></option>
			 	  <option value="单选">单选</option>
			 	  <option value="多选">多选</option>
			 	  </select>
			 	  </td>
			 	   <td>
			 	  <span class="span1">难度：</span>
			 	  <select name="level">
			 	  <option value="<s:property value="question.level"/>"><s:property value="question.level"/></option>
			 	  <option value="A1">A1</option>
			 	  <option value="A2">A2</option>
			 	  <option value="B1">B1</option>
			 	  <option value="B2">B2</option>
			 	  <option value="C1">C1</option>
			 	  <option value="C2">C2</option>
			 	  </select>
			 	  </td>
			 	</tr>
			 	 <tr>
			   <td> <span class="span1">问题描述：</span></td>
			   <td colspan="3">
			   <textarea rows="2" cols="100" name="description"><s:property value="question.description"/></textarea>	
			   </td>
			  </tr>
			   <tr>
			   <td> <span class="span1">选项A：</span></td>
			   <td colspan="3">
			   <textarea rows="2" cols="100" name="a"><s:property value="question.a"/></textarea>	
			   </td>
			  </tr>
			   <tr>
			   <td> <span class="span1">选项B：</span></td>
			   <td colspan="3">
			   <textarea rows="2" cols="100" name="b"><s:property value="question.b"/></textarea>	
			   </td>
			  </tr>
			    <tr>
			   <td> <span class="span1">选项C：</span></td>
			   <td colspan="3">
			   <textarea rows="2" cols="100" name="c"><s:property value="question.c"/></textarea>	
			   </td>
			  </tr>
			   <tr>
			   <td> <span class="span1">选项D：</span></td>
			   <td colspan="3">
			   <textarea rows="2" cols="100" name="d"><s:property value="question.d"/></textarea>	
			   </td>
			  </tr>
			    <tr>
			   <td> <span class="span1">选项E：</span></td>
			   <td colspan="3">
			   <textarea rows="2" cols="100" name="e"><s:property value="question.e"/></textarea>	
			   </td>
			  </tr>
			   <tr>
			   <td> <span class="span1">选项F：</span></td>
			   <td colspan="3">
			   <textarea rows="2" cols="100" name="f"><s:property value="question.f"/></textarea>	
			   </td>
			  </tr>
			     <tr>
			   <td> <span class="span1">答案：</span></td>
			   <td colspan="3">
			   <textarea rows="2" cols="100" name="answer"><s:property value="question.answer"/></textarea>	
			   </td>
			  </tr>
			     <tr>
			   <td> <span class="span1">解析：</span></td>
			   <td colspan="3">
			   <textarea rows="2" cols="100" name="remark"><s:property value="question.remark"/></textarea>	
			   </td>
			  </tr>
			 	 <tr>
			  <td></td>
			  <td> 	  	
			   <span class="span1">所属试卷：</span>
				 <select name="paperid">
				 <option value="<s:property value="question.paperid"/>"><s:property value="question.paperid"/></option>
				 <s:iterator value="courses">
				   <option value="<s:property value="courseid"/>"><s:property value="courseid"/></option>
				 </s:iterator>
				 </select>
				</td>
				 <td>
				 <span id="addq_msg" style="color: red"><s:property
												value="addq_msg" /> </span>!!<%=message %>
												</td>
				 <td>
				 <input type="submit" value="确认添加">
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
