<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" import="java.util.*,java.io.*,java.sql.*,ITAD.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title></title>
<script src="./js/Rollover.js"></script>
<script language=Javascript>
window.onload = function()
{
	<%
		User usr = new User(); String url;
		session.setMaxInactiveInterval(60*30);
		if(usr.Matching_IDPW(request.getParameter("ID"), request.getParameter("Password")))
		{
			session.setAttribute("LoginStatus", 1);
			session.setAttribute("LoginedUser", usr.getIdx());

			url="Contents/PCList.jsp";
			session.setAttribute("LoginError", null); // Clear
			if(usr.getPermission() == 2) url="Contents/PCList.jsp";
		}
		else
		{
			url="Login.jsp";
			session.setAttribute("LoginError", usr.getMessage());  
		}
		usr.Disconnect();
	%>
	document.Check.condev.value = check_device();
	document.Check.submit();
}
</script>
</head>
<body>

<form name=Check action=<%= url %> method=post>
<input type="hidden" name="condev">
</form>
</body>
</html>