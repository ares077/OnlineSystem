<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="entity.admin.Student"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	int nowPage = Integer.parseInt(session.getAttribute("nowPage")
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
		<link rel="stylesheet" href="css/admin/studentlists.css"
			type="text/css"></link>
		<script type="text/javascript" src="javascript/jquery-1.4.3.js">
</script>
		<script type="text/javascript"
			src="javascript/admin/studentlists/studentlists.js">
</script>
	</head>

	<body>
		<div class="div1"><%@include file="../../main/div1.html"%></div>
		<div class="div5">
			<div class="div2"><%@include file="../../main/div2.html"%></div>

			<div class="div3">
				<div class="tablediv">
					<table class="table1" border="1">
						<caption>
							<span class="span1">当前是第<%=nowPage%>页记录</span>
						</caption>
						<tr class="tr1">
							<td width="90">
								学号
							</td>
							<td width="100">
								密码
							</td>
							<td width="50">
								姓名
							</td>
							<td width="30">
								性别
							</td>
							<td width="150">
								身份证号
							</td>
							<td width="95">
								手机号
							</td>
							<td width="120">
								邮箱
							</td>
							<td width="170">
								院系
							</td>
							<td width="50">
								班级
							</td>
							<td width="80">
								操作
							</td>
						</tr>
						<c:forEach var="stu" items="${students}" varStatus="s">
							<tr class="row${s.index%2+1}">
								<td>
									${stu.studentid}
								</td>
								<td>
									${stu.studentpw}
								</td>
								<td>
									${stu.name}
								</td>
								<td>
									${stu.sex}
								</td>
								<td>
									${stu.idnumber}
								</td>
								<td>
									${stu.phonum}
								</td>
								<td>
									${stu.email}
								</td>
								<td>
									${stu.department}
								</td>
								<td>
									${stu.classinfo}
								</td>
								<td>
									<a
										href="student/delete?studentid=${stu.studentid }"
										onclick="return confirm('是否确认删除  ${stu.name} 的所有信息?');">删除</a>
									<a href="student/onestudent?studentid=${stu.studentid}">修改</a>
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>
				<div class="divpage">
					<a href="student/studentlists?nowPage=1">首页</a>&nbsp;
					<a href="student/studentlists?nowPage=<%=nowPage - 1%>">上一页</a>&nbsp;
					<a href="student/studentlists?nowPage=<%=nowPage + 1%>">下一页</a>&nbsp;
					<a href="student/studentlists?nowPage=<%=Integer.MAX_VALUE%>">末页</a>&nbsp;
					<input maxlength="3" size="2" id="whichPage" />
					<input type="button" value="Go" onclick="findPage();">
				</div>
			</div>

		</div>
		<div class="div4"><%@include file="../../main/div4.html"%></div>
	</body>
</html>
