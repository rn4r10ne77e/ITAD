<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*,java.io.*,java.sql.*,MyPack.*,MyPack.DataStructure.*,java.text.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%
	int parent = -1;
	String Table;
	
	parent = Integer.parseInt(request.getParameter("parent"));
	Table = request.getParameter("TableName");
	
	Dcode subcate = new Dcode("subcate");
	subcate.CodeLoad(Table, 2, parent);
%>

<c:set value="<%=subcate%>" var="subcate" scope="page" />
${subcate.TAGselect}
