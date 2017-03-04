<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

		<script type="text/javascript" src="javascript/jquery-1.4.3.js">
</script>
		<script type="text/javascript" src="javascript/addLoadEvent.js">
</script>
	<script type="text/javascript" src="javascript/note/cuoti.js"></script>
	</head>

	<body>
		<div style="text-align: left; margin-left: 20">
			<h1>
				|Cochez la bonne réponse
			</h1>
			<br />
			<c:forEach var="q" items="${questionsSin}" varStatus="sq">
				<input type="hidden" name="sinqid${sq.index +1}"
					value="${q.questionid}" />
				<input type="hidden" name="sinqle${sq.index +1}" value="${q.level}" />
				<input type="hidden" id="sans${sq.index +1}" value="${q.answer }" />
				<span style="color: blue">${sq.index +1} .
					&nbsp;${q.description }</span>
				<br />
				<input type="radio" name="s${sq.index +1}" value="A" disabled="disabled" /><span>${q.a }</span>
    	<br />
				<input type="radio" name="s${sq.index +1}" value="B" disabled="disabled" /><span>${q.b }</span>
    	<br />
				<input type="radio" name="s${sq.index +1}" value="C" disabled="disabled" /><span>${q.c }</span>
    	<br />
				<input type="radio" name="s${sq.index +1}" value="D"disabled="disabled"  /><span>${q.d }</span>
    	<br />
				<span style="color: red">${q.remark }</span>
				<br />
				<br />
			</c:forEach>
			<h1>
				||cochez les bonnes réponses
			</h1>
			<br />
			<c:forEach var="ques" items="${questionsMul}" varStatus="sqs">
				<input type="hidden" name="mulqid${sqs.index +1}"
					value="${ques.questionid}" />
				<input type="hidden" name="mulqle${sqs.index +1}"
					value="${ques.level}" />
				<input type="hidden" id="mans${sqs.index +1}" value="${ques.answer }" />
				<span style="color: blue">${sqs.index +1} .
					&nbsp;${ques.description }</span>
				<br />
				<input type="checkbox" name="m${sqs.index +1}" value="A" disabled="disabled" />${ques.a }
    	<br />
				<input type="checkbox" name="m${sqs.index +1}" value="B" disabled="disabled" />${ques.b }
    	<br />
				<input type="checkbox" name="m${sqs.index +1}" value="C" disabled="disabled" />${ques.c }
    	<br />
				<input type="checkbox" name="m${sqs.index +1}" value="D" disabled="disabled" />${ques.d }
    		<br />
				<input type="checkbox" name="m${sqs.index +1}" value="E" disabled="disabled"  />${ques.e }
    	<br />
				<input type="checkbox" name="m${sqs.index +1}" value="F" disabled="disabled" />${ques.f }
    	  	<br />
				<span Style="color: red">${ques.remark }</span>
				<br />
				<br />
			</c:forEach>
		</div>
		<div style="text-align: center"><input type="button" onclick="window.close();" value="fermer" /></div>
	</body>
</html>
