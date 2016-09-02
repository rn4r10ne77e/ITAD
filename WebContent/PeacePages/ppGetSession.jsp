<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*,java.io.*,java.sql.*,ITAD.*,ITAD.DataStructure.*,java.text.*" %>
<%
	User LoginedUser = new User();

	String pagename = request.getServletPath().toString().replace("/", "");
	
	if( session.getAttribute("LoginedUser") != null )
	{
		int idx = Integer.parseInt(session.getAttribute("LoginedUser").toString());
		LoginedUser.LoadUserData(idx);
		out.print(LoginedUser.getName());
	}
	else 
	
	
%>
