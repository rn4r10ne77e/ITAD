<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8" import="java.util.*,java.io.*,java.sql.*,ITAD.*,ITAD.DataStructure.*,java.text.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!--  DDC 데스크탑 로그인 -->


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> 
<title></title>
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=Edge; text/html;">
</head>

<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/CSS/newBasic.css" >

<body>

<form name=LoginForm method=post action=Login_OK.jsp >

<table style="height:100%; width:100%; border-spacing:0; padding:0;" border=1>
	<tr>
		<td></td>
		<td style="width:300px"align=right valign=middle>
			<table class="loginwindow">
				<tr>
					<td><img src="/ITAD/images/loginbg.gif"></td>
				</tr>
				<tr>
					<td align=right>
						아이디 :   <input type="text" name="ID" style="width:100px" style="border-radius:5px;"><br>
					    패스워드 : <input type="password" name="Password" style="width:100px"><br><br>
								   <input type="submit" value="로그인"><br><br>
					</td>
				</tr>
				<tr>
					<td align=left>
						<p align=center><a href="app-debug.apk">안드로이드 앱 다운로드</a></p>
						<p align=right style="text-color:red"><%= (session.getAttribute("LoginError") != null)?session.getAttribute("LoginError"):" " %></p>
					</td>
				</tr>
			</table>
		</td>
		<td></td>
	</tr>
</table>

</form>


</body>
</html>