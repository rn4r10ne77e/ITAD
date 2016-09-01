<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8" import="java.util.*,java.io.*,java.sql.*,ITAD.*,ITAD.DataStructure.*,java.text.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></head>
<body>

<!-------------------------------------------------------------------------------------------------------------------------------------->

<jsp:useBean id="eqp" class="ITAD.EQP"/> <jsp:setProperty property="*" name="eqp" />
<jsp:useBean id="user" class="ITAD.User"/> <jsp:setProperty property="*" name="user" />
<jsp:useBean id="pc" class="ITAD.PC"/> <jsp:setProperty property="*" name="pc" />
<jsp:useBean id="ast" class="ITAD.COMast"/> <jsp:setProperty property="*" name="ast" />

<%
	System.out.println("1");
	int loginidx=0;

	if( session.getAttribute("LoginedUser") != null ) loginidx = Integer.parseInt(session.getAttribute("LoginedUser").toString());
	else loginidx=999;
	System.out.println("2");
	String msg=""; 
	boolean flag = true;
	int eqpidx = 999;

	if( eqp.getLocation() == 0 ){ msg = msg + "<font color=red>위치가 지정 되지 않았습니다.</font><br>"; flag = false; }
	if( eqp.getEqpcateg() == 0 ){ msg = msg + "<font color=red>제품군이 지정 되지 않았습니다.</font><br>"; flag = false; }
	if( eqp.getSubcate() == 0 ){ msg = msg + "<font color=red>구분이 지정 되지 않았습니다.</font><br>"; flag = false; }
	if( eqp.getVendor() == 0 ){ msg = msg + "<font color=red>거래처가 지정 되지 않았습니다.</font><br>"; flag = false; }
	System.out.println("3");
	if( flag )
	{
		eqp.setSerial(0);
		eqpidx = eqp.InsertEQPdata(user.InsertUserData(), ast.insert(), loginidx  );
		msg = "<font color=red>아래 정보로 등록 되었습니다.</font><br>";
		out.print("<script language=Javascript>	window.onload = function(){ document.success.submit(); }</script>");
		System.out.println("4");
	}
	else
	{
		session.setAttribute("Msg", msg);
		out.print("<script language=Javascript>	window.onload = function(){ document.fail.submit(); }</script>");
	}
	
	
%>

<form name="fail" action="../Enrollment.jsp" method="post" >
<input type=hidden name="msg" value="<%=msg%>">
</form>

<form name="success" action="../Enrollment_Confirm.jsp" method="post" >
<input type=hidden name="SelectValue" value="<%= eqpidx %>">
</form>

<!-------------------------------------------------------------------------------------------------------------------------------------->

</body>
</html>
