<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8" import="java.util.*,java.io.*,java.sql.*,MyPack.*,MyPack.DataStructure.*,java.text.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%
	int PageCapa=15, MaxPage, StartRecord, EndRecord, CurrentPage=1;
	String column=null, key=null;

	Vendor vnd = new Vendor(); 
	List<VENDORdata> VenderList = new ArrayList<VENDORdata>(); 
	VenderList = null;

	if( request.getParameter("page")!=null ) CurrentPage = Integer.parseInt(request.getParameter("page"));
	else CurrentPage = 1;

	if( request.getParameter("column")!=null )
		column = request.getParameter("column");
	
	if( request.getParameter("key")!=null )
	{
		key = request.getParameter("key");
		VenderList = vnd.list(column, key);
	}
	else VenderList = vnd.list();
	
	MaxPage = VenderList.size()/PageCapa + 1;
	StartRecord = (CurrentPage-1) * PageCapa;
	EndRecord = StartRecord + PageCapa - 1;
%>

<table cellspacing=0 >
<tr><td colspan=4 align=center>거래처 리스트</td></tr>
<tr><td colspan=4 ><input type="button" value="추가" onclick="popup('pop', 'ppVendorsAdd.jsp','')"></td></tr>
<tr>
<td align=right colspan=4><input type=hidden name="column" id="siba" value="DESCR"> 상호
<input id="searchbox" type="text" name="key" onKeydown="javascript:if(event.keyCode == 13) Search_Vendor();">
<input type="button" value="검색" onclick="Search_Vendor()">
</td>
</tr>


<tr>
<td style="display:none"></td>
<th>상호</th>
<th>사업자번호</th>
<th>담당자</th>
</tr>

<c:forEach var="index" items="<%=VenderList %>" begin="<%=StartRecord %>" end="<%=EndRecord %>">

<tr id=ulrow style="cursor:pointer;" onmouseover="showProp(this, this.cells)" onclick="VendorSelect(this.cells)">
<td style="display:none"></td>
<td id=ulidx hidden=true >${index.idx}</td>
<td id=ulcode hidden=true >${index.code}</td>
<td >${index.descr}</td>
<td >${index.corpno}</td>
<td hidden=true >${index.addr}</td>
<td hidden=true>${index.type}</td>
<td id=uldept>${index.manager}</td>
</tr>

</c:forEach>
</table>
<br>

<c:forEach var="pageno" begin="1" end="<%=MaxPage %>">
<input type="button" onclick = "Change_Page('popuplayer', this.value)" value="${pageno}">
</c:forEach>

<input type="hidden" name="page" value="">

