<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*,java.io.*,java.sql.*,ITAD.*,ITAD.DataStructure.*,java.text.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

	
		<table class="infobox" width="135">
		<tr>
		<td align=left width="120">

		&nbsp;&nbsp;&nbsp; 자산 메뉴 <br><br>
		&nbsp;&nbsp;&nbsp;<a style="cursor:pointer;" onclick="Move(this,'Enrollment.jsp')">자산 추가</a><br><br>
		&nbsp;&nbsp;&nbsp;<a style="cursor:pointer;" onclick="Move(this,'PCList.jsp?initialize=1')">자산 조회</a><br>
		</td>
		</tr>
		</table><br>
		
		<table class="infobox" width="135">
		<tr>
		<td align=left width="120">

		&nbsp;&nbsp;&nbsp; 레포트 메뉴 <br><br>
		&nbsp;&nbsp;&nbsp;<a style="cursor:pointer;" onclick="Move(this,'Report.jsp')">자산 폐기</a><br><br>
		
		</td>
		</tr>
		</table><br>

		<table class="infobox" width="135">
		<tr>
		<td align=left width="120">
		&nbsp;&nbsp;&nbsp; 사용자 메뉴 <br><br>
		&nbsp;&nbsp;&nbsp;<a style="cursor:pointer;" onclick="Move(this,'UserList.jsp')">추가 및 조회</a><br>
		</td>
		</tr>
		</table><br>
		 
	
		<!-- <a style="cursor:pointer;" onclick="Move(this,'Setup.jsp')"> 설정 </a><br><br>  -->
	