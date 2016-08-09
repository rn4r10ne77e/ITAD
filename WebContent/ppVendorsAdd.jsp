<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8" import="java.util.*,java.io.*,java.sql.*,ITAD.*,ITAD.DataStructure.*,java.text.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<table>
<tr><td colspan=2 align=center>거래처 추가</td></tr>
<tr><td colspan=2> 거래처를 추가 하기 위한 정보를 입력 해 주세요.</td></tr>
<tr><th align=right>상 호 : </th><td><input type=text name="descr" id="descr"></td></tr>
<tr><th align=right>사업자 번호 : </th><td><input type=text name="corpno" id="corpno"></td></tr>
<tr><th align=right>담당자 : </th><td><input type=text name="manager" id="manager"></td></tr>
<tr><td colspan=2 align=right><input type=button value="추가" onclick="VendorAdd()"></td></tr>
</table>