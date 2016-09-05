<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*,java.io.*,java.sql.*,ITAD.*,ITAD.DataStructure.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<% 
	session.setAttribute("UserListCurrentPage", request.getParameter("selectpage"));
	session.setAttribute("UserListSearchColumn", request.getParameter("searchcolumn"));
	session.setAttribute("UserListSearchKeyword", request.getParameter("searchkeyword"));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="fonts.css" charset="UTF-8" >
<script language="javascript">
window.onload=function()
{
	document.go.submit();
}
</script>
</head>
<body>
<form name=go action="UserList.jsp" method=post></form>

</body>
</html>
