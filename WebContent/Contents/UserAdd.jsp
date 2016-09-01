<%@ page pageEncoding="UTF-8" %>
<<<<<<< HEAD
<%@ include file="../toppage.jsp" %>
<%	User user = new User(); %>
<c:set value="<%=user%>" var="user" scope="page" />

<script>
window.onload=function()
{

}
</script>

<table class="infobox">
	<tr><td colspan=6 >신규 등록 <input type=hidden name="idx" value="${user.idx}"></td></tr>
	<tr>
		
		<td align=right>이름 : </td><td><input type=text name="name" style="width:80px" value="${user.name}"></td>
		<td align=right>직책 : </td><td>${user.TAGusrPosition}</td>
		<td align=right>소속 : </td><td>${user.TAGusrDept}</td>
	</tr>
	<tr>
		<td align=right>아이디 : </td><td><input type=text name="ID" style="width:80px" value="${user.ID}" ></td>
		<td align=right>사용여부 : </td><td>${user.TAGstate}</td>
		<td align=right>권한 : </td><td>${user.TAGpermission}</td>
	</tr>
	<tr>
		<td align=right>패스워드 : </td><td><input type=text name="password" style="width:80px"  value="${user.password}"></td>
		<td align=right>Mobile : </td><td><input type=text name="mobile" style="width:80px" value="${user.mobile}"></td>
		<td align=right colspan=2> <input type=button value="추가" style="width:100px" onclick="Move(this, 'UserAdd_OK.jsp')"></td>
	</tr>
</table>

<%@ include file="../bottompage.jsp" %>
=======
<%@ include file="toppage.jsp" %>
<%	User user = new User(); %>
<c:set value="<%=user%>" var="user" scope="page" />

<script>
window.onload=function()
{

}
</script>

<table class="infobox">
	<tr><td colspan=6 >신규 등록 <input type=hidden name="idx" value="${user.idx}"></td></tr>
	<tr>
		
		<td align=right>이름 : </td><td><input type=text name="name" style="width:80px" value="${user.name}"></td>
		<td align=right>직책 : </td><td>${user.TAGusrPosition}</td>
		<td align=right>소속 : </td><td>${user.TAGusrDept}</td>
	</tr>
	<tr>
		<td align=right>아이디 : </td><td><input type=text name="ID" style="width:80px" value="${user.ID}" ></td>
		<td align=right>사용여부 : </td><td>${user.TAGstate}</td>
		<td align=right>권한 : </td><td>${user.TAGpermission}</td>
	</tr>
	<tr>
		<td align=right>패스워드 : </td><td><input type=text name="password" style="width:80px"  value="${user.password}"></td>
		<td align=right>Mobile : </td><td><input type=text name="mobile" style="width:80px" value="${user.mobile}"></td>
		<td align=right colspan=2> <input type=button value="추가" style="width:100px" onclick="Move(this, 'UserAdd_OK.jsp')"></td>
	</tr>
</table>

<%@ include file="/bottompage.jsp" %>
>>>>>>> branch 'master' of https://github.com/rn4r10ne77e/ITAD.git
