<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	int nowPageN = Integer.parseInt(session.getAttribute("nowPageN")
			.toString());
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
  <link rel="stylesheet" href="css/admin/questionlists.css" type="text/css"></link>
  
  <script type="text/javascript" src="javascript/jquery-1.4.3.js"></script>
  <script type="text/javascript" src="javascript/admin/studentlists/studentlists.js"></script>
  </head>
  
  <body>
    <div class="div1"><%@include file="../../main/div1.html"%></div>
		<div class="div5">
			<div class="div2"><%@include file="../../main/div2.html"%></div>
			
			<div class="div3">
			
			<div class="tablediv">
					<table class="table1" border="1">
						<caption>
							<span class="span1">当前是第  <%=nowPageN%>  页记录</span>
						</caption>
						<tr class="tr1">
							<td width="50">
								成绩编号
							</td>
							<td >
								学生号
							</td>
							<td width="50">
								课程号
							</td>
							<td width="50">
								单选分数
							</td>
							<td width="50">
								多选分数
							</td>
								<td width="50">
								总分数
							</td>
							<td width="50">
								难度
							</td>
							<td width="50">
								添加时间
							</td>
								<td width="100">
								操作
							</td>
						</tr>
						<s:iterator value="notes" status="s">
						<tr class="row${s.index%2+1}">
								<td>
									<s:property value="noteid"/>
								</td>
								<td>
									<s:property value="studentid"/>
								</td>
								<td>
								<s:property value="courseid"/>
								</td>
								<td>
								<s:property value="singlecho"/>
								</td>
								<td>
								<s:property value="multicho"/>
								</td>
								<td style="color: red">
								<s:property value="total"/>
								</td>
								<td>
									<s:property value="nandu"/>
								</td>
								<td>
									<s:property value="adddate"/>
								</td>			
								<td>	
									<a href="note/onenote?noteid=<s:property value="noteid"/>">修改</a>
								</td>
							</tr>
						</s:iterator>
						
					</table>
				</div>
				<div class="divpage">
					<a href="note/notelists?nowPageN=1">首页</a>&nbsp;
					<a href="note/notelists?nowPageN=<%=nowPageN - 1%>">上一页</a>&nbsp;
					<a href="note/notelists?nowPageN=<%=nowPageN + 1%>">下一页</a>&nbsp;
					<a href="note/notelists?nowPageN=<%=Integer.MAX_VALUE%>">末页</a>&nbsp;
					<input maxlength="3" size="2" id="whichPage" />
					<input type="button" value="Go" onclick="findPage3();">
				</div>
			
			</div>
			
		</div>
		<div class="div4"><%@include file="../../main/div4.html"%></div>
  </body>
</html>
