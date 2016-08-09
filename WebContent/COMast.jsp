<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*,java.io.*,java.sql.*,MyPack.*,MyPack.DataStructure.*,java.text.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<tr><td width=80> 상세 정보 </td><td></td></tr>
<tr><td>모델명 : </td><td><input type="text" name="model" value=""></td></tr>
<tr><td>제조사 : </td><td><input type="text" name="manufacturer" value=""></td></tr>
<tr><td>비 고 : </td><td><textarea name=memo rows="10" cols="50"></textarea></td></tr>