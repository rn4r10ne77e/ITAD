<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8" import="java.util.*,java.io.*,java.sql.*,MyPack.*,MyPack.DataStructure.*,java.text.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%
	Vendor vnd = new Vendor();
	vnd.load(Integer.parseInt(request.getParameter("IDX")));
%>

<c:set value="<%=vnd%>" var="vnd" scope="page" />

<table>
<tr><td colspan=2 align=center>거래처 수정</td></tr>
<tr><td colspan=2> 거래처 정보를 수정 할 수 있습니다.</td></tr>
<tr><td colspan=2><input type=hidden name="vidx" id="vidx" value="${vnd.idx}"></td></tr>
<tr><th align=right>상 호 : </th><td><input type=text name="descr" id="descr" value="${vnd.descr}"></td></tr>
<tr><th align=right>사업자 번호 : </th><td><input type=text name="corpno" id="corpno" value="${vnd.corpno}"></td></tr>
<tr><th align=right>담당자 : </th><td><input type=text name="manager" id="manager" value="${vnd.manager}"></td></tr>
<tr><td colspan=2 align=right><input type=button value="수정" onclick="VendorEdit()"></td></tr>
</table>
