<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8" import="java.util.*,java.io.*,java.sql.*,ITAD.*,ITAD.DataStructure.*,java.text.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<jsp:useBean id="user" class="ITAD.User"/> <jsp:setProperty property="*" name="user" />
<% user.UpdateUSERdata(user.getIdx()); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>

<script>window.onload = function(){ document.editform.submit() }</script>

<form name="editform" action="UserEdit.jsp" method="post" >
<input type="hidden" name="SelectValue" value="${user.idx}">
</form>


</body>
</html>
