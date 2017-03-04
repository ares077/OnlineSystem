<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	int nowPageQ = Integer.parseInt(session.getAttribute("nowPageQ")
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
		<link rel="stylesheet" href="css/admin/questionlists.css"
			type="text/css"></link>

	<script type="text/javascript" src="javascript/jquery-1.4.3.js"></script>
	<script type="text/javascript" src="javascript/admin/questionlists/questionlists.js"></script>
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
							<s:iterator value="courses">
							<option value="<s:property value="courseid" />"><s:property value="courseid" /></option>
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

				<div class="tablediv">
					<table class="table1" border="1">
						<caption>
							<span class="span1">当前是第  <%=nowPageQ%>  页记录</span>
						</caption>
						<tr class="tr1">
							<td width="50">
								题目编号
							</td>
							<td >
								题目描述
							</td>
							<td width="50">
								类型
							</td>
							<td width="50">
								难度
							</td>
							<td width="100">
								所属试卷ID
							</td>
							<td width="100">
								添加时间
							</td>
								<td width="100">
								操作
							</td>
						</tr>
						<s:iterator value="questions" status="s">
						<tr class="row${s.index%2+1}">
								<td>
									<s:property value="questionid"/>
								</td>
								<td>
								<textarea readonly="readonly"rows="2" cols="70"><s:property value="description"/></textarea>	
								</td>
								<td>
								<s:property value="type"/>
								</td>
								<td>
								<s:property value="level"/>
								</td>
								<td>
								<s:property value="paperid"/>
								</td>
								<td>
									<s:property value="adddate"/>
								</td>			
								<td>
									<a
										href="question/delete?questionid=<s:property value="questionid"/>"
										onclick="return confirm('是否确认删除题目   <s:property value="description"/> ');">删除</a>
									<a href="question/onequestion?questionid=<s:property value="questionid"/>">修改</a>
								</td>
							</tr>
						</s:iterator>
						
					</table>
				</div>
				<div class="divpage">
					<a href="question/questionlists?nowPageQ=1">首页</a>&nbsp;
					<a href="question/questionlists?nowPageQ=<%=nowPageQ - 1%>">上一页</a>&nbsp;
					<a href="question/questionlists?nowPageQ=<%=nowPageQ + 1%>">下一页</a>&nbsp;
					<a href="question/questionlists?nowPageQ=<%=Integer.MAX_VALUE%>">末页</a>&nbsp;
					<input maxlength="3" size="2" id="whichPage" />
					<input type="button" value="Go" onclick="findPage();">
				</div>
			</div>

		</div>
		<div class="div4"><%@include file="../../main/div4.html"%></div>
	</body>
</html>
