<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8" import="java.util.*,java.io.*,java.sql.*,MyPack.*,MyPack.DataStructure.*,java.text.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%
	int PageCapa=15, MaxPage, StartRecord, EndRecord, CurrentPage=1;
	String SearchColumn=null, SearchKeyword=null;
	
	User user = new User(); List<Userdata> UserList = new ArrayList<Userdata>(); UserList = null;
	
	if( request.getParameter("selectpage")!=null )
		CurrentPage = Integer.parseInt(request.getParameter("selectpage"));
	else CurrentPage = 1;

	if( request.getParameter("searchcolumn")!=null )
		SearchColumn = request.getParameter("searchcolumn");
	
	if( request.getParameter("searchkeyword")!=null )
	{
		SearchKeyword = request.getParameter("searchkeyword");
		UserList = user.LoadUserList(SearchColumn, SearchKeyword);
	}
	else UserList = user.LoadUserList();
	

	MaxPage = UserList.size()/PageCapa + 1;
	StartRecord = (CurrentPage-1) * PageCapa;
	EndRecord = StartRecord + PageCapa - 1;
%>

<table cellspacing=0 >
<tr><td colspan=4 align=center>사용자 리스트</td></tr>
<tr>
<td align=right colspan=4>
<select name="searchcolumn" id="siba">
<option value="NAME">이름</option>
</select>
<input id="searchbox" type="text" name="searchkeyword" onKeydown="javascript:if(event.keyCode == 13) Search_User();">
<input type="button" value="검색" onclick="Search_User()">
</td>
</tr>


<tr>
<td style="display:none"></td>
<th>아이디</th>
<th>이름</th>
<th>소속</th>
</tr>

<c:forEach var="index" items="<%=UserList %>" begin="<%=StartRecord %>" end="<%=EndRecord %>">

<tr id=ulrow style="cursor:pointer;" onmouseover="showProp(this, this.cells)" onclick="Selected_User(this.cells)">
<td style="display:none"><input type="hidden" id="ulselect" value="${index.idx}"></td>
<td id=ulidx hidden=true >${index.idx}</td>
<td id=ulid >${index.ID}</td>
<td id=ulname >${index.name}</td>
<td id=ulposition hidden=true >${index.usrPosition}</td>
<td id=ulstrdept >${index.STRusrDept}</td>
<td id=uldept hidden=true >${index.usrDept}</td>
</tr>

</c:forEach>
</table>
<br>

<c:forEach var="pageno" begin="1" end="<%=MaxPage %>">
<input type="button" onclick = "Change_Page('popuplayer', this.value)" value="${pageno}">
</c:forEach>

<input type="hidden" name="selectpage" value="">

