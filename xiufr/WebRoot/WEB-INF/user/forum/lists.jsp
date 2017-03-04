<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>XiangLi在线考试系统的forum</title>
   
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
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
  <script type="text/javascript" src="javascript/addLoadEvent.js"></script>
<script type="text/javascript" src="javascript/jquery-1.4.3.js"></script>
<script type="text/javascript" src="javascript/forum/tout.js"></script>
		<link rel="stylesheet" href="css/global.css" type="text/css"></link>
		<link rel="stylesheet" href="css/user/user.css" type="text/css"></link>
		<link rel="stylesheet" href="css/user/questionlists.css"
			type="text/css"></link>
  </head>
  
  <body>
  <h1><a href='main/online.xiu'>HomePage </a></h1>
    <h1>
		ICI PAGE <span style="color:red" id="nowPageforum"> ${nowPageforum} </span>  /  <span style="color:red"> ${ maxPage }</span>&nbsp;total
	</h1>
	<h2> les posts totals <span style="color:red"> ${ totalnotes }</span></h2>
<hr width="100%" size="1" align="center" color="gray" />
	<div style="text-align: left">
	title:<input name="title" id="title" maxlength="100" value="${title}" style="width: 350px" onfocus="cleantitle();"/>
	category：<select name="category" id="category">
							<option value="${category}">${category}</option>
							<c:forEach var="n" items="${categorylists}">
	                        <option value="${n}">${n}</option>        
	                        </c:forEach>
	                         <option></option>
					</select>
	author:<input name="author" id="author" maxlength="20" value="${author}" style="width: 150px" onfocus="cleanauthor();"/>
	<input type="button" value=">>>" onclick="relistparlimit(1);"/>
	&nbsp;&nbsp;&nbsp;
	<input type="button" value="RESET" onclick="resettout();"/>
	</div>
	<hr width="100%" size="1" align="center" color="gray" />
	<div style="text-align: right">
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
		<div class="tablediv">
				<table class="table1" border="1" style="height:15px">
			
					<tr class="tr1" style="color:yellow;" >
						<td width="55%">
							TITLE
						</td>
						<td width="10%">
							CATEGORY
						</td>
						<td width="10%">
							DATE
						</td>
						<td width="15%">
							AUTHOR
						</td>
						<td width="10%">
							?
						</td>
					</tr>
					</table>
					<table class="table1" border="1">
					  <c:if test="${posts == null}">
					  	 <br></br>
					 	 <br></br>
					  <h1 style="text-align:center;color:red">Il y a aucun résultat !</h1>
					  	 <br></br>
					  </c:if>
					<c:forEach var="n" items="${posts}" varStatus="s">
						<tr class="row${s.index%2+1}" >
							<td width="55%" >
							<c:if test="${n.content == null || n.content == ''}">
										<a style="text-decoration:underline; font-size:30px;" href='forum/${n.category }/${n.lien }' target="_blank" >${n.title}</a>
							</c:if>
							<c:if test="${n.content != null && n.content != ''}">
										<a style="text-decoration:none;font-size:30px;" href='forum/post.xiu?postsid=${n.postsid }' >${n.title}</a>
							</c:if>
				
							</td>
							<td width="10%">
								${n.category}
							</td>
							<td width="10%">
								${n.jour}
							</td>
							<td width="15%">
								${n.author}
							</td>
							<td width="10%">
								<a href="forum/modipage.xiu?postsid=${n.postsid }">MODIFIER</a>
							</td>
						</tr>
					</c:forEach>
				</table>
		</div>
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
</html>