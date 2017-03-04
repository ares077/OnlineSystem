<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	int nowPage2 = Integer.parseInt(session.getAttribute("nowPage2")
			.toString());
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>XiangLi在线考试系统</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<link rel="stylesheet" href="css/global.css" type="text/css"></link>
		<link rel="stylesheet" href="css/user/user.css" type="text/css"></link>
		<link rel="stylesheet" href="css/user/questionlists.css"
			type="text/css"></link>
		<script type="text/javascript" src="javascript/jquery-1.4.3.js">
</script>
		<script type="text/javascript" src="javascript/note/note.js">
</script>
	</head>

	<body>
		<div class="div1"><%@include file="../../main/div5.html"%></div>
		<div class="div2">
			<div style="text-align: right">
				<form action="note/notelist2.xiu" method="post">
					<select name="courseid" id="courseid">
					<option value="${courseid}">${courseid}</option>
						<c:forEach var="co" items="${courses}">
						<option value="${co.courseid}">${co.courseid}</option>
						</c:forEach>
					</select>
					<input type="submit" value="valider"/>
				</form>
			</div>
			<div class="tablediv">
				<table class="table1" border="1">
					<caption>
						<span class="span1">Now </span><span id="nowPage2" class="span1"> <%=nowPage2%> </span><span class="span1"> Page</span>
					</caption>
					<tr class="tr1">
						<td width="50">
							No d'examen
						</td>
						<td width="200">
							No de cours
						</td>
						<td width="100">
							CS
						</td>
						<td width="100">
							CM
						</td>
						<td width="100">
							Total
						</td>
						<td width="50">
							difficulté
						</td>
						<td width="50">
							Date
						</td>
						<td width="100">
							manipuler
						</td>
					</tr>
					<c:forEach var="n" items="${notes}" varStatus="s">
						<tr class="row${s.index%2+1}">
							<td>
								${n.noteid}
							</td>
							<td>
								${n.courseid}
							</td>
							<td>
								${n.singlecho}
							</td>
							<td>
								${n.multicho}
							</td>
							<td style="color: red">
								${n.total}
							</td>
							<td>
								${n.nandu}
							</td>
							<td>
								${n.adddate}
							</td>
							<td>
								<a href="cuoti/ct.xiu?noteid=${n.noteid}" target="_blank">Voir défautes</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="divpage">
				<a href="javascript:Page1();">Home Page</a>&nbsp;
					<a href="javascript:prePage();">Précédent</a>&nbsp;
					<a href="javascript:nextPage();">suivant</a>&nbsp;
					<a href="javascript:endPage();">Dernière</a>&nbsp;
				<input maxlength="3" size="2" id="whichPage" />
				<input type="button" value="Go" onclick="findPage2();">
			</div>
		</div>
		<div class="div3"><%@include file="../../main/div4.html"%></div>
	</body>
</html>
