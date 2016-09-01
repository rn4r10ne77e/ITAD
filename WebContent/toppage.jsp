<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*,java.io.*,java.sql.*,ITAD.*,ITAD.DataStructure.*,java.text.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=Edge; text/html;">

<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/CSS/newBasic.css" />
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/CSS/TableHeader.css" />
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/CSS/PopupLayer.css" />

<script src="<%= request.getContextPath() %>/js/Rollover.js"></script>
<script src="<%= request.getContextPath() %>/js/MoveTo.js"></script>
<script>
<%
	User LoginedUser = new User();

	String pagename = request.getServletPath().toString().replace("/", "");
	
	if( session.getAttribute("LoginedUser") != null )
	{
		int idx = Integer.parseInt(session.getAttribute("LoginedUser").toString());
		LoginedUser.LoadUserData(idx);
	}
	if( session.getAttribute("LoginStatus") == null )
		out.print("alert('세션이 만료되었거나 잘못된 접근 입니다. \\n로그인 페이지로 이동 합니다.');location.href='"+request.getContextPath()+"/Login.jsp';"); 
%>
</script>
<c:set value="<%= LoginedUser %>" var="LoginedUser" scope="page" />

</head>
<body style="overflow:scroll" >

<!------------------------------ 추가 된 부분 --------------------------------------->
<div id="pop" > 빈레이어 </div>
<form name="main" onsubmit="return false;" method=post>

<table style="height:100%; width:100%; border-spacing:0; padding:0;">
	<tr>
		<td rowspan=2></td>
		<td style="width:1024px; border:1px solid black; border-left: 1px solid; border-right: 1px solid; border-top: 1px solid; border-bottom: 0px none" valign=top>
			<table style="width:1024px; border-spacing:0; padding:0;">
				<tr>
					<td colspan=2 align=center height="10" bgcolor="#ffffff">
						<img src="/ITAD/images/logo.png" align=right>
					</td>
				</tr>
				<tr>
					<td class="toptitle" colspan=2 valign="bottom" height=10>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						 <span style="font-size:16pt; color:white; font-family:Arial; font-weight:bold;">Schenker Korea Asset Management System</span>
						<p align=right style="color:white">안녕하세요, ${LoginedUser.name} 님이 로그인 되었습니다.</p>
						<p align=right style="color:white"><input type=button value="로그아웃" onclick="Logout()" ></p>
					</td>
				</tr>
				<tr>
				
					<%@ include file="left.jsp" %>
					
					
					<td valign=top height="100%" ><br>