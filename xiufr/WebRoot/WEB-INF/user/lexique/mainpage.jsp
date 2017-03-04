<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>">
<title>bienvenu sur mon site web</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
 <link rel="stylesheet" href="css/global.css" type="text/css"></link>
</head>
<body>
<br/><br/>
<h1><a href='login/stuindex.xiu'>HomePage </a></h1>
<hr width="100%" size="1" align="center" color="gray" />
<br/><br/>
<h1><a href='lexique/addpage.xiu'>ajouter un nouveau mot</a></h1>
<br/><br/>
<h1><a href='motre/relist.xiu'>reviser tous les mots</a></h1>
<br/><br/>
<h1><a href='motre/relistparlimit.xiu'>chercher les mots par limitation</a></h1>
<br/><br/>
<hr width="100%" size="1" align="center" color="gray" />
<div style="text-align: left">
<a href="<%=basePath%>texte/20151229.html" target="_blank">20151229</a>
</div>
</body>
</html>