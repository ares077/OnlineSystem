<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	//Session验证
	Object studentid = session.getAttribute("studentid");
	if (studentid == null) {
		response.sendRedirect("tologin.xiu");
		return;
	}
	String mes = "";
	if (session.getAttribute("modi_msg") != null) {
		mes = session.getAttribute("modi_msg").toString();
		session.removeAttribute("modi_msg");
	}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>bienvenu sur mon site web</title>


<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<link rel="stylesheet" href="css/global.css" type="text/css"></link>
<link rel="stylesheet" href="css/user/loadstu.css" type="text/css"></link>
<script type="text/javascript" src="javascript/addLoadEvent.js"></script>
<script type="text/javascript" src="javascript/jquery-1.4.3.js"></script>
<script type="text/javascript" src="javascript/lexique/modimot.js"></script>
</head>

<body>
<h1><a href='motre/relist.xiu'>Retourner</a></h1>
<h1><a href='motre/relistparlimit.xiu'>Retourner à la chercher</a></h1>
	<form action="lexique/modimot.xiu" method="post" id="form1">
		<fieldset>
			<legend>
				<span style="font-size: 30">modifier un  mot</span>
			</legend>
			<table align="center" cellpadding="5" cellspacing="0" border="2">
				<tr>
					<td width="200"><span class="span2">mot：</span></td>
					<td><input name="mot" id="mot" maxlength="50"
						value="${lexique.mot }" onchange="isexist();" /></td>
					<td width="200"><span class="span2">déclinaison：</span></td>
					<td><select name="declinaison" id="declinaison">
							<option value="${lexique.declinaison }">${lexique.declinaison }</option>
							<option value="adj">adj</option>
							<option value="adv">adv</option>
							<option value="v">v</option>
							<option value="n.m">n.m</option>
							<option value="n.f">n.f</option>
							<option value="prep">prép</option>
							<option value="pron">pron</option>
							<option value="conj">conj</option>
					</select></td>
				</tr>
				<tr>
					<td><span class="span2">sens chinois：</span></td>
					<td colspan="3" style="text-align: left"><input name="sensch" value="${lexique.sensch }"
						id="sensch" maxlength="50" style="width: 500px" /></td>
				</tr>
				<tr>
					<td><span class="span2">sens français：</span></td>
					<td colspan="3" style="text-align: left"><input name="sensfr" value="${lexique.sensfr }"
						id="sensfr" maxlength="200" style="width: 500px" /></td>
				</tr>
				<tr>
					<td><span class="span2">locution1：</span></td>
					<td colspan="3" style="text-align: left"><input
						name="locution1" id="locution1" maxlength="100" value="${lexique.locution1 }"
						style="width: 500px" /></td>
				</tr>
				<tr>
					<td><span class="span2">locution2：</span></td>
					<td colspan="3" style="text-align: left"><input
						name="locution2" id="locution2" maxlength="100" value="${lexique.locution2 }"
						style="width: 500px" /></td>
				</tr>
				<tr>
					<td><span class="span2">locution3：</span></td>
					<td colspan="3" style="text-align: left"><input
						name="locution3" id="locution3" maxlength="100" value="${lexique.locution3 }"
						style="width: 500px" /></td>
				</tr>
				<tr>
					<td><span class="span2">phrase1：</span></td>
					<td colspan="3" style="text-align: left"><input name="phrase1" value="${lexique.phrase1 }"
						id="phrase1" maxlength="200" style="width: 500px" /></td>
				</tr>
				<tr>
					<td><span class="span2">phrase2：</span></td>
					<td colspan="3" style="text-align: left"><input name="phrase2" value="${lexique.phrase2 }"
						id="phrase2" maxlength="200" style="width: 500px" /></td>
				</tr>
				<tr>
					<td><span class="span2">phrase3：</span></td>
					<td colspan="3" style="text-align: left"><input name="phrase3" value="${lexique.phrase3 }"
						id="phrase3" maxlength="200" style="width: 500px" /></td>
				</tr>


				<tr>
					<td><span class="span1">jour：</span></td>
					<td><input style="color: grey" readonly="readonly"
						name="jour" id="jour" /></td>
					<td><span class="span1">user：</span></td>
					<td><input style="color: grey" readonly="readonly"
						name="user" id="user" value="<%=studentid%>" /></td>
				</tr>


				<tr>
				    <c:if test="${lexique.state == 1 }">
					<td>	<a	style="color: red" href="lexique/delete.xiu?lexiqueid=${lexique.lexiqueid}"
						onclick="return confirm ('souhaitez-vous de supprimer ${lexique.mot}?' );" >DELETE</a></td>
					</c:if>
					 <c:if test="${lexique.state == 0 }">
						<td>	<a	style="color: red" href="lexique/remettre.xiu?lexiqueid=${lexique.lexiqueid}"> remettre </a>
					</c:if>
					
					<td><span class="span3"><%=mes%></span><input type="hidden" name="lexiqueid" value="${lexique.lexiqueid }" />
					</td>
					<td colspan="2"><input type="button" onclick="form1();"
						value="MODIFIER" /></td>
				</tr>

			</table>
		</fieldset>
	</form>
</body>
</html>