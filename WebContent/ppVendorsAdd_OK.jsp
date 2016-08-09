<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8" import="java.util.*,java.io.*,java.sql.*,MyPack.*,MyPack.DataStructure.*,java.text.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%
	Vendor vnd = new Vendor();

	String descr = request.getParameter("descr");
	String corpno = request.getParameter("corpno");
	String manager = request.getParameter("manager");
	
	if( vnd.insert(descr, corpno, manager) != 0 ) out.print("success.");
	else out.print("fail.");

%>