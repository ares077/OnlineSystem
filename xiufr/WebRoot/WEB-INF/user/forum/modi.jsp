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
  <script type="text/javascript" src="javascript/addLoadEvent.js"></script>
<script type="text/javascript" src="javascript/jquery-1.4.3.js"></script>
<script type="text/javascript" src="javascript/forum/addf.js"></script>
		<link rel="stylesheet" href="css/global.css" type="text/css"></link>
		<link rel="stylesheet" href="css/user/user.css" type="text/css"></link>
  </head>
  
  <body>
      <h1><a href='forum/forummain.xiu'>PagePrécédent </a></h1>
      <form action="" method="post" id="form1">
		<fieldset>
			<legend>
				<span style="font-size: 30">ajouter un post</span>
			</legend>
			<table align="center" cellpadding="5" cellspacing="0" border="2">
				<tr>
						<td colspan="3">title: <input value="${forum.title}" onfocus="effacer()" name="title" id="title" maxlength="50" style="width: 500px;text-align:left"/></td>
				</tr>
				<tr>		
				 <td> category：<select name="category" id="category">
							<option value="${forum.category}">${forum.category}</option>
							<c:forEach var="n" items="${categorylists}">
	                        <option value="${n}">${n}</option>        
	                        </c:forEach>
					</select>
					</td>
						<td ><input style="color: grey ;text-align:center" readonly="readonly" 
						name="author" id="author" value="${forum.author}"/></td>
						<td ><input style="color: grey;text-align:center" readonly="readonly"
						name="jour" id="jour" value="${forum.jour}"  /></td>	
				</tr>
				<tr>
	              <td colspan="3"> content:<br></br>
	              <textarea rows="20" cols="100" name="content" id="content" >${forum.content}</textarea>
	              </td>
				</tr>
				<tr>
					<td colspan="3">lien: <input  value="${forum.lien}"  name="lien" id="lien" maxlength="50" style="width: 500px;text-align:left"/></td>
				</tr>
				<tr>
				<td><input type="button" onclick="delete();"
						value="DELETE" /></td>
					<td><input type="hidden" id="postsid" value="${forum.postsid }" /></td>
					<td colspan="2"><input type="button" onclick="form2();"
						value="MODIFIER" /></td>
				</tr>
			</table>
       </fieldset>
       </form>
  </body>
</html>
