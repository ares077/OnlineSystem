<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
		<link rel="stylesheet" href="css/admin/questionlists.css"
			type="text/css"></link>
	</head>

	<body>
		<div class="div1"><%@include file="../../main/div1.html"%></div>
		<div class="div5">
			<div class="div2"><%@include file="../../main/div2.html"%></div>

			<div class="div3">
				<div class="selectdiv">
					<form action="question/onequestion" method="post">
						<input name="questionid" id="qid" placeholder="请输入题目编号" />
						<input type="submit" value=">>">
					</form>
				</div>
				<div class="selectdiv">
					<form action="question/questionlists2" method="post">
						试卷ID：
						<select name="paperid">
							<option value=""></option>
							<s:iterator value="paperids">
							<option value="<s:property value="paperid" />"><s:property value="paperid" /></option>
							</s:iterator>
						</select>
						题目类型：
						<select name="type">
							<option value=""></option>
							<option value="单选">
								单选
							</option>
							<option value="多选">
								多选
							</option>
						</select>
						题目难度：
						<select name="level">
							<option value=""></option>
							<option value="A1">
								A1
							</option>
							<option value="A2">
								A2
							</option>
							<option value="B1">
								B1
							</option>
							<option value="B2">
								B2
							</option>
							<option value="C1">
								C1
							</option>
							<option value="C2">
								C2
							</option>
						</select>
						<input name="key" placeholder="请输入关键字" />
						<input type="submit" value="查找">
					</form>
				</div>

				<div>
					<h1> 没有找到符合条件的记录！ </h1>
				</div>
			</div>

		</div>
		<div class="div4"><%@include file="../../main/div4.html"%></div>
	</body>
</html>
