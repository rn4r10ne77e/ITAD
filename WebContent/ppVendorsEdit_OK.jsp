<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8" import="java.util.*,java.io.*,java.sql.*,MyPack.*,MyPack.DataStructure.*,java.text.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	Vendor vnd = new Vendor();

	vnd.setIdx(Integer.parseInt(request.getParameter("idx")));
	
	vnd.setCorpno(request.getParameter("corpno"));
	vnd.setDescr(request.getParameter("descr"));
	vnd.setManager(request.getParameter("manager"));

	if( vnd.update() ) out.print("success");
	else out.print("fail.");
%>