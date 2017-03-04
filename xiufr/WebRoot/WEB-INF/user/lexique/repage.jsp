<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<script type="text/javascript">
function go(){
	var pages=document.getElementById("go").value;
	if(pages.toString().length==0||isNaN(pages)){
		document.getElementById("go").value=""; 	
		alert('variable invalide!');
		return;
	}
	var uri='motre/relist.xiu?nowPage='+pages;
	location.href=uri;
}
</script>
</head>
<body>
	<h1 style="text-align: left">
		<a href='lexique/lexiquemain.xiu'>Page Précédent</a>
	</h1>
	<h1>
		ICI PAGE <span style="color:red"> <%=nowPage%></span> /  <span style="color:red"> ${ maxPage }</span>&nbsp;total
	</h1>
	<h2> les vocabulaires totals <span style="color:red"> ${ totalnotes }</span></h2>
<hr width="100%" size="1" align="center" color="gray" />
	<div style="text-align: right">
	<input id="go" maxlength="4" style="width: 30px">
	<input type="button" onclick="go();" value="go" />
	&nbsp;&nbsp;&nbsp;
	<a href="motre/relist.xiu?nowPage=1"><span style="color:black;font-weight:bold;"> PAGE1&lt;&lt;&lt;&lt;</span></a>&nbsp;&nbsp;&nbsp;
	<a href="motre/relist.xiu?nowPage=<%=nowPage - 1%>"> <span style="color:orange;font-weight:bold;">&lt;&lt;précédent</span> </a>&nbsp;&nbsp;&nbsp;
	<a href="motre/relist.xiu?nowPage=<%=nowPage + 1%>"> <span style="color:orange;font-weight:bold;">suivant&gt;&gt; </span></a>&nbsp;&nbsp;&nbsp;
	<a href="motre/relist.xiu?nowPage=<%=Integer.MAX_VALUE%>"><span style="color:black;font-weight:bold;"> &gt;&gt;&gt;&gt;LAST1</span></a>&nbsp;&nbsp;&nbsp;
	</div>
	<hr width="100%" size="1" align="center" color="gray" />
	<div style="text-align: left; width: 98%">
		<c:forEach var="n" items="${lexiques}" varStatus="s">
			<ul>
				<li>
				<div>
				<div style="text-align: left;">  <span style="color:red; font-weight:bold;font-size:30px "> ${n.mot}&nbsp;---&nbsp;${n.sensfr}</span>
				 &nbsp;<span style="color:blue;font-weight:bold;"> ${n.declinaison}. </span>
				&nbsp;&nbsp;<span style="color:black;font-weight:bold; "> ${n.sensch}</span>
                &nbsp;&nbsp;</div>
				<div style="text-align: right; color:grey; ">${n.jour}</div>
				</div>
					<ul>
					<c:if test="${n.locution1!=''}">
						<li><span style="color:blue;"> ${n.locution1} </span></li>
					</c:if>
					<c:if test="${n.locution2!=''}">
						<li><span style="color:blue;"> ${n.locution2} </span></li>
					</c:if>
					<c:if test="${n.locution3!=''}">
						<li><span style="color:blue;"> ${n.locution3} </span></li>
					</c:if>
					<c:if test="${n.phrase1!=''}">
						<li><span style="color:blue;"> ${n.phrase1} </span></li>
					</c:if>
					<c:if test="${n.phrase2!=''}">
						<li><span style="color:blue;"> ${n.phrase2} </span></li>
					</c:if>
					<c:if test="${n.phrase3!=''}">
						<li><span style="color:blue;"> ${n.phrase3} </span></li>
					</c:if>
						
					</ul>
				</li>
			</ul>
			<div style="text-align: right"><a href="lexique/modipage.xiu?lexid=${n.lexiqueid }"><span style="color:orange;;font-weight:bold;"> MODIFIER </span></a></div>
			<hr width="100%" size="1" align="center" color="gray" />
		</c:forEach>
	</div>
	<div style="text-align: right">
	<input id="go" maxlength="4" style="width: 30px">
	<input type="button" onclick="go();" value="go" />
	&nbsp;&nbsp;&nbsp;
	<a href="motre/relist.xiu?nowPage=1"><span style="color:black;font-weight:bold;"> PAGE1&lt;&lt;&lt;&lt;</span></a>&nbsp;&nbsp;&nbsp;
	<a href="motre/relist.xiu?nowPage=<%=nowPage - 1%>"> <span style="color:orange;font-weight:bold;">&lt;&lt;précédent</span> </a>&nbsp;&nbsp;&nbsp;
	<a href="motre/relist.xiu?nowPage=<%=nowPage + 1%>"> <span style="color:orange;font-weight:bold;">suivant&gt;&gt; </span></a>&nbsp;&nbsp;&nbsp;
	<a href="motre/relist.xiu?nowPage=<%=Integer.MAX_VALUE%>"><span style="color:black;font-weight:bold;"> &gt;&gt;&gt;&gt;LAST1</span></a>&nbsp;&nbsp;&nbsp;
	</div>
	<hr width="100%" size="1" align="center" color="gray" />
</body>