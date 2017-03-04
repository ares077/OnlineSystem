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
		<script type="text/javascript" src="javascript/exam/exam.js">
</script>

<script type="text/javascript">
  // 禁止右键
        $(document).bind("contextmenu", function(){return  false;});
        // 禁止选择
        $(document).bind("selectstart", function(){return  false;});

        // 禁止Ctrl+C 和Ctrl+A
        $(document).keydown(function(event) {
            if ((event.ctrlKey&&event.which==67) || (event.ctrlKey&&event.which==86)){
                return false;
            }
        });
       // $(document.body).bind("onbeforeunload",function(){window.event.returnValue="shsiaodas";});
</script>
	<script type="text/javascript" src="javascript/exam/time.js"></script>
	</head>

	<body>
	<div style="width: 100;height: 50;border: 1 solid red;position: fixed;top:10%;left:80%;">
	Il reste <br/>
	<span style="color: red" id="mi">120</span>mins
	<span style="color: red" id="se">00</span>secs
	
	</div>
		<div style="text-align: left; margin-left: 20">
			<form action="finish/cs.xiu" method="post" id="form1">
				<input type="hidden" value="${studentid }" name="studentid" />
				<input type="hidden" value="${paperid }" name="paperid" />
				<h1>
					|Cochez la bonne réponse
				</h1>
				<br />
				<c:forEach var="q" items="${questionsSin}" varStatus="sq">
					<input type="hidden" name="sinqid${sq.index +1}"
						value="${q.questionid}" />
					<input type="hidden" name="sinqle${sq.index +1}" value="${q.level}" />
					<span style="color: blue">${sq.index +1} .
						&nbsp;${q.description }</span>
					<br />
					<input type="radio" name="s${sq.index +1}" value="A" />${q.a }
    	<br />
					<input type="radio" name="s${sq.index +1}" value="B" />${q.b }
    	<br />
					<input type="radio" name="s${sq.index +1}" value="C" />${q.c }
    	<br />
					<input type="radio" name="s${sq.index +1}" value="D" />${q.d }
    	<br />
					<c:if test="${q.e!=''}">
						<input type="radio" name="s${sq.index +1}" value="E" />${q.e }
    	<br />
					</c:if>
					<c:if test="${q.f!=''}">
						<input type="radio" name="s${sq.index +1}" value="F" />${q.f }
    	<br />
					</c:if>

					<br />
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
					<span style="color: blue">${sqs.index +1} .
						&nbsp;${ques.description }</span>
					<br />
					<input type="checkbox" name="m${sqs.index +1}" value="A" />${ques.a }
    	<br />
					<input type="checkbox" name="m${sqs.index +1}" value="B" />${ques.b }
    	<br />
					<input type="checkbox" name="m${sqs.index +1}" value="C" />${ques.c }
    	<br />
					<input type="checkbox" name="m${sqs.index +1}" value="D" />${ques.d }
    		<br />
					<c:if test="${q.e!=''}">
						<input type="checkbox" name="s${sqs.index +1}" value="E" />${ques.e }
    	<br />
					</c:if>
					<c:if test="${q.f!=''}">
						<input type="checkbox" name="s${sqs.index +1}" value="F" />${ques.f }
    	<br />
					</c:if>
					<br />
				</c:forEach>
				<div style="text-align: center">
					<input type="button" onclick="Subm();" value="quitter le test">
				</div>
			</form>
		</div>
	</body>
</html>
