<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
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
		<link rel="stylesheet" href="css/admin/admin.css" type="text/css"></link>
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
			 <form action="question/modify" method="post" id="form1">
			 <fieldset>
			 	<legend>	<span style="font-size: 30">题目信息</span></legend>
			 	<table align="center" cellpadding="5" cellspacing="0" border="1" width="80%" class="t1">
			 	<tr>
			 	  <td width="15%"><span>题目编号：</span></td>
			 	  <td>
			 	  	<input size="10" name="questionid" readonly="readonly"
											value="<s:property value="question.questionid"/>" />
			 	  </td>
			 	  <td>
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
			  <td><span>添加日期：</span></td>
			  <td> 	  	
			  <input size="10" name="adddate" readonly="readonly"
											value="<s:property value="question.adddate"/>" />
				</td>
				 <td><span>状态：</span> <input size="11" name="states" readonly="readonly"
											value="<s:property value="states"/>" id="states" /></td>
				 <td>
				  <span class="span1">所属试卷：</span>
				 <select name="paperid">
				 <option value="<s:property value="question.paperid"/>"><s:property value="question.paperid"/></option>
				 <s:iterator value="courses">
				   <option value="<s:property value="courseid"/>"><s:property value="courseid"/></option>
				 </s:iterator>
				 </select>
					</td>
			  </tr>
			 	<tr>
			 	<td>
			 	<s:if test="states=='已禁用'">	<input type="button" value="启用" onclick="ison();" /></s:if>
			
			 <s:if test="states=='正在使用'">	<a	style="color: red" href="question/delete?questionid=<s:property value="question.questionid"/>"
										onclick="return confirm('是否确认删除题目   <s:property value="question.description"/> ');">删除</a></s:if>
			 	</td>
			 	<td >
			 	<span id="modify_msg" style="color: red"><s:property
												value="modify_msg" /> </span>
			 	</td>
			 		<td>
			 		<input type="button" value="返回题目列表" onclick="location.href='question/questionlists'"/>
			 		</td>
			 	<td>
			 	 	<input type="submit" value="修改" id="submit"/>
			 	</td>
			 	</tr>
			 	</table>
			 	<input type="hidden" name="isOn" id="isOn" value="0"/>
			 </fieldset>
			 </form>
			</div>
			
			</div>
		</div>
		<div class="div4"><%@include file="../../main/div4.html"%></div>
  </body>
</html>
