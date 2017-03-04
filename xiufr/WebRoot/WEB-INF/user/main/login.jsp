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
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link href="images/Default.css" type=text/css rel=stylesheet>
<link href="images/xtree.css" type=text/css rel=stylesheet>
<link href="images/User_Login.css" type=text/css rel=stylesheet>
<script type="text/javascript" src="javascript/jquery-1.4.3.js"></script>
<script type="text/javascript" src="javascript/login/login.js"></script>



</head>

<body id=userlogin_body>
	<FORM action="http://localhost:8080/xiu/login/login.xiu" method="post" id="form1">
		<DIV id=user_login>
			<DL>
				<DD id=user_top>
					<UL>
						<LI class=user_top_l></LI>
						<LI class=user_top_c></LI>
						<LI class=user_top_r></LI>
					</UL>
				
				<DD id=user_main>
				
					<UL>
						
						<LI class=user_main_l></LI>
						<LI class=user_main_c>
							<DIV class=user_main_box>
						
							
								<UL>
									<LI class=user_main_text>用户名：</LI>
									<LI class=user_main_input><INPUT class=TxtUserNameCssClass
										id=TxtUserName maxLength=20 name=adminid value="${adminid}"></LI>
								</UL>
								<UL>
									<LI class=user_main_text>密 码：</LI>
									<LI class=user_main_input><INPUT class=TxtPasswordCssClass
										id=TxtPassword type=password name=adminpw></LI>
								</UL>
								<UL>
									<LI class=user_main_text>验证码：</LI>
									<LI class=user_main_input><input name="vcode" id="vcode"
										maxlength="4" size="5" onblur="checkCode();" /></LI>
									<LI><img src="login/createImage.xiu" alt="验证码"
										title="点击更换" onclick="change(this);"></LI>
										<LI id="vcode_msg"></LI>

								</UL>
								<UL>
									<LI><a href="http://localhost:8080/xiangli2"
										style="color: red">管理员登录</a>
									</LI>
									<LI><input type="radio" name="statu" checked="checked"
										value="1" id="radio2" /> <a href="javascript:changeState2();">学生</a>
									</LI>
									<LI><input type="radio" name="statu" value="3" id="radio3" />
										<a href="javascript:changeState3();">游客</a></LI>
										<LI id="login_msg" style="color: red">${login_msg}${vcode_msg}</LI>
								</UL>
                   
							</DIV>
						</LI>
						<LI class=user_main_r><INPUT class=IbtnEnterCssClass
							id=IbtnEnter
							style="BORDER-TOP-WIDTH: 0px; BORDER-LEFT-WIDTH: 0px; BORDER-BOTTOM-WIDTH: 0px; BORDER-RIGHT-WIDTH: 0px"
							type="image" src="images/user_botton.gif"  onclick="subm()"></LI>
					
					</UL>
					
				<DD id=user_bottom>
	
					<UL>
						<LI class=user_bottom_l></LI>
						<LI class=user_bottom_c><p style="MARGIN-TOP: 40px">&copy;七先生所有！All
								Right Reserved,2014~2015</p></LI>
						<LI class=user_bottom_r></LI>
					</UL>
				</DD>
			</DL>
		</DIV>
		<SPAN id=ValrUserName style="DISPLAY: none; COLOR: red"></SPAN> <SPAN
			id=ValrPassword style="DISPLAY: none; COLOR: red"></SPAN> <SPAN
			id=ValrValidateCode style="DISPLAY: none; COLOR: red"></SPAN>
		<DIV id=ValidationSummary1 style="DISPLAY: none; COLOR: red"></DIV>
	</FORM>
</body>
</html>
