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
	int nowPageparlimit = Integer.parseInt(session.getAttribute("nowPageparlimit")
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
<script type="text/javascript" src="javascript/addLoadEvent.js"></script>
<script type="text/javascript" src="javascript/jquery-1.4.3.js"></script>
<script type="text/javascript" src="javascript/lexique/reparlist.js"></script>
<script type="text/javascript">
function go(){
	var pages=document.getElementById("go").value;
	if(pages.toString().length==0||isNaN(pages)){
		document.getElementById("go").value=""; 	
		alert('variable invalide!');
		return;
	}
	relistparlimit(pages);
}
</script>
</head>
<body>
	<h1 style="text-align: left">
		<a href='lexique/lexiquemain.xiu'>Page Précédent</a>
	</h1>
	<h1>
		ICI PAGE <span style="color:red" id="nowPageparlimit"> <%=nowPageparlimit%> </span> /  <span style="color:red"> ${ maxPage }</span>&nbsp;total
	</h1>
	<h2> les vocabulaires totals <span style="color:red"> ${ totalnotes }</span></h2>
<hr width="100%" size="1" align="center" color="gray" />
	<div style="text-align: left">
	mot:<input name="mot" id="mot" maxlength="50"  style="width: 150px" onfocus="cleanmot();" value="${mot}"/>
	déclinaison：<select name="declinaison" id="declinaison">
							<option value="${declinaison}">${declinaison}</option>
							<option value="adj">adj</option>
							<option value="adv">adv</option>
							<option value="v">v</option>
							<option value="n.m">n.m</option>
							<option value="n.f">n.f</option>
							<option value="prep">prép</option>
							<option value="pron">pron</option>
							<option value="conj">conj</option>
							<option value=""></option>
					</select>
	date:<select name="aaaa" id="aaaa"><option value="${aaaa}">${aaaa}</option><option value="2015">2015</option><option value="2016">2016</option>
	<option value="2017">2017</option><option value="2018">2018</option><option value=""></option>
	</select>
	<select name="mm" id="mm"><option value="${mm}">${mm}</option><option value="01">01</option><option value="02">02</option><option value="03">03</option>
	<option value="4">04</option><option value="05">05</option><option value="06">06</option><option value="07">07</option><option value="08">08</option>
	<option value="9">09</option><option value="10">10</option><option value="11">11</option><option value="12">12</option><option value=""></option>
	</select>
	<select name="jj" id="jj"><option value="${jj}">${jj}</option><option value="1">01</option><option value="2">02</option><option value="3">03</option>
	<option value="4">04</option><option value="5">05</option><option value="6">06</option><option value="7">07</option><option value="8">08</option>
	<option value="9">09</option><option value="10">10</option><option value="11">11</option><option value="12">12</option><option value="13">13</option>
	<option value="14">14</option><option value="15">15</option><option value="16">16</option><option value="17">17</option><option value="18">18</option>
	<option value="19">19</option><option value="20">20</option><option value="21">21</option><option value="22">22</option><option value="23">23</option>
	<option value="24">24</option><option value="25">25</option><option value="26">26</option><option value="27">27</option><option value="28">28</option>
	<option value="29">29</option><option value="30">30</option><option value="31">31</option><option value=""></option>
	</select>
	&nbsp;<a href="javascript:hier();"><span style="color:red">hier</span></a>  &nbsp;
	<input type="button" value=">>>" onclick="relistparlimit(1);"/>
	</div>
	<hr width="100%" size="1" align="center" color="gray" />
	<div style="text-align: right">
	<input type="button" value="+" onclick="doit(1);"/>
	&nbsp;&nbsp;
		<input type="button" value=" - " onclick="doit(2);"/>
	&nbsp;&nbsp;
	<input type="button" value="↑RESET↑" onclick="resettout();"/>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input id="go" maxlength="4" style="width: 30px">
	<input type="button" onclick="go();" value="go" />
	&nbsp;&nbsp;&nbsp;
	<a href="javascript:relistparlimit(1);"><span style="color:black;font-weight:bold;"> PAGE1&lt;&lt;&lt;&lt;</span></a>&nbsp;&nbsp;&nbsp;
	<a href="javascript:relistparlimit(-3);"> <span style="color:orange;font-weight:bold;">&lt;&lt;précédent</span> </a>&nbsp;&nbsp;&nbsp;
	<a href="javascript:relistparlimit(-2);"> <span style="color:orange;font-weight:bold;">suivant&gt;&gt; </span></a>&nbsp;&nbsp;&nbsp;
	<a href="javascript:relistparlimit(-1);"><span style="color:black;font-weight:bold;"> &gt;&gt;&gt;&gt;LAST1</span></a>&nbsp;&nbsp;&nbsp;
	</div>
	<hr width="100%" size="1" align="center" color="gray" />
	<div style="text-align: left; width: 98%">
		<c:forEach var="n" items="${lexiques}" varStatus="s">
			<ul>
				<li>
				<div>
				<div style="text-align: left;">  <span style="color:red; font-weight:bold;font-size:30px "> ${n.mot}  </span>
				 &nbsp;<span style="color:blue;font-weight:bold;"> ${n.declinaison}. </span>
				&nbsp;&nbsp;<span style="color:black;font-weight:bold; "> ${n.sensch}</span>
                &nbsp;&nbsp;${n.sensfr}</div>
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
	<a href="javascript:relistparlimit(1);"><span style="color:black;font-weight:bold;"> PAGE1&lt;&lt;&lt;&lt;</span></a>&nbsp;&nbsp;&nbsp;
	<a href="javascript:relistparlimit(-3);"> <span style="color:orange;font-weight:bold;">&lt;&lt;précédent</span> </a>&nbsp;&nbsp;&nbsp;
	<a href="javascript:relistparlimit(-2);"> <span style="color:orange;font-weight:bold;">suivant&gt;&gt; </span></a>&nbsp;&nbsp;&nbsp;
	<a href="javascript:relistparlimit(-1);"><span style="color:black;font-weight:bold;"> &gt;&gt;&gt;&gt;LAST1</span></a>&nbsp;&nbsp;&nbsp;
	</div>
	<hr width="100%" size="1" align="center" color="gray" />
</body>