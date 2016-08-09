<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*,java.io.*,java.sql.*,MyPack.*,MyPack.DataStructure.*,java.text.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<tr><td width=100> 상세 정보 </td><td></td></tr>
<tr><td>MacAddress : </td><td><input type="text" name="maddr" value="<%=request.getParameter("MAtab")!=null?request.getParameter("MAtab"):"" %>"></td></tr>
<tr><td>IP Address : </td><td><input type="text" name="IPAddress" value="<%=request.getParameter("IPtab")!=null?request.getParameter("IPtab"):"" %>"></td></tr>
<tr><td>Host Name  : </td><td><input type="text" name="HName" value="<%=request.getParameter("HNtab")!=null?request.getParameter("HNtab"):"" %>"></td></tr>
<tr><td>MBoard S/N : </td><td><input type="text" name="MBserial" value="<%=request.getParameter("MBoardSN")!=null?request.getParameter("MBoardSN"):"" %>"></td></tr>
<tr><td>OS 정보 : </td><td><input type="text" name="OSname" value="<%=request.getParameter("OSinfo")!=null?request.getParameter("OSinfo"):"" %>"></td></tr>
<tr><td>CPU : </td><td><input type="text" name="CPUname" value="<%=request.getParameter("CPUname")!=null?request.getParameter("CPUname"):"" %>"></td></tr>
<tr><td>LAM : </td><td><input type="text" name="LAMcapa" value="<%=request.getParameter("LAMcapa")!=null?request.getParameter("LAMcapa"):"" %>"></td></tr>
<tr><td>HDD S/N : </td><td><input type="text" name="HDDserial" value="<%=request.getParameter("HDDsn")!=null?request.getParameter("HDDsn"):"" %>"></td></tr>
<tr><td>계정정보 : </td><td><input type="text" name="ADaccnt" value="<%=request.getParameter("Account")!=null?request.getParameter("Account"):"" %>"></td></tr>
<tr><td>기종 : </td><td><input type="text" name="PCmodel" value="<%=request.getParameter("PCmodel")!=null?request.getParameter("PCmodel"):"" %>"></td></tr>
<tr><td>제조사 : </td><td><input type="text" name="PCmanufacturer" value="<%=request.getParameter("Vender")!=null?request.getParameter("Vender"):"" %>"></td></tr>