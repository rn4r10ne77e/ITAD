<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*,java.io.*,java.sql.*,ITAD.*,ITAD.DataStructure.*,TestPack.*,java.text.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	String receivedDevice = request.getParameter("connDev");
	String Array[]={"iPhone", "iPod", "BlackBerry", "Android", "Windows CE", "LG", "MOT", "SAMSUNG", "SonyEricsson"}, mode="PC";

	if( receivedDevice != null )
		for( String idx : Array )
			if( idx.equals(receivedDevice) )	mode = "Mobile";
%>

<!DOCTYPE html>
<head>
	<title>KAMS DBschenker Korea Asset Management Program</title>
	
	<meta http-equiv="X-UA-Compatible" content="IE=9; IE=Edge; text/html;">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no" />
	
	<c:set var="mode" value="<%=mode%>"/>
	<c:set var="root" value="${pageContext.request.contextPath}" scope="session" />
	
	<link rel="stylesheet" type="text/css" href="${root}/CSS/base.css" />
	<link rel="stylesheet" type="text/css" href="${root}/CSS/${mode}/toppage.css" />
	
	<script src="${root}/js/toppage.js"></script>

</head>
<body>

<div id="pop" ></div>

<form name="main" onsubmit="return false;" method="post" >

<table id="page_container">
	<tr>
		<td id="left_blank_area" rowspan=2></td>
		<td id="contents_area">
			<table id="content">
				<tr>
					<td class="logo_field" colspan=2 >
					<div id="head_bar">
						<img id="menu_icon" src="${root}/images/menu_icon.png" >
						<img class="logo_img" src="${root}/images/logo.png" >
					</div>
					</td>
				</tr>
				<tr>
					<td class="toptitle_field" colspan=2>
						<span class="toptitle_font">Schenker Korea Asset Management System</span><br>
						<p align=right style="color:white">안녕하세요 <sapn id="login_id"></sapn>님, 로그인 되었습니다.</p>
						<p align=right style="color:white"><input type=button value="로그아웃" onclick="Logout('../Login.jsp')" ></p>
					</td>
				</tr>
				<tr>
				<td id="content_left"><br>
					<%@ include file="left.jsp" %>
					
					</td>
					<td valign=top height="100%" ><br>