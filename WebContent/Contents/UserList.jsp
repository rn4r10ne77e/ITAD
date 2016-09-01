<<<<<<< HEAD
<%@ include file="../toppage.jsp" %>
<%@ page pageEncoding="UTF-8" %>
<%!
	int PageCapa=10, MaxPage, StartRecord, EndRecord, CurrentPage;
	String SearchColumn, SearchKeyword;
%>
<%
	List<Userdata> Userlist = new ArrayList<Userdata>();
	User Usr = new User(); Userlist = null;
	User NewUsr = new User();


	if( session.getAttribute("UserListCurrentPage")!= null &&  session.getAttribute("UserListCurrentPage") != "" ) 
		CurrentPage = Integer.parseInt(session.getAttribute("UserListCurrentPage").toString());
	else CurrentPage = 1;
	
	if( session.getAttribute("UserListSearchColumn")!= null && session.getAttribute("UserListSearchColumn") != "" )
		SearchColumn = session.getAttribute("UserListSearchColumn").toString();
		
	if( session.getAttribute("UserListSearchKeyword")!= null && session.getAttribute("UserListSearchKeyword") != "" )
	{
		SearchKeyword = session.getAttribute("UserListSearchKeyword").toString();
		Userlist = Usr.LoadUserList(SearchColumn, SearchKeyword);
	}
	else Userlist = Usr.LoadUserList();

	MaxPage = Userlist.size()/PageCapa + 1;
	StartRecord = (CurrentPage-1) * PageCapa;
	EndRecord = StartRecord + PageCapa - 1;
%>

<table style="width:100%">
<tr style="width:100%">
<td>

<table class="infobox">
	<tr><td colspan=6 >신규 등록 <input type=hidden name="idx" value="${user.idx}"></td></tr>
	<tr>
		
		<td align=right>이름 : </td><td><input type=text name="name" style="width:80px" value="${Newusr.name}"></td>
		<td align=right>직책 : </td><td>${Newusr.TAGusrPosition}</td>
		<td align=right>소속 : </td><td>${Newusr.TAGusrDept} </td>
	</tr>
	<tr>
		<td align=right>아이디 : </td><td><input type=text name="ID" style="width:80px" value="${Newusr.ID}" ></td>
		<td align=right>사용여부 : </td><td>${Newusr.TAGstate}</td>
		<td align=right>권한 : </td><td>${Newusr.TAGpermission}</td>
	</tr>
	<tr>
		<td align=right>패스워드 : </td><td><input type=text name="password" style="width:80px"  value="${Newusr.password}"></td>
		<td align=right>Mobile : </td><td><input type=text name="mobile" style="width:80px" value="${Newusr.mobile}"></td>
		<td align=right colspan=2> <input type=button value="추가" style="width:100px" onclick="Move(this, 'UserAdd_OK.jsp')"></td>
	</tr>
</table>



</td><td valign=bottom align=right >

<table>
	<tr>
		<td align=right>
		검색 
		<select name="searchcolumn">
			<option value="NAME">이름</option>
			<option value="MOBILE">휴대폰</option>
			<option value="ID">아이디</option> 
		</select>
		
		<input type="text" name="searchkeyword" value="" onKeydown="javascript:if(event.keyCode == 13) Move(this, 'UserList_OK.jsp');">
		<input type="button" value="검색" onclick="Move(this, 'UserList_OK.jsp')">
		</td>
	</tr>
</table>

</td>
</tr>
</table>




<table style="width:100%; table-layout:inherit;">
<tr>
<td colspan=8>
<br>
사용자 목록을 표시 합니다.<br>
사용자를 선택 하여 속성 값들을 수정 할 수 있고 사용자가 가지고 있는 장비들을 조회 할 수 있습니다.<br>
<br>
</td>
</tr>

<tr>
<th style="display:none"></th>
<th>아이디</th>
<th>이름</th>
<th>직책</th>
<th>소속</th>
<th>계정 상태</th>
<th>사용 권한</th>

</tr>

<c:forEach var="index" items="<%=Userlist %>" begin="<%=StartRecord %>" end="<%=EndRecord %>">
<tr style="cursor:pointer;"  onmouseover="showProp(this, this.cells)" onclick="Move(this,'UserEdit.jsp')">
<td class="lrow" style="display:none" ><input type="radio" name="SelectValue" value="${index.idx}" style="display:none" ></td>
<td class="lrow">${index.ID}</td>
<td class="lrow">${index.name}</td>
<td class="lrow">${index.STRusrPosition}</td>
<td class="lrow">${index.STRusrDept}</td>
<td class="lrow">${index.STRstate}</td>
<td class="lrow">${index.STRpermission}</td>
</tr>
</c:forEach>


<tr><td align=center colspan=6> 
	<c:set var="page" value="<%=CurrentPage%>" />
	<c:set var="maxpage" value="<%=MaxPage %>" />
	<table><tr>
	<c:forEach var="no" begin="1" end="5">
	<td name="pagenumber">
	
	<c:if test="${page+no-3 > 0 && page+no-3 <= maxpage}">
		<input type="button" onclick = "MovePage(this, 'PCList.jsp')" value="${page+no-3}">
	</c:if>
	
	</td>
	</c:forEach>
	<c:if test="${maxpage > 1}">
	<td> ... </td><td><input type="button" onclick = "MovePage(this, 'PCList.jsp')" value="${maxpage}"></td>
	</c:if>
	</tr></table>
</td></tr>
</table>
<br>


<%@ include file="../bottompage.jsp" %>
=======
<%@ include file="toppage.jsp" %>
<%@ page pageEncoding="UTF-8" %>
<%!
	int PageCapa=10, MaxPage, StartRecord, EndRecord, CurrentPage;
	String SearchColumn, SearchKeyword;
%>
<%
	List<Userdata> Userlist = new ArrayList<Userdata>();
	User Usr = new User(); Userlist = null;
	User NewUsr = new User();


	if( session.getAttribute("UserListCurrentPage")!= null &&  session.getAttribute("UserListCurrentPage") != "" ) 
		CurrentPage = Integer.parseInt(session.getAttribute("UserListCurrentPage").toString());
	else CurrentPage = 1;
	
	if( session.getAttribute("UserListSearchColumn")!= null && session.getAttribute("UserListSearchColumn") != "" )
		SearchColumn = session.getAttribute("UserListSearchColumn").toString();
		
	if( session.getAttribute("UserListSearchKeyword")!= null && session.getAttribute("UserListSearchKeyword") != "" )
	{
		SearchKeyword = session.getAttribute("UserListSearchKeyword").toString();
		Userlist = Usr.LoadUserList(SearchColumn, SearchKeyword);
	}
	else Userlist = Usr.LoadUserList();

	MaxPage = Userlist.size()/PageCapa + 1;
	StartRecord = (CurrentPage-1) * PageCapa;
	EndRecord = StartRecord + PageCapa - 1;
%>

<table style="width:100%">
<tr style="width:100%">
<td>

<table class="infobox">
	<tr><td colspan=6 >신규 등록 <input type=hidden name="idx" value="${user.idx}"></td></tr>
	<tr>
		
		<td align=right>이름 : </td><td><input type=text name="name" style="width:80px" value="${Newusr.name}"></td>
		<td align=right>직책 : </td><td>${Newusr.TAGusrPosition}</td>
		<td align=right>소속 : </td><td>${Newusr.TAGusrDept} </td>
	</tr>
	<tr>
		<td align=right>아이디 : </td><td><input type=text name="ID" style="width:80px" value="${Newusr.ID}" ></td>
		<td align=right>사용여부 : </td><td>${Newusr.TAGstate}</td>
		<td align=right>권한 : </td><td>${Newusr.TAGpermission}</td>
	</tr>
	<tr>
		<td align=right>패스워드 : </td><td><input type=text name="password" style="width:80px"  value="${Newusr.password}"></td>
		<td align=right>Mobile : </td><td><input type=text name="mobile" style="width:80px" value="${Newusr.mobile}"></td>
		<td align=right colspan=2> <input type=button value="추가" style="width:100px" onclick="Move(this, 'UserAdd_OK.jsp')"></td>
	</tr>
</table>



</td><td valign=bottom align=right >

<table>
	<tr>
		<td align=right>
		검색 
		<select name="searchcolumn">
			<option value="NAME">이름</option>
			<option value="MOBILE">휴대폰</option>
			<option value="ID">아이디</option> 
		</select>
		
		<input type="text" name="searchkeyword" value="" onKeydown="javascript:if(event.keyCode == 13) Move(this, 'UserList_OK.jsp');">
		<input type="button" value="검색" onclick="Move(this, 'UserList_OK.jsp')">
		</td>
	</tr>
</table>

</td>
</tr>
</table>




<table style="width:100%; table-layout:inherit;">
<tr>
<td colspan=8>
<br>
사용자 목록을 표시 합니다.<br>
사용자를 선택 하여 속성 값들을 수정 할 수 있고 사용자가 가지고 있는 장비들을 조회 할 수 있습니다.<br>
<br>
</td>
</tr>

<tr>
<th style="display:none"></th>
<th>아이디</th>
<th>이름</th>
<th>직책</th>
<th>소속</th>
<th>계정 상태</th>
<th>사용 권한</th>

</tr>

<c:forEach var="index" items="<%=Userlist %>" begin="<%=StartRecord %>" end="<%=EndRecord %>">
<tr style="cursor:pointer;"  onmouseover="showProp(this, this.cells)" onclick="Move(this,'UserEdit.jsp')">
<td class="lrow" style="display:none" ><input type="radio" name="SelectValue" value="${index.idx}" style="display:none" ></td>
<td class="lrow">${index.ID}</td>
<td class="lrow">${index.name}</td>
<td class="lrow">${index.STRusrPosition}</td>
<td class="lrow">${index.STRusrDept}</td>
<td class="lrow">${index.STRstate}</td>
<td class="lrow">${index.STRpermission}</td>
</tr>
</c:forEach>


<tr><td align=center colspan=6> 
	<c:set var="page" value="<%=CurrentPage%>" />
	<c:set var="maxpage" value="<%=MaxPage %>" />
	<table><tr>
	<c:forEach var="no" begin="1" end="5">
	<td name="pagenumber">
	
	<c:if test="${page+no-3 > 0 && page+no-3 <= maxpage}">
		<input type="button" onclick = "MovePage(this, 'PCList.jsp')" value="${page+no-3}">
	</c:if>
	
	</td>
	</c:forEach>
	<c:if test="${maxpage > 1}">
	<td> ... </td><td><input type="button" onclick = "MovePage(this, 'PCList.jsp')" value="${maxpage}"></td>
	</c:if>
	</tr></table>
</td></tr>
</table>
<br>


<%@ include file="bottompage.jsp" %>
>>>>>>> branch 'master' of https://github.com/rn4r10ne77e/ITAD.git
