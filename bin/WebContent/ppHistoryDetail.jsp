<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8" import="java.util.*,java.io.*,java.sql.*,ITAD.*,ITAD.DataStructure.*,java.text.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%
	List<HISTORYDETAIL> list = new ArrayList<HISTORYDETAIL>();
	int idx = Integer.parseInt(request.getParameter("IDX").toString());
	String content="";

	History hstr = new History();
	list = hstr.LoadHistoryDetail(idx);

	for( int i=0 ; i<list.size() ; i++ )
	{
		content = content + "<P color=gray>"+list.get(i).getItem() +" : "+list.get(i).getValuefrom()+" -> "+list.get(i).getValueto()+"</p>";				
	}

	out.print("<td colspan=3 ></td><td>"+content+"</td>");
%>
