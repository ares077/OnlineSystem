<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	//Session验证
	Object adminid = session.getAttribute("adminid");
	if (adminid == null) {
		response.sendRedirect("login.jsp");
		return;
	}
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
	<script type="text/javascript">
	var vari=100;
	function interpreter(){
		var b1=document.getElementById("b1");
		var b2=document.getElementById("b2");
		var b3=document.getElementById("b3");
		if(vari%2==0){
			b1.innerHTML="您好";
			if(b2.innerHTML.length==8)b2.innerHTML='丹鹤';
			b3.innerHTML="欢迎您!";
		}
		if(vari%2==1){
			b1.innerHTML="Bonjour!";
			if(b2.innerHTML.length==2)b2.innerHTML='xiaojin ';
			b3.innerHTML="Soyez la bienvenue!";
		}
		vari+=1;
	}
	</script>
	</head>
	<body>
		<div class="div1"><%@include file="../main/div1.html" %></div>
		
		<div class="div5">
		<div class="div2"><%@include file="../main/div2.html" %></div>
		<div class="div3">
		<div class="tdiv">
		<a href="javascript:interpreter();" style="font-size: 50" title="点我可以翻译">
		<span id="b1">Bonjour！ </span>
		<span style="color: red" id="b2"><%=adminid.toString()%> </span> 
		 <span id="b3">Soyez la bienvenue! </span>
		</a>
		<br/><br/>
		<p>^</p>
		<p>|</p>
		<p>|</p>
		<p>|</p>
		<p>点击可翻译</p>
		</div>
		</div>
		</div>
		
		<div class="div4"><%@include file="../main/div4.html" %></div>
	</body>
</html>
